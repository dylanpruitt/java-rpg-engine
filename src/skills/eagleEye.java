package skills;

import entities.Entity;
import statuses.criticalModified;
import statuses.evasionModified;
import utility.randomGenerator;

public class eagleEye extends Skill {
    public eagleEye () {
        setName ("Eagle Eye");
        setDescription ("Boosts the user's critical hit chance by 3-5%.");
        setCooldown (77);
    }

    @Override
    public void use (Entity user, Entity target) {
        System.out.println (user.getName () + " used Eagle Eye!");
        int boost = randomGenerator.random (3, 5);

        target.modifyCritical (boost);
        target.statuses.add (new criticalModified (boost));

        user.setCooldown (getCooldown ());
    }
}
