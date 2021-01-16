package com.ironhack.classes;

import com.ironhack.interfaces.Atacker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Battle {

    public static int TIE = 0;
    public static int FIRST_CHARACTER_WIN = 1;
    public static int SECOND_CHARACTER_WIN = 2;

    private Party firstParty;
    private Party secondParty;
    private List<Character> graveyard = new ArrayList<>();

    public Battle(Party firstParty, Party secondParty) {
        this.firstParty = firstParty;
        this.secondParty = secondParty;
    }

    public Party fight() {
        Scanner scanner = new Scanner(System.in);
        //Mientras ambas partys tengan luchadores no se acaba la batalla
        while (firstParty.hasRemainingCharacters() && secondParty.hasRemainingCharacters()) {
            //Imprimimos informacion de la pimera party para poder elegir un personaje
            System.out.println("Select a character from first party to fight by position");
            firstParty.printCharactersInfo();
            int selectedFighterFirstParty = scanner.nextInt();
            //Imprimimos informacion del segundo party para poder elegir un personaje
            System.out.println("Select a character from second party to fight by position");
            secondParty.printCharactersInfo();
            int selectedFighterSecondParty = scanner.nextInt();
            //Recuperamos los dos luchadores
            Character firstFighter = firstParty.getCharacters().get(selectedFighterFirstParty);
            Character secondFighter = secondParty.getCharacters().get(selectedFighterSecondParty);
            //Hacemos la lucha y obtenemos el resultado, 0 empate, 1 gana primero, 2 gana segundo
            int result = fight(firstFighter, secondFighter);
            if (result == 1) {
                //Si gana el primero, el segundo va al graveyard y se elimina de su party
                graveyard.add(secondFighter);
                secondParty.removeCharacter(secondFighter);
            } else if (result == 2) {
                //Si gana el segundo, el primero va al graveyard y se elimina de su party
                graveyard.add(firstFighter);
                firstParty.removeCharacter(firstFighter);
            }
            //Si es empate no se borra nadie y ninguno va al graveyard o eso entiendo
        }
        //Si hemos salido del while es que uno de los dos no tiene personajes, devolvemos el ganador.
        if (firstParty.hasRemainingCharacters()) {
            return firstParty;
        } else {
            return secondParty;
        }
    }

    public int fight(Character firstFighter, Character secondFighter) {
        //Mientras los dos personajes esten vivos luchamos
        while (firstFighter.isAlive && secondFighter.isAlive) {
            firstFighter.getHurt(((Atacker) secondFighter).attack());
            secondFighter.getHurt(((Atacker) firstFighter).attack());
            firstFighter.checkAlive();
            secondFighter.checkAlive();
        }

        //Si los dos mueren es empate.
        if (!firstFighter.isAlive && !secondFighter.isAlive) return TIE;
        if (firstFighter.isAlive) {
            return FIRST_CHARACTER_WIN;
        } else {
            return SECOND_CHARACTER_WIN;
        }
    }

    public Party getFirstParty() {
        return firstParty;
    }

    public void setFirstParty(Party firstParty) {
        this.firstParty = firstParty;
    }

    public Party getSecondParty() {
        return secondParty;
    }

    public void setSecondParty(Party secondParty) {
        this.secondParty = secondParty;
    }

    public List<Character> getGraveyard() {
        return graveyard;
    }

    public void setGraveyard(List<Character> graveyard) {
        this.graveyard = graveyard;
    }
}

