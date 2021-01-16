package com.ironhack.classes;

import com.ironhack.interfaces.Attacker;

public class Warrior extends Character implements Attacker {
    private int stamina;
    private int strength;

    public Warrior(int id, String name, int hp, int stamina, int strength) {
        super(id, name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

      //En cada asalto, un guerrero intentará realizar un "ataque pesado". Si él no puede hacer un ataque fuerte, hará un "ataque débil".
    @Override
    public int getPointsForAttack() {
        if (this.stamina >= 5) {
            return heavyAttack();
        } else {
            return weakAttack();
        }
    }

    //El daño de un fuerte ataque es igual a su fuerza y cada golpe disminuirá su resistencia en 5 puntos.
    public int heavyAttack() {
        this.stamina = -5;
        return this.strength;
    }

    //El daño de un ataque débil es la mitad de la fuerza (truncar decimales). Cada ataque débil recuperará su resistencia por 1
    public int weakAttack() {
        this.stamina++;
        return Math.round(this.strength / 2);
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

