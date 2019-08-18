import entities.*;
import items.healthPotion;
import items.weapons.*;
import skills.useItem;
import utility.Input;
import utility.randomGenerator;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public Game () {
        for (int i = 0; i < 3; i++) { createPlayer (); }
    }

    ArrayList <Entity> players = new ArrayList <> ();

    private void createPlayer () {
        System.out.println ("Create a new player from one of the following classes: [1] Swordsman [2] Ranger [3] Mage");
        int choice = Input.getIntegerInputInRange (1, 3);

        Entity player = new Entity ();
        player.setHumanPlayer (true);
        player.setFaction ("player");

        switch (choice) {
            case 1:
                player.setHealth (13);
                player.setMaxHealth (13);
                player.setStrength (4);
                player.setDexterity (1);
                player.setMagic (1);
                player.setSpeed (2);
                player.setEvasion (3);
                player.setCritical (5);
                player.setWeapon (new Sword ());
                break;
            case 2:
                player.setHealth (11);
                player.setMaxHealth (11);
                player.setStrength (2);
                player.setDexterity (4);
                player.setMagic (1);
                player.setSpeed (4);
                player.setEvasion (9);
                player.setCritical (4);
                player.setWeapon (new lightBow ());
                Weapon falconBow = new falconBow ();
                falconBow.skills.add (new useItem ());
                player.inventory.add (falconBow);
                break;
            case 3:
                player.setHealth (8);
                player.setMaxHealth (8);
                player.setStrength (1);
                player.setDexterity (2);
                player.setMagic (4);
                player.setSpeed (3);
                player.setEvasion (9);
                player.setCritical (2);
                player.setWeapon (new fireballTome ());
                Weapon lightningTome = new lightningTome ();
                lightningTome.skills.add (new useItem ());
                player.inventory.add (lightningTome);
                break;
        }

        System.out.println ("What should this player be named? ");
        Scanner scanner = new Scanner (System.in);

        player.setName (scanner.nextLine ());
        for (int i = 0; i < 3; i++) {
            player.inventory.add (new healthPotion ());
        }
        player.getWeapon ().setExperience (35);
        player.getWeapon ().skills.add (new useItem ());
        players.add (player);
    }

    private void displayPlayerInformation () {
        for (int i = 0; i < players.size (); i++) {
            players.get (i).displayInformation ();
        }
    }

    private void displayFactionStatus (String faction, ArrayList <Entity> combatants) {
        for (int i = 0; i < combatants.size (); i++) {
            if (combatants.get (i).getFaction ().equals (faction)) {
                System.out.print (combatants.get (i).getName () + " - " + combatants.get (i).getHealth () + " HP / ");

            }
        }
        System.out.println (" ");
    }

    void loop () {
        while (factionMembersAreRemaining ("player", players)) {
            for (int i = 0; i < players.size (); i++) {
                players.get (i).setHealth (players.get (i).getMaxHealth ());
                System.out.println (players.get (i).getWeapon ().getExperience ());
            }

            ArrayList <Entity> enemies = new ArrayList <> ();

            int randomNumber = randomGenerator.random (1, 100);

            if (randomNumber < 33) {
                enemies.add (new Wolf ());
                enemies.add (new Wolf ());
                enemies.add (new Wolf ());
            } else if (randomNumber < 66) {
                enemies.add (new Wolf ());
                enemies.add (new Bat ());
            } else {
                enemies.add (new dragonWhelp ());
            }

            battle (enemies);
            enemies.clear ();

            displayPlayerInformation ();
        }
    }

    private void battle (ArrayList <Entity> enemies) {
        ArrayList <Entity> combatants = new ArrayList <> ();

        for (int i = 0; i < players.size (); i++) { combatants.add (players.get (i)); }
        for (int i = 0; i < enemies.size (); i++) { combatants.add (enemies.get (i)); }

        for (int i = 0; i < combatants.size (); i++) {
            combatants.get (i).setCooldown (100);
        }

        while (factionMembersAreRemaining("player", combatants) && factionMembersAreRemaining("enemy", combatants)) {
            for (int i = 0; i < players.size (); i++) {
                players.get (i).modifyCooldown (-1 * players.get (i).getSpeed ());
            }
            for (int i = 0; i < enemies.size (); i++) {
                enemies.get (i).modifyCooldown (-1 * enemies.get (i).getSpeed ());
            }

            for (int i = 0; i < players.size (); i++) {
                if (players.get (i).getCooldown () <= 0 && players.get (i).isAlive ()) {
                    for (int j = 0; j < players.get (i).statuses.size (); j++) {
                        players.get (i).statuses.get (j).onTurnBegin (players.get (i));
                        players.get (i).statuses.get (j).decreaseTurnsLeft ();

                        if (players.get (i).statuses.get (j).getTurnsLeft() <= 0) {
                            players.get (i).statuses.remove (j);
                        }
                    }

                    displayFactionStatus ("player", combatants);
                    System.out.println ("vs.");
                    displayFactionStatus ("enemy", combatants);

                    System.out.println (players.get (i).getName () + "'s turn : SKILLS");
                    for (int j = 0; j < players.get (i).getWeapon ().skills.size (); j++) {
                        System.out.println (j + " - " + players.get (i).getWeapon ().skills.get (j).getName ());
                    }

                    int skillIndex = Input.getIntegerInputInRange (0, players.get (i).getWeapon ().skills.size () - 1);

                    ArrayList <Integer> validTargetIndices = new ArrayList <> ();

                    for (int j = 0; j < combatants.size (); j++) {
                        if (combatants.get (j).isAlive ()) {
                            validTargetIndices.add (j);
                        }
                    }

                    int targetIndex = getPlayerTarget (combatants);

                    if (validTargetIndices.size () > 0) {
                        players.get (i).getWeapon ().skills.get (skillIndex).use (players.get (i), combatants.get (validTargetIndices.get (targetIndex)));
                    }
                }
            }

            for (int i = 0; i < enemies.size (); i++) {
                if (enemies.get (i).getHealth () > 0 && enemies.get (i).getCooldown () <= 0) {
                    enemies.get (i).AI (combatants);
                }
            }

        }

        if (factionMembersAreRemaining ("player", combatants)) {
            System.out.println ("You won!");
            for (int i = 0; i < players.size (); i++) {
                players.get (i).getWeapon ().gainExperience ();
                if (players.get (i).getWeapon ().getExperience () > 100) {
                    players.get (i).getWeapon ().setExperience (100);
                }

                for (int j = 0; j < players.get (i).statuses.size (); j++) {
                    players.get (i).statuses.get (j).onBattleEnd (players.get (i));
                }
                players.get (i).statuses.clear ();

                for (int j = 0; j < enemies.size (); j++) {
                    players.get (i).modifyExperience (enemies.get (j).getExperience ());
                    if (players.get (i).getExperience () >
                            players.get (i).getLevel () * players.get (i).getLevel () * 8) {
                        players.get (i).levelUp ();
                    }
                }
            }

        }
    }

    private int getPlayerTarget (ArrayList <Entity> combatants) {
        ArrayList <Integer> validTargetIndices = new ArrayList <> ();
        int targetIndex = 0;

        for (int j = 0; j < combatants.size (); j++) {
            if (combatants.get (j).isAlive ()) {
                validTargetIndices.add (j);
            }
        }

        System.out.println ("Choose a target:");
        if (validTargetIndices.size () > 1) {
            for (int j = 0; j < validTargetIndices.size (); j++) {
                System.out.println (j + " - " + combatants.get (validTargetIndices.get (j)).getName () + " (" +
                        combatants.get (validTargetIndices.get (j)).getHealth () + " HP)");
            }

            targetIndex = Input.getIntegerInputInRange (0, validTargetIndices.size () - 1);
        }

        return targetIndex;
    }

    private boolean factionMembersAreRemaining (String faction, ArrayList <Entity> combatants) {
        boolean membersAlive = false;

        for (int i = 0; i < combatants.size (); i++) {
            if (combatants.get (i).getHealth () > 0 && combatants.get (i).getFaction ().equals (faction)) { membersAlive = true; }
        }

        return membersAlive;
    }

}
