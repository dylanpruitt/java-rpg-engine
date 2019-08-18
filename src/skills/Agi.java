package skills;

import entities.Entity;
import statuses.speedModified;
import utility.randomGenerator;

public class Agi extends Skill {
    public Agi () {
        setName ("Agi");
        setDescription ("Boosts the user's speed by 2-6.");
        setCooldown (77);
    }

    @Override
    public void use (Entity user, Entity target) {
        System.out.println (user.getName () + " used Agi!");
        int boost = randomGenerator.random (2, 6);

        target.modifySpeed (boost);
        target.statuses.add (new speedModified (boost));
        System.out.println (user.getName () + "'s speed increased by " + boost + "!");

        user.setCooldown (getCooldown ());
    }
}
