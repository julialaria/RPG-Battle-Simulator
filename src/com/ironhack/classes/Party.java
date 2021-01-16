package com.ironhack.classes;

import java.util.List;

public class Party {
    private String name;
    private List<Character> characters;

    public Party(String name, List<Character> characters) {
        this.name = name;
        this.characters = characters;
    }

    public boolean hasRemainingCharacters(){
        //Comprobamos si tienen luchadores
        return this.characters.size() > 0;
    }

    public void printCharactersInfo(){
        //imprimimos todos los personajes para elijan un luchador
        for (int i = 0; i < this.characters.size(); i++){
            System.out.println(characters.toString());
        }
    }

    public void removeCharacter(Character character){
        this.characters.remove(character);
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

