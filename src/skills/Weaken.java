package skills;

import entities.Entity;
import statuses.attackModified;
import utility.randomGenerator;

public class Weaken extends Skill {
    public Weaken () {
        setName ("Weaken");
        setDescription ("Reduces a target's strength by 2-4.");
        setCooldown (77);
    }

    @Override
    public void use (Entity user, Entity target) {
        System.out.println (user.getName () + " used Minos!");
        int boost = randomGenerator.random (2, 4);

        target.modifyStrength (-1 * boost);
        target.statuses.add (new attackModified (-1 * boost));

        user.setCooldown (getCooldown ());
    }
}
