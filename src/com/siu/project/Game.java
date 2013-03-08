package com.siu.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Chedly
 * Date: 12/04/12
 * Time: 14:36
 * To change this template use File | Settings | File Templates.
 */
public class Game {

    private Player attacker;
    private Player defender;
    private ArrayList al = new ArrayList();


    private Scanner scanner = new Scanner(System.in);


    public void start() {


//        boolean gameOn;
//        gameOn = true;


        System.out.println("Joueur 1 : tapez votre nom");
        attacker = createPlayer();
        // System.out.println(attacker);


        System.out.println("Joueur 2 : tapez votre nom");
        defender = createPlayer();

        whoWillStart(); // It will determine who will start the game (always attacker);

        System.out.println(attacker.getName() + ", you start the game");
        System.out.println();
        System.out.println();
        System.out.println();
        boolean on = true;


        while (on) {


            showStatus(attacker);
            showStatus(defender);
            if (attacker.isActive()) {


                gameMenu(attacker);
                getPlayerChoice(attacker, defender);
                swap();
            } else {
                attacker.setBlocked(attacker.getBlocked() + 1);
                if (attacker.getBlocked() == 2) {
                    attacker.setBlocked(0);
                    attacker.setActive(true);
                    swap();
                }
            }

        }


    }

    private void showStatus(Player player) {

        System.out.println("Joueur : " + player.getName() + " /// HP restant : " + player.getCharacter().getHp());

    }

    private void getPlayerChoice(Player attacker, Player defender) {
        boolean error = true;
        while (error) {
            switch (getChoice()) {
                case 1:
                    attacker.attack(defender);
                    error = false;
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    break;

                case 2:
                    if (attacker.getItem1() != null) {
                        attacker.getItem1().use(attacker);
                        attacker.setItem1(null);
                        error = false;

                    } else {
                        error = true;
                        System.out.println("This item has already been used, please retype your choice again");
                        System.out.println();
                        System.out.println();
                        System.out.println();
                    }
                    break;
                case 3:
                    if (attacker.getItem2() != null) {
                        attacker.getItem2().use(attacker);
                        attacker.setItem2(null);
                        error = false;
                    } else {
                        error = true;
                        System.out.println("This item has already been used, please retype your choice again");
                        System.out.println();
                        System.out.println();
                        System.out.println();
                    }
                    break;

                default:
                    System.out.println("Le choix ne fait pas partie de la liste");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    error = true;
            }
        }


    }

    private void gameMenu(Player player) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(player.getName() + ": please choose on the available options below-noted \n");
        System.out.println("\t1 - Attack");

        if (player.getItem1() != null) {
            System.out.println("\t2 - use this item: " + player.getItem1().getName());
        }


        if (player.getItem2() != null) {
            System.out.println("\t3 - use this item " + player.getItem2().getName());
        }


    }

    private void whoWillStart() {     // ici on va manipuler des objets locaux ou les objet attacker qu'on a cree

        if (attacker.getCharacter().getAgility() < defender.getCharacter().getAgility()) {
            swap();
        } else if (attacker.getCharacter().getAgility() == defender.getCharacter().getAgility()) {
            if (Math.random() % 2 == 0) {
                swap();
            }
        }

    }

    private void swap() {
        Player temp = attacker;
        attacker = defender;
        defender = temp;
    }

    private Player createPlayer() {

        String joueur = "";
        Character character = null;
        Weapon weapon = null;
        while (joueur.isEmpty()) {
            System.out.print("Nom du joueur : ");
            joueur = scanner.next();
        }


        System.out.println("Veuillez choisir votre classe parmi les choix ci dessous \n");
        System.out.println(" 1 pour Warrior \n");
        System.out.println(" 2 pour Berserk \n");
        System.out.println(" 3 pour Assasin \n");
        boolean error = false;
        int choice = 0;
        do {
            choice = getChoice();

            error = false;
            switch (choice) {
                case 1:
                    character = Character.createWarrior();
                    break;
                case 2:
                    character = Character.createBerserk();
                    break;
                case 3:
                    character = Character.createAssassin();
                    break;
                default:
                    System.out.println("Choice error !!!");

                    error = true;

            }
        } while (error);


        System.out.println("Veuillez choisir votre arme parmi les choix ci dessous \n");
        System.out.println(" 1 pour Epee à 2 main \n");
        System.out.println(" 2 pour Epee à 1 main+ bouclier \n");
        System.out.println(" 3 pour dague \n");
        choice = 0;
        do {

            choice = getChoice();
            switch (choice) {
                case 1:
                    weapon = Weapon.createEpee2Main();
                    break;
                case 2:
                    weapon = Weapon.createEpee1main();
                    break;
                case 3:
                    weapon = Weapon.createDague();
                    break;
                default:
                    error = true;
                    System.out.println(" CHOICE ERROR !");

            }
        } while (error);
        Item item1 = getPlayerItem(1);
        Item item2 = getPlayerItem(2);


        return new Player(joueur, character, weapon, item1, item2);
    }


    private int getChoice() {

        System.out.print(" Tapez votre choix ici :  ");
        try {
            return Integer.valueOf(scanner.next());
        } catch (NumberFormatException e) {
            return 0;
        }

    }

    private Item getPlayerItem(int number) {
        Item item = null;

        System.out.println("Item " + number + " du joueur :");
        System.out.println("\t1 - Potion de vie");
        System.out.println("\t2 - Potion de force");
        System.out.println("\t3 - Potion d\'agilité");
        System.out.println("\t4 - Flash\n");

        while (null == item) {
            switch (getChoice()) {
                case 1:
                    item = Potion.createLifePotion();
                    al.add(item);
                    break;
                case 2:
                    item = Potion.createForcePotion();
                    al.add(item);
                    break;
                case 3:
                    item = Potion.createAgilityPotion();
                    al.add(item);
                    break;
                case 4:

                    item = Flash.createFlash();
                    al.add(item);
                    break;
                default:
                    System.out.println("Le choix ne fait pas partie de la liste");
            }
        }

        return item;
    }

}
