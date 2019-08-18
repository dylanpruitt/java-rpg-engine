package items.weapons;

import skills.eagleEye;
import skills.Volley;

public class falconBow extends Weapon {
    public falconBow () {
        setName ("Falcon Bow");
        setDexterity (1);
        setCritical (10);
        setExperienceAmount (3);
        skills.add (new Volley ());
        skills.add (new eagleEye ());
    }
}
