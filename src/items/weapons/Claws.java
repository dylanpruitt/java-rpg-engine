package items.weapons;

import skills.Slash;

public class Claws extends Weapon {
    public Claws () {
        setName ("Claws");
        setStrength (2);
        setExperience (26);
        skills.add (new Slash ());
    }
}
