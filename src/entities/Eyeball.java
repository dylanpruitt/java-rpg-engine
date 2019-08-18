package entities;

import items.weapons.eyeBall;
import utility.randomGenerator;

import java.util.ArrayList;

public class Eyeball extends Entity {
    public Eyeball () {
        setName ("Eyeball");
        setHealth (25);
        setMaxHealth (25);
        setStrength (2);
        setDexterity (3);
        setSpeed (5);
        setMagic (7);
        setCritical (10);
        setEvasion (6);
        setLevel (3);
        setExperience (5);
        setWeapon (new eyeBall ());

        resistances.add ("fire");
        resistances.add ("lightning");

        weaknesses.add ("arcane");
    }

    @Override
    public void AI (ArrayList<Entity> combatants) {
        int GRAVITY = 0, DRAIN = 1, WEAKEN = 2;

        int randomNumber = randomGenerator.random (1, 100);

        if (randomNumber <= 30) {
            int targetIndex = targetRandomFriend (combatants);
            Entity target = combatants.get (targetIndex);

            getWeapon ().skills.get (GRAVITY).use (this, target);

        } else if (randomNumber <= 70) {
            int targetIndex = targetRandomEnemy (combatants);
            Entity target = combatants.get (targetIndex);

            getWeapon ().skills.get (DRAIN).use (this, target);

        } else {
            int targetIndex = targetLowestHealthEnemy (combatants);
            Entity target = combatants.get (targetIndex);

            getWeapon ().skills.get (WEAKEN).use (this, target);

        }

    }

    @Override
    protected void counter (Entity target) {
        System.out.println ("The eyeball fires a beam at " + target.getName () + ". Tney feel weakened.");

        target.statuses.add (new statuses.Drain ());
    }
}
