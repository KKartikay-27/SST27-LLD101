package com.example.game;

/**
 * Base decorator class for character enhancements.
 */
public abstract class CharacterDecorator implements Character {
    protected final Character decoratedCharacter;

    public CharacterDecorator(Character decoratedCharacter) {
        this.decoratedCharacter = decoratedCharacter;
    }

    @Override
    public void move() {
        decoratedCharacter.move();
    }

    @Override
    public void attack() {
        decoratedCharacter.attack();
    }

    @Override
    public int getSpeed() {
        return decoratedCharacter.getSpeed();
    }

    @Override
    public int getDamage() {
        return decoratedCharacter.getDamage();
    }

    @Override
    public String getSprite() {
        return decoratedCharacter.getSprite();
    }
}
