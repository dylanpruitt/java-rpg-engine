package entities;

import items.weapons.Rapier;
import items.weapons.golemFists;

public class Golem extends Entity {
    public Golem () {
        setName ("Golem");
        setHealth (1000);
        setMaxHealth (1000);
        setStrength (49);
        setDexterity (14);
        setSpeed (20);
        setMagic (37);
        setCritical (30);
        setEvasion (10);
        setWeapon (new golemFists ());

        resistances.add ("fire");
        resistances.add ("lightning");
        resistances.add ("ice");

        weaknesses.add ("arcane");
    }
}
