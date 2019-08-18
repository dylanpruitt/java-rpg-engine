package items.weapons;

import skills.Bludgeon;

public class golemFists extends Weapon {
    public golemFists () {
        setName ("Golem Fists");
        setCritical (10);
        setExperienceAmount (1);
        skills.add (new Bludgeon ());
    }
}
