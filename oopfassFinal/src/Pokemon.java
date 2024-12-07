// pokemon's basic details

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pokemon {
    private String name;
    private String type;
    private int hp;
    private String attackName;
    private int attackDamage;

    // Constructor to initialize a Pokemon
    public Pokemon(String name, String type, int hp, String attackName, int attackDamage) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.attackName = attackName;
        this.attackDamage = attackDamage;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getHp() {
        return hp;
    }

    public String getAttackName() {
        return attackName;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - HP: %d, Move: %s (%d)", name, type, hp, attackName, attackDamage);
    }

    // METHODS
    public void attack() {
        System.out.println(name + " used " + attackName + "!");
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp <= 0) {
            System.out.println(name + " fainted!");
        } else {
            System.out.println(name + " took " + damage + " damage. Remaining hp: " + hp);
        }
    }
}
