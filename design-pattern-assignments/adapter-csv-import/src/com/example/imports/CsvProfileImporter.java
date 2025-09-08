package com.example.imports;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class CsvProfileImporter implements ProfileImporter {
    private final NaiveCsvReader csvReader;
    private final ProfileService profileService;

    public CsvProfileImporter(NaiveCsvReader csvReader, ProfileService profileService) {
        this.csvReader = Objects.requireNonNull(csvReader, "CSV reader cannot be null");
        this.profileService = Objects.requireNonNull(profileService, "Profile service cannot be null");
    }

    @Override
    public int importFrom(Path csvFile) {
        Objects.requireNonNull(csvFile, "CSV file path cannot be null");
        
        List<String[]> rows = csvReader.read(csvFile);
        int importedCount = 0;
        
        for (int i = 0; i < rows.size(); i++) {
            String[] row = rows.get(i);
            try {
                // Skip rows that don't have exactly 3 columns
                if (row.length != 3) {
                    System.err.println("Skipping row " + (i + 1) + ": expected 3 columns, found " + row.length);
                    continue;
                }
                
                String id = row[0].trim();
                String email = row[1].trim();
                String displayName = row[2].trim();
                
                // Skip rows with empty id or email
                if (id.isEmpty() || email.isEmpty()) {
                    System.err.println("Skipping row " + (i + 1) + ": id and email are required");
                    continue;
                }
                
                // Let ProfileService handle email validation
                profileService.createProfile(id, email, displayName);
                importedCount++;
                
            } catch (Exception e) {
                System.err.println("Error processing row " + (i + 1) + ": " + e.getMessage());
            }
        }
        
        return importedCount;
    }
}
