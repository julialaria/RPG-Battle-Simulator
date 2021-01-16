package com.ironhack.main;
import java.util.ArrayList;
import java.util.List;

import com.ironhack.classes.Warrior;
import com.ironhack.classes.Character;
import com.ironhack.classes.Battle;
import com.ironhack.classes.Wizard;
import com.ironhack.classes.Party;



public class Main {
    public static void main(String[] args) {
        //Los personajes se agrupan en grupos y la batalla será entre 2 grupos. Entonces
        //antes de que pueda comenzar la batalla, debes agregar guerreros o magos en ambas partes (el
        //los grupos podían tener cualquier tamaño y se podían mezclar con guerreros y magos).
        List<Character> charactersA = new ArrayList<>();
        List<Character> charactersB = new ArrayList<>();
        //https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java

        //Team A
        Warrior warriorA1 = new Warrior(1, "Warrior A1", 4, 16, 7);
        Wizard wizardA2 = new Wizard(2, "Wizard A2", 3, 36, 9);
        charactersA.add(warriorA1);
        charactersA.add(wizardA2);
        System.out.println("Creación del equipo A");

        //Team B
        Warrior warriorB1 = new Warrior(3, "Warrior B1", 78, 34, 5);
        Wizard wizardB2 = new Wizard(4, "Wizard B2", 67, 25, 8);
        charactersB.add(warriorB1);
        charactersB.add(wizardB2);
        System.out.println("Creación del equipo B");
        Party A = new Party("A", charactersA);
        Party B = new Party("B", charactersB);
        System.out.println("###################");
        System.out.println("Batallas");

        //BATALLA
        Battle battle = new Battle(A, B);
        //Las batallas serán 1 contra 1. Por lo que tendrás que poder elegir entre los miembros
        //del grupo para batirse en duelo con otro miembro del grupo rival.
        battle.round(A.getCharacters().get(1), B.getCharacters().get(0));
        if (A.getCharacters().size() > 0 && B.getCharacters().size() > 0)
            battle.round(A.getCharacters().get(0), B.getCharacters().get(0));
        System.out.println("Final de rondas");
        //Grupo A o B no les queda personaje
        if (((Integer) battle.getFirstParty().getCharacters().size()).equals(0) || ((Integer) battle.getSecondParty().getCharacters().size()).equals(0)) {
            if (((Integer) battle.getFirstParty().getCharacters().size()).equals(battle.getSecondParty().getCharacters().size()))
                System.out.println("Es un empate");
            if (
                    !((Integer) battle.getFirstParty().getCharacters().size()).equals(0)
                            && battle.getFirstParty().getCharacters().size() > battle.getSecondParty().getCharacters().size()
            )
                System.out.println("Ganador A");
            else if (!((Integer) battle.getFirstParty().getCharacters().size()).equals(0))
                System.out.println("Ganador B");
        }

        System.out.println("###################");
        System.out.println("Cementerio");
        for (Character character : battle.getGraveyard()) {
            System.out.println("Muerto => " + character.getName());
        }
    }

}




