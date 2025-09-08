package com.example.render;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TextStyleFactory {
    private static final TextStyleFactory INSTANCE = new TextStyleFactory();
    private final Map<String, TextStyle> styleCache;

    private TextStyleFactory() {
        this.styleCache = new HashMap<>();
    }

    public static TextStyleFactory getInstance() {
        return INSTANCE;
    }

    public TextStyle getTextStyle(String font, int size, boolean bold) {
        Objects.requireNonNull(font, "Font cannot be null");
        String key = String.format("%s|%d|%s", font, size, bold ? "B" : "");
        
        return styleCache.computeIfAbsent(key, k -> new TextStyle(font, size, bold));
    }
}
