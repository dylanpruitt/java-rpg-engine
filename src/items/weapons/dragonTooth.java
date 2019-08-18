package items.weapons;

import skills.Fireball;
import skills.Slash;

public class dragonTooth extends Weapon {
    public dragonTooth () {
        setName ("Dragon Tooth");
        setStrength (1);
        setExperience (16);
        skills.add (new Slash ());
        skills.add (new Fireball ());
    }
}
