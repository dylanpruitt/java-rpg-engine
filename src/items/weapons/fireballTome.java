package items.weapons;

import skills.Fireball;

public class fireballTome extends Weapon {
    public fireballTome () {
        setName ("Fireball Tome");
        setMagic (3);
        setExperienceAmount (3);
        skills.add (new Fireball ());
    }
}
