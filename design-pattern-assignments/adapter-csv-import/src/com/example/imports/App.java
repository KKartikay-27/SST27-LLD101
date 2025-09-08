package com.example.imports;

import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("CSV file path is required");
        }
        
        Path csv = Path.of(args[0]);
        ProfileImporter importer = new CsvProfileImporter(new NaiveCsvReader(), new ProfileService());
        int importedCount = importer.importFrom(csv);
        System.out.println("Imported " + importedCount + " profiles");
    }
}
