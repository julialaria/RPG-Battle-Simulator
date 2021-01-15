package com.ironhack.classes;

import java.util.List;

public class Party {
    private String name;
    private List<Character> characters;

    public Party(String name, List<Character> characters) {
        this.name = name;
        this.characters = characters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
