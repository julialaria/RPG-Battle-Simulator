package com.ironhack.classes;

import com.ironhack.interfaces.Attacker;

public class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;

    public Wizard(int id, String name, int hp, int mana, int intelligence) {
        super(id, name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    @Override
    public int getPointsForAttack() {
        if (this.mana <= 5) {
            return fireBall();
        } else {
            return staffHit();
        }
    }

    //El daño de una bola de fuego es igual a su inteligencia y cada bola de fuego disminuirá su maná en 5 puntos.
    public int fireBall() {
        this.mana = -5;
        return this.intelligence;
    }

    //El daño de un golpe de bastón es igual a 2. Cada golpe de bastón recuperará su maná en 1.
    public int staffHit() {
        this.mana++;
        return this.intelligence;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

}
