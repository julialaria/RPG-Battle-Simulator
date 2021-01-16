package com.ironhack.classes;

import java.util.ArrayList;
import java.util.List;

public class Battle {

    private Party firstParty;
    private Party secondParty;
    private List<Character> graveyard = new ArrayList<>();

    public Battle(Party firstParty, Party secondParty) {
        this.firstParty = firstParty;
        this.secondParty = secondParty;
    }

    //La batalla será por asaltos, en cada asalto ambos combatientes atacarán al mismo
    //tiempo (por lo que incluso si un combatiente da el golpe mortal, ambos recibirán daño). Entonces
    //el combate podría terminar en empate.
    public void round(Character attackerA, Character attackerB) {
        this.attack(attackerA, attackerB);
        this.attack(attackerB, attackerA);
    }

    private void attack(Character attacker, Character receiver) {
        int nPoints = attacker.getPointsForAttack();
        System.out.println("Obtenido los puntos para el ataque");
        receiver.uncreasedHp(nPoints);
        System.out.println("Disminuida la vida del personaje que recibe el ataque en cantidad de puntos de ataque");
        if (!receiver.isAlive) {
            this.removeCharaterFromParty(receiver);
            System.out.println("Eliminado el personaje de la lista a la que corresponde");
            this.graveyard.add(receiver);
            System.out.println("Añadido el personaje al cementerio");
        }
    }

    private void removeCharaterFromParty(Character receiver) {
        int index;
        index = this.firstParty.getCharacters().indexOf(receiver);
        if (index != -1) {
            this.firstParty.getCharacters().remove(index);
        }
        index = this.secondParty.getCharacters().indexOf(receiver);
        if (index != -1) {
            this.secondParty.getCharacters().remove(index);
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
