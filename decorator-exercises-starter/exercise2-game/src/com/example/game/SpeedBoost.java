package com.example.game;

/**
 * Decorator that increases the character's speed.
 */
public class SpeedBoost extends CharacterDecorator {
    private final int speedIncrease;

    public SpeedBoost(Character decoratedCharacter, int speedIncrease) {
        super(decoratedCharacter);
        this.speedIncrease = speedIncrease;
    }

    @Override
    public void move() {
        System.out.println("Moving at speed " + getSpeed() + " (boosted by " + speedIncrease + ") with sprite " + getSprite());
    }

    @Override
    public int getSpeed() {
        return super.getSpeed() + speedIncrease;
    }
}
