package com.ironhack.classes;

public abstract class Character {
    protected int id;
    protected String name;
    protected int hp;
    protected boolean isAlive;

    public Character(int id, String name, int hp) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.isAlive = true;
    }

    public boolean checkAlive() {
        if (this.hp > 0) {
            this.isAlive = true;
        } else {
            this.isAlive = false;
        }
        return this.isAlive;
    }

    public void getHurt(int damageAttack) {
        this.hp -= damageAttack;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
