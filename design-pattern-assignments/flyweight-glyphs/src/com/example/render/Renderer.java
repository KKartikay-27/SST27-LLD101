package com.example.render;

public class Renderer {
    private final TextStyleFactory textStyleFactory;
    
    public Renderer() {
        this.textStyleFactory = TextStyleFactory.getInstance();
    }
    
    public int render(String text) {
        int cost = 0;
        for (char c : text.toCharArray()) {
            // Use flyweight pattern: share TextStyles across Glyphs
            boolean isBold = (c % 7 == 0);
            TextStyle textStyle = textStyleFactory.getTextStyle("Inter", 14, isBold);
            Glyph g = new Glyph(c, textStyle);
            cost += g.drawCost();
        }
        return cost;
    }
}
