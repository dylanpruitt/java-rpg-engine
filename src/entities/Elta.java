package entities;

import items.weapons.Claws;

import java.util.ArrayList;

public class Elta extends Entity {
    public Elta () {
        setName ("Elta");
        setHealth (667);
        setMaxHealth (667);
        setStrength (25);
        setDexterity (25);
        setSpeed (25);
        setMagic (32);
        setCritical (15);
        setEvasion (15);
        setWeapon (new Claws ());

    }

    @Override
    public void AI (ArrayList<Entity> combatants) {
        int SLASH = 0;

        int targetIndex = targetLowestHealthEnemy (combatants);
        Entity target = combatants.get (targetIndex);

        getWeapon ().skills.get (SLASH).use (this, target);
    }
}
