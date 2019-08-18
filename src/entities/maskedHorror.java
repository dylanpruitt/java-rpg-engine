package entities;

import items.weapons.Rapier;
import skills.Fireball;
import skills.Lightning;

public class maskedHorror extends Entity {
    public maskedHorror () {
        setName ("Masked Horror");
        setHealth (175);
        setMaxHealth (175);
        setStrength (24);
        setDexterity (32);
        setSpeed (32);
        setMagic (27);
        setCritical (10);
        setEvasion (10);
        setWeapon (new Rapier ());
        getWeapon ().setExperience (77);
        getWeapon ().skills.add (new Fireball ());
        getWeapon ().skills.add (new Lightning ());

        resistances.add ("fire");
    }
}
