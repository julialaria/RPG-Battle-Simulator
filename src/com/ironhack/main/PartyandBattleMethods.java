package com.ironhack.main;

import com.ironhack.classes.Character;
import com.ironhack.classes.Warrior;
import com.ironhack.classes.Wizard;
import com.ironhack.interfaces.Atacker;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class PartyandBattleMethods {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please introduce a Battle Size: ");
        int batleSize = scan.nextInt();
        ArrayList<Object> party_init1 = new ArrayList<>();
        ArrayList<Object> party_init2 = new ArrayList<>();
        ArrayList<Object> graveyard = new ArrayList<>();
        String[] names_warriors = new String[]{"warrior_a", "warrior_b", "warrior_c", "warrior_d", "warrior_e", "warrior_f", "warrior_g"};
        String[] names_wizards = new String[]{"wizard_a", "wizard_b", "wizard_c", "wizard_d", "wizard_e", "wizard_f", "wizard_g"};

        ArrayList<Object> party1 = load(batleSize, party_init1, names_warriors, names_wizards);
        ArrayList<Object> party2 = load(batleSize, party_init2, names_warriors, names_wizards);

        figth(party1, party2, graveyard);

    }

    private static ArrayList<Object> load(int battle_size, ArrayList<Object> party, String[] names_warriors, String[] names_wizards) {
        int[] randomly = new int[battle_size];
        Random randomNum = new Random();

        for (int i = 0; i < randomly.length; i++) {
            randomly[i] = ThreadLocalRandom.current().nextInt(0, 1 + 1);
            if (randomly[i] == 1) {
                int randomHp = ThreadLocalRandom.current().nextInt(100, 200 + 1);
                int randomStamina = ThreadLocalRandom.current().nextInt(10, 50 + 1);
                int randomStrength = ThreadLocalRandom.current().nextInt(1, 10 + 1);

                party.add(new Warrior(1, names_warriors[randomNum.nextInt(names_warriors.length)], randomHp, randomStamina, randomStrength));
            } else {
                int randomHp = ThreadLocalRandom.current().nextInt(50, 100 + 1);
                int randomMana = ThreadLocalRandom.current().nextInt(10, 50 + 1);
                int randomIntelligence = ThreadLocalRandom.current().nextInt(1, 50 + 1);
                party.add(new Wizard(2, names_wizards[randomNum.nextInt(names_wizards.length)], randomHp, randomMana, randomIntelligence));
            }
        }

        return party;
    }

    private static void figth(ArrayList<Object> party1, ArrayList<Object> party2, ArrayList<Object> graveyard) {
        Object player1 = party1.get(0);
        Object player2 = party2.get(0);

        while (party1.size() > 0 && party2.size() > 0) {
            int damageAttackP1 = ((Atacker) player1).attack();
            ((Character) player2).getHurt(damageAttackP1);
            int damageAttackP2 = ((Atacker) player2).attack();
            ((Character) player1).getHurt(damageAttackP2);
            //System.out.println("player 1 health = " + ((Character) player1).getHp());
            //System.out.println("player 2 health = " + ((Character) player2).getHp());

            if (!((Character) player1).checkAlive()) {
                System.out.println("current player 1 has died");
                graveyard.add(party1.get(0));
                party1.remove(0);
                if (party1.size()>=1){
                    player1 = party1.get(0);
                }
                else{
                    System.out.println("TEAM 1 IS OVER");
                }
            }

            if (!((Character) player2).checkAlive()) {
                System.out.println("current player 2 has died");
                graveyard.add(party1.get(0));
                party2.remove(0);
                if (party2.size()>=1){
                    player2 = party2.get(0);
                }
                else{
                    System.out.println("TEAM 2 IS OVER");
                }
            }
        }
    }
}


