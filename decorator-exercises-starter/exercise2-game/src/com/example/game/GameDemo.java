package com.example.game;

/**
 * Demo showing different character enhancements using the decorator pattern.
 */
public class GameDemo {
    public static void main(String[] args) {
        // Base character with no enhancements
        Character base = new BaseCharacter();

        System.out.println("=== Base Character ===");
        base.move();
        base.attack();

        // 1. Base + SpeedBoost + DamageBoost
        System.out.println("\n=== With Speed and Damage Boosts ===");
        Character buffed = new DamageBoost(
            new SpeedBoost(base, 3), // +3 speed
            5                        // +5 damage
        );
        buffed.move();
        buffed.attack();

        // 2. Add GoldenAura (which also gives +2 speed and +5 damage)
        System.out.println("\n=== Adding Golden Aura ===");
        Character goldenBuffed = new GoldenAura(buffed);
        goldenBuffed.move();
        goldenBuffed.attack();

        // 3. Remove GoldenAura by going back to the buffed version
        System.out.println("\n=== Removed Golden Aura ===");
        buffed.move();
        buffed.attack();

        // 4. Just GoldenAura on base
        System.out.println("\n=== Just Golden Aura ===");
        Character justGolden = new GoldenAura(new BaseCharacter());
        justGolden.move();
        justGolden.attack();
    }
}
