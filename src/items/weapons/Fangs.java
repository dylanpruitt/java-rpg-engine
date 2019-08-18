package items.weapons;

import skills.Leech;

public class Fangs extends Weapon {
    public Fangs () {
        setName ("Fangs");
        setStrength (1);
        setExperience (utility.randomGenerator.random (0, 100));
        skills.add (new Leech ());
    }
}
