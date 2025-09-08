package com.example.game;

/**
 * Decorator that increases the character's damage.
 */
public class DamageBoost extends CharacterDecorator {
    private final int damageIncrease;

    public DamageBoost(Character decoratedCharacter, int damageIncrease) {
        super(decoratedCharacter);
        this.damageIncrease = damageIncrease;
    }

    @Override
    public void attack() {
        System.out.println("Attacking with damage " + getDamage() + " (boosted by " + damageIncrease + ") using sprite " + getSprite());
    }

    @Override
    public int getDamage() {
        return super.getDamage() + damageIncrease;
    }
}
