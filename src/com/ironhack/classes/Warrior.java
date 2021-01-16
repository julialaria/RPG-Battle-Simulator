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
    public int attack() {
        int damageAttack;
        if(this.stamina >=5){
            damageAttack = heavyAttack();
        } else{
            damageAttack = weakAttack();
        }
        return damageAttack;
    }

    public int heavyAttack(){
        int damage = this.strength;
        this.stamina =- 5;
        return damage;
    }

    public int weakAttack(){
        int damage = Math.round(this.strength /2);
        this.stamina++ ;
        return damage;
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

    @Override
    public String toString() {
        return "Warrior{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", isAlive=" + isAlive +
                ", stamina=" + stamina +
                ", strength=" + strength +
                '}';
    }
}

