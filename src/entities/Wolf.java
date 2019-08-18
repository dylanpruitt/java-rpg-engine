package entities;

import items.weapons.Claws;
import skills.Agi;
import utility.randomGenerator;

import java.util.ArrayList;

public class Wolf extends Entity {
    public Wolf () {
        setName ("Wolf");
        setHealth (14);
        setMaxHealth (14);
        setStrength (3);
        setDexterity (2);
        setSpeed (3);
        setMagic (0);
        setCritical (5);
        setEvasion (5);
        setLevel (1);
        setExperience (2);
        setWeapon (new Claws ());
        getWeapon ().skills.add (new Agi ());
        weaknesses.add ("fire");

    }

    @Override
    public void AI (ArrayList <Entity> combatants) {
        int SLASH = 0, AGI = 1;

        int randomNumber = randomGenerator.random (1, 100);

        if (randomNumber < 65) {
            randomNumber = randomGenerator.random (1, 2);
            int targetIndex;

            if (randomNumber == 1) {
                targetIndex = targetLowestHealthEnemy (combatants);
            } else {
                targetIndex = targetHighestHealthEnemy (combatants);
            }
            Entity target = combatants.get (targetIndex);

            getWeapon ().skills.get (SLASH).use (this, target);
        } else {
            int targetIndex = targetRandomFriend (combatants);
            Entity target = combatants.get (targetIndex);

            getWeapon ().skills.get (AGI).use (this, target);
        }

    }

}
