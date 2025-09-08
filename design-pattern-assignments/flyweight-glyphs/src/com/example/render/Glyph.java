package com.example.render;

public class Glyph {
    private final char ch;  // Extrinsic state
    private final TextStyle textStyle;  // Intrinsic state (shared)

    public Glyph(char ch, TextStyle textStyle) {
        this.ch = ch;
        this.textStyle = textStyle;
    }

    public int drawCost() { 
        return textStyle.getSize() + (textStyle.isBold() ? 10 : 0); 
    }
    
    public char getCh() { 
        return ch; 
    }
    
    public TextStyle getTextStyle() { 
        return textStyle; 
    }
    
    // Delegated methods for backward compatibility
    public String getFont() { return textStyle.getFont(); }
    public int getSize() { return textStyle.getSize(); }
    public boolean isBold() { return textStyle.isBold(); }
}
