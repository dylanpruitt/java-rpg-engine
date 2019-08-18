package entities;

import items.Item;
import items.weapons.Weapon;
import skills.useItem;
import statuses.Status;
import utility.randomGenerator;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Entity {

    private String name = "Entity";
    private String faction = "enemy";
    
    private int level = 1;
    private int experience = 0;
    
    private int health = 14;
    private int maxHealth = 14;

    private int strength = 8;
    private int dexterity = 3;
    private int magic = 1;

    private int speed = 4;
    private int evasionPercent = 7;
    private int criticalHitPercent = 3;

    private int cooldown = 50;

    private boolean isPlayedByHuman = false;

    private Weapon weapon;

    public ArrayList <Item> inventory = new ArrayList <> ();

    public ArrayList <Status> statuses = new ArrayList <> ();

    public ArrayList <String> weaknesses = new ArrayList <> ();
    public ArrayList <String> resistances = new ArrayList <> ();

    public void setName (String newName) { name = newName; }
    public String getName () { return name; }

    public void setFaction (String newFaction) { faction = newFaction; }
    public String getFaction () { return faction; }

    public void setLevel (int amount) { level = amount; }
    public int getLevel () { return level; }
    public void modifyLevel (int amount) { level += amount; }

    public void levelUp () {
        level++;
        System.out.println (name + " leveled up! Now level " + level);

        int BASE_HEALTH_GAIN = 2;
        double healthFactor = (randomGenerator.random (100, 120) / 100.00);

        int previousMaxHealth = maxHealth;
        maxHealth += BASE_HEALTH_GAIN;
        maxHealth *= healthFactor;
        health = maxHealth;

        int healthGain = maxHealth - previousMaxHealth;
        System.out.println ("+" + healthGain + " HP!");

        int strengthGain = randomGenerator.random (0, 1);
        strength += strengthGain;
        System.out.println ("+" + strengthGain + " Strength!");

        int dexterityGain = randomGenerator.random (0, 1);
        dexterity += dexterityGain;
        System.out.println ("+" + dexterityGain + " Dexterity!");

        int magicGain = randomGenerator.random (0, 1);
        magic += magicGain;
        System.out.println ("+" + magicGain + " Magic!");

        int speedGain = randomGenerator.random (0, 1);
        speed += speedGain;
        System.out.println ("+" + speedGain + " Speed!");

    }

    public void setExperience (int amount) { experience = amount; }
    public int getExperience () { return experience; }
    public void modifyExperience (int amount) { experience += amount; }

    public void setHealth (int amount) { health = amount; }
    public void setMaxHealth (int amount) { maxHealth = amount; }

    public int getHealth () { return health; }
    public int getMaxHealth () { return maxHealth; }

    public void modifyHealth (int amount) { health += amount; }
    public void modifyMaxHealth (int amount) { maxHealth += amount; }

    public void setStrength (int amount) { strength = amount; }
    public int getStrength () { return strength; }
    public void modifyStrength (int amount) { strength += amount; }

    public void setDexterity (int amount) { dexterity = amount; }
    public int getDexterity () { return dexterity; }
    public void modifyDexterity (int amount) { dexterity += amount; }

    public void setMagic (int amount) { magic = amount; }
    public int getMagic () { return magic; }
    public void modifyMagic (int amount) { magic += amount; }

    public void setSpeed (int amount) { speed = amount; }
    public int getSpeed () { return speed; }
    public void modifySpeed (int amount) { speed += amount; }

    public void setEvasion (int amount) { evasionPercent = amount; }
    public int getEvasion () { return evasionPercent; }
    public void modifyEvasion (int amount) { evasionPercent += amount; }

    public void setCritical (int amount) { criticalHitPercent = amount; }
    public int getCritical () { return criticalHitPercent; }
    public void modifyCritical (int amount) { criticalHitPercent += amount; }

    public void setCooldown (int amount) { cooldown = amount; }
    public int getCooldown () { return cooldown; }
    public void modifyCooldown (int amount) { cooldown += amount; }

    public void setWeapon (Weapon newWeapon) {
        weapon = new Weapon (newWeapon);
        weapon.onEquip (this);
    }
    public Weapon getWeapon () { return weapon; }

    public void setHumanPlayer (boolean bool) { isPlayedByHuman = bool; }
    public boolean getHumanPlayer () { return isPlayedByHuman; }

    public void AI (ArrayList <Entity> combatants) {

    }

    int targetLowestHealthEnemy (ArrayList <Entity> combatants) {
        int lowestValidHealthValue = 10000, lowestHealthIndex = 0;

        for (int i = 0; i < combatants.size (); i++) {
            if (!combatants.get (i).faction.equals (faction)) {
                if (combatants.get (i).getHealth () < lowestValidHealthValue && combatants.get (i).getHealth () > 0) {
                    lowestValidHealthValue = combatants.get (i).getHealth ();
                    lowestHealthIndex = i;
                }
            }
        }

        return lowestHealthIndex;
    }

    int targetHighestHealthEnemy (ArrayList <Entity> combatants) {
        int highestValidHealthValue = 0, highestHealthIndex = 0;

        for (int i = 0; i < combatants.size (); i++) {
            if (!combatants.get (i).faction.equals (faction)) {
                if (combatants.get (i).getHealth () > highestValidHealthValue) {
                    highestValidHealthValue = combatants.get (i).getHealth ();
                    highestHealthIndex = i;
                }
            }
        }

        return highestHealthIndex;
    }

    int targetRandomEnemy (ArrayList <Entity> combatants) {
        ArrayList <Integer> validIndices = new ArrayList <> ();

        for (int i = 0; i < combatants.size (); i++) {
            if (!combatants.get (i).faction.equals (faction)) {
                validIndices.add (i);
            }
        }

        int randomIndex = randomGenerator.random (0, validIndices.size () - 1);

        return validIndices.get (randomIndex);
    }

    int targetRandomFriend (ArrayList <Entity> combatants) {
        ArrayList <Integer> validIndices = new ArrayList <> ();

        for (int i = 0; i < combatants.size (); i++) {
            if (combatants.get (i).faction.equals (faction)) {
                validIndices.add (i);
            }
        }

        int randomIndex = randomGenerator.random (0, validIndices.size () - 1);

        return validIndices.get (randomIndex);
    }

    int targetEnemyWithWeakness (ArrayList <Entity> combatants, String type) {
        for (int i = 0; i < combatants.size (); i++) {
            if (!combatants.get (i).faction.equals (faction) && combatants.get (i).isWeakTo (type)) {
                return i;
            }
        }

        return 0;
    }

    boolean enemyIsWeakToType (ArrayList <Entity> combatants, String type) {
        boolean enemyIsWeak = false;

        for (int i = 0; i < combatants.size (); i++) {
            for (int j = 0; j < combatants.get (i).weaknesses.size (); j++) {
                if (!combatants.get (i).getFaction ().equals (faction) && combatants.get (i).weaknesses.get (j).equals (type)) {
                    enemyIsWeak = true;
                }
            }
        }

        return enemyIsWeak;
    }

    public void damage (Entity target, int amount, String type) {
        int damage = amount;
        int randomNumber = randomGenerator.random (1, 100);
        boolean targetResistedAttack = false;

        if (randomNumber < target.getEvasion ()) {
            System.out.println (target.getName () + " avoided the attack!");
        } else {
            randomNumber = randomGenerator.random (1, 100);
            if (randomNumber < criticalHitPercent) {
                System.out.println ("A critical hit!!!");
                damage *= 2;
            }

            for (int i = 0; i < target.weaknesses.size (); i++) {
                if (target.weaknesses.get (i).equals (type)) {
                    damage *= 2;
                    System.out.println (target.getName () + "'s weakness was found!");
                }
            }

            for (int i = 0; i < target.resistances.size (); i++) {
                if (target.resistances.get (i).equals (type)) {
                    damage /= 4;
                    System.out.println (target.getName () + " resisted the attack!");
                    targetResistedAttack = true;
                }
            }

            System.out.println (target.getName () + " took " + damage + " " + type + " damage!");

            target.modifyHealth (-1 * damage);

            if (targetResistedAttack) {
                target.counter (this);
            }
        }
    }

    protected void counter (Entity target) {

    }

    public void displayInformation () {
        System.out.println (name + " - " + health + " /" + maxHealth + " HP - " + strength + " STR - " + dexterity + " DEX - "
                + magic + " MAG - " + speed + " SPEED | WEAPON - " + weapon.getName ());

        for (int i = 0; i < weapon.skills.size (); i++) {
            System.out.println ("  - " + weapon.skills.get (i).getName ());
        }
    }

    public boolean isAlive () {
        if (health > 0) { return true; } else { return false; }
    }

    public boolean isWeakTo (String type) {
        for (int i = 0; i < weaknesses.size (); i++) {
            if (weaknesses.get (i).equals (type)) {
                return true;
            }
        }
        return false;
    }

}
