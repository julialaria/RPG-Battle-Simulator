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
