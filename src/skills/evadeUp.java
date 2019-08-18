package skills;

import entities.Entity;
import statuses.attackModified;
import statuses.evasionModified;
import utility.randomGenerator;

public class evadeUp extends Skill {
    public evadeUp () {
        setName ("EvadeUp");
        setDescription ("Boosts the user's evasion by 3-5%.");
        setCooldown (77);
    }

    @Override
    public void use (Entity user, Entity target) {
        System.out.println (user.getName () + " used EvadeUp!");
        int boost = randomGenerator.random (3, 5);

        target.modifyEvasion (boost);
        target.statuses.add (new evasionModified (boost));

        user.setCooldown (getCooldown ());
    }
}
