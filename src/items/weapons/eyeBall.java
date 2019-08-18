package items.weapons;

import skills.Drain;
import skills.Gravity;
import skills.Weaken;

public class eyeBall extends Weapon {
    public eyeBall () {
        setName ("Eyeball");
        skills.add (new Gravity ());
        skills.add (new Drain ());
        skills.add (new Weaken ());
    }
}
