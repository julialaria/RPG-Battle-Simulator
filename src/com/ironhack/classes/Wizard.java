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
    public void attack() {
        if(this.mana <= 5){
            fireBall();
        } else{
            staffHit();
        }
    }

    public void fireBall(){
        this.hp =- this.intelligence;
        this.mana =- 5;
    }

    public void staffHit(){
        this.hp =- 2;
        this.mana++;
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
