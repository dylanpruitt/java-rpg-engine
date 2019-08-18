package skills;

import entities.Entity;
import statuses.speedModified;
import utility.randomGenerator;

public class Slow extends Skill {
    public Slow () {
        setName ("Slow");
        setDescription ("Decreases the target's speed by 2-4.");
        setCooldown (77);
    }

    @Override
    public void use (Entity user, Entity target) {
        System.out.println (user.getName () + " used Slow!");
        int boost = randomGenerator.random (2, 4);

        if (target.getSpeed () - boost < 1) {
            boost = target.getSpeed () - 1;
        }

        target.modifySpeed (-1 * boost);
        target.statuses.add (new speedModified(-1 * boost));
        System.out.println (target.getName () + "'s speed decreased by " + boost + "!");

        user.setCooldown (getCooldown ());
    }
}
