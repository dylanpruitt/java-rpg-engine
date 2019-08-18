package items.weapons;

import skills.Agi;
import skills.Lightning;

public class lightningTome extends Weapon {
    public lightningTome () {
        setName ("Lightning Tome");
        setMagic (2);
        skills.add (new Lightning ());
        skills.add (new Agi ());
    }

}
