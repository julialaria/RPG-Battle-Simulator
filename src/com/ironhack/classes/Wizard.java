package com.ironhack.classes;

import com.ironhack.interfaces.Atacker;

public class Wizard extends Character implements Atacker {
    private int mana;
    private int intelligence;

    public Wizard(int id, String name, int hp, int mana, int intelligence) {
        super(id, name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    @Override
    public int attack() {
        int damageAttack;
        if(this.mana <= 5){
            damageAttack = fireBall();
        } else{
            damageAttack = staffHit();
        }
        return damageAttack;
    }

    public int fireBall(){
        int damage = this.intelligence;
        this.mana =- 5;
        return damage;
    }

    public int staffHit(){
        int damage = 2;
        this.mana++;
        return damage;
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

    @Override
    public String toString() {
        return "Wizard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", isAlive=" + isAlive +
                ", mana=" + mana +
                ", intelligence=" + intelligence +
                '}';
    }
}
