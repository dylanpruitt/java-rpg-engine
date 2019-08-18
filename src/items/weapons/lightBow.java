package items.weapons;

import skills.Slow;
import skills.Volley;

public class lightBow extends Weapon {
    public lightBow () {
        setName ("Light Bow");
        setDexterity (2);
        setCritical (6);
        setExperienceAmount (3);
        skills.add (new Volley ());
        skills.add (new Slow ());
    }
}
