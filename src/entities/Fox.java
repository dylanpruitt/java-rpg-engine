package entities;

import items.weapons.Claws;
import skills.Fireball;
import skills.evadeUp;
import utility.randomGenerator;

import java.util.ArrayList;

public class Fox extends Entity {
    public Fox () {
        setName ("Fox");
        setHealth (37);
        setMaxHealth (37);
        setStrength (5);
        setDexterity (4);
        setSpeed (8);
        setMagic (3);
        setCritical (5);
        setEvasion (10);
        setLevel (2);
        setExperience (4);
        setWeapon (new Claws ());
        getWeapon ().skills.add (new evadeUp ());
        getWeapon ().skills.add (new Fireball ());

        resistances.add ("fire");
    }

    @Override
    public void AI (ArrayList<Entity> combatants) {
        int SLASH = 0, EVADE_UP = 1, FIREBALL = 2;

        int randomNumber = randomGenerator.random (1, 100);

        if (getEvasion () < 24) {
            int targetIndex = targetRandomFriend (combatants);
            Entity target = combatants.get (targetIndex);

            getWeapon ().skills.get (EVADE_UP).use (this, target);
        } else {
            if (enemyIsWeakToType (combatants, "fire")) {
                int targetIndex = targetEnemyWithWeakness (combatants, "fire");
                Entity target = combatants.get (targetIndex);

                getWeapon ().skills.get (FIREBALL).use (this, target);
            } else {
                int targetIndex = targetLowestHealthEnemy (combatants);
                Entity target = combatants.get (targetIndex);

                getWeapon ().skills.get (SLASH).use (this, target);
            }

        }

    }

    @Override
    protected void counter (Entity target) {
        System.out.println ("The fox absorbs the attack, and becomes stronger!");

        modifyStrength (randomGenerator.random (5, 8));
    }
}
