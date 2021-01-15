package com.ironhack.classes;

import com.ironhack.interfaces.Atacker;

public class Warrior extends Character implements Atacker {
    private int stamina;
    private int strength;

    public Warrior(int id, String name, int hp, int stamina, int strength) {
        super(id, name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

    @Override
    public void attack() {
        if(this.stamina >=5){
            heavyAttack();
        } else{
            weakAttack();
        }
    }

    public void heavyAttack(){
        this.hp =- this.strength;
        this.stamina =- 5;
    }

    public void weakAttack(){
        this.hp =- Math.round(this.strength /2);
        this.stamina++ ;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }


}

