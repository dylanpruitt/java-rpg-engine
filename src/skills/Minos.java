package skills;

import entities.Entity;
import statuses.attackModified;
import utility.randomGenerator;

public class Minos extends Skill {
    public Minos () {
        setName ("Minos");
        setDescription ("Boosts the user's strength by 2-6.");
        setCooldown (77);
    }

    @Override
    public void use (Entity user, Entity target) {
        System.out.println (user.getName () + " used Minos!");
        int boost = randomGenerator.random (2, 6);

        target.modifyStrength (boost);
        target.statuses.add (new attackModified (boost));

        user.setCooldown (getCooldown ());
    }
}
