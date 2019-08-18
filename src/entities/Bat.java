package entities;

import items.weapons.Claws;
import items.weapons.Fangs;
import skills.Slow;
import utility.randomGenerator;

import java.util.ArrayList;

public class Bat extends Entity {
    public Bat () {
        setName ("Bat");
        setHealth (5);
        setMaxHealth (5);
        setStrength (1);
        setDexterity (2);
        setSpeed (6);
        setMagic (0);
        setCritical (5);
        setEvasion (5);
        setLevel (1);
        setExperience (1);
        setWeapon (new Fangs ());
        getWeapon ().skills.add (new Slow ());

        weaknesses.add ("lightning");
    }

    @Override
    public void AI (ArrayList <Entity> combatants) {
        int LEECH = 0, SLOW = 1;

        int randomNumber = randomGenerator.random (1, 100);

        if (randomNumber < 70) {
            int targetIndex = targetLowestHealthEnemy (combatants);
            Entity target = combatants.get (targetIndex);

            getWeapon ().skills.get (LEECH).use (this, target);
        } else {
            int targetIndex = targetRandomEnemy (combatants);
            Entity target = combatants.get (targetIndex);

            getWeapon ().skills.get (SLOW).use (this, target);
        }

    }
}
