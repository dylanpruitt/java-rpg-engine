package entities;

import items.weapons.dragonTooth;
import utility.randomGenerator;

import java.util.ArrayList;

public class dragonWhelp extends Entity {
    public dragonWhelp () {
        setName ("Dragon Whelp");
        setHealth (56);
        setMaxHealth (56);
        setStrength (6);
        setDexterity (3);
        setSpeed (6);
        setMagic (6);
        setCritical (5);
        setEvasion (5);
        setWeapon (new dragonTooth ());

        resistances.add ("fire");

    }

    @Override
    public void AI (ArrayList<Entity> combatants) {
        int SLASH = 0;

        int targetIndex = targetLowestHealthEnemy (combatants);
        Entity target = combatants.get (targetIndex);

        getWeapon ().skills.get (SLASH).use (this, target);
    }

    @Override
    protected void counter (Entity target) {
        System.out.println ("The dragon whelp counters the attack!\n" +
                "The dragon whelp spews fire at " + target.getName () + "!");

        damage (target, randomGenerator.random (5, 12), "fire");
    }
}
