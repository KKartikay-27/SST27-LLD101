package com.example.game;

/**
 * Decorator that adds a golden aura to the character, enhancing all stats.
 */
public class GoldenAura extends CharacterDecorator {
    private static final int SPEED_BONUS = 2;
    private static final int DAMAGE_BONUS = 5;
    private static final String AURA_SPRITE = "golden_aura.png";

    public GoldenAura(Character decoratedCharacter) {
        super(decoratedCharacter);
    }

    @Override
    public void move() {
        System.out.println("✨ Moving with golden aura at speed " + getSpeed() + " with sprite " + getSprite());
    }

    @Override
    public void attack() {
        System.out.println("✨ Attacking with golden aura, damage " + getDamage() + " using sprite " + getSprite());
    }

    @Override
    public int getSpeed() {
        return super.getSpeed() + SPEED_BONUS;
    }

    @Override
    public int getDamage() {
        return super.getDamage() + DAMAGE_BONUS;
    }

    @Override
    public String getSprite() {
        return AURA_SPRITE;
    }
}
