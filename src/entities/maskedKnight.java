package entities;

import items.weapons.Rapier;
import skills.Agi;
import skills.Fireball;
import skills.Lightning;
import utility.randomGenerator;

import java.util.ArrayList;

public class maskedKnight extends Entity {
    public maskedKnight () {
        setName ("Masked Knight");
        setHealth (125);
        setMaxHealth (125);
        setStrength (17);
        setDexterity (23);
        setSpeed (24);
        setMagic (16);
        setCritical (10);
        setEvasion (10);
        setWeapon (new Rapier ());
        getWeapon ().setExperience (77);
        getWeapon ().skills.add (new Fireball ());
        getWeapon ().skills.add (new Lightning ());
        getWeapon ().skills.add (new Agi ());

        resistances.add ("fire");
    }

    @Override
    public void AI (ArrayList<Entity> combatants) {
        int SLASH = 0, CYCLONESTRIKE = 1, FIREBALL = 2, LIGHTNING = 3, AGI = 4;

        int targetIndex = targetLowestHealthEnemy (combatants);
        Entity target = combatants.get (targetIndex);


        if (getSpeed () < 32 && getHealth () > 90) {
            getWeapon ().skills.get (AGI).use (this, this);
        } else if (target.isWeakTo ("fire")) {
            targetIndex = targetEnemyWithWeakness (combatants, "fire");
            target = combatants.get (targetIndex);
            getWeapon ().skills.get (FIREBALL).use (this, target);
        } else if (target.isWeakTo ("lightning")) {
            targetIndex = targetEnemyWithWeakness (combatants, "lightning");
            target = combatants.get (targetIndex);
            getWeapon ().skills.get (LIGHTNING).use (this, target);
        } else if (target.getHealth () / (double) target.getMaxHealth () < 0.25) {
            getWeapon ().skills.get (CYCLONESTRIKE).use (this, target);
        } else {
            getWeapon ().skills.get (SLASH).use (this, target);
        }
    }

    @Override
    protected void counter (Entity target) {
        System.out.println ("The masked knight counters the attack!\n" +
                "The masked knight strikes " + target.getName () + " with a bolt of ice!");

        damage (target, randomGenerator.random (5, 30), "ice");
    }
}
