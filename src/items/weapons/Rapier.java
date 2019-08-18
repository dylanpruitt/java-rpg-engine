package items.weapons;

import skills.Slash;
import skills.cycloneStrike;

public class Rapier extends Weapon {
    public Rapier () {
        setName ("Rapier");
        skills.add (new Slash ());
        skills.add (new cycloneStrike ());
    }
}
