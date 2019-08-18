package skills;

import entities.Entity;
import utility.randomGenerator;

public class cycloneStrike extends Skill {
    public cycloneStrike () {
        setName ("Cyclone Strike");
        setDescription ("Slash an enemy 2 - 4 times. Damage scales with strength.");
        setCooldown (90);
    }

    @Override
    public void use (Entity user, Entity target) {
        int BASE_DAMAGE = 2;
        double experienceFactor = (user.getWeapon ().getExperience () / 200.00) + 0.5;
        int damage = (int) (experienceFactor * (BASE_DAMAGE + BASE_DAMAGE * (user.getStrength () / 3)));

        int numberOfStrikes = randomGenerator.random (2, 4);
        System.out.println (user.getName () + " used Cyclone Strike!");

        for (int i = 0; i < numberOfStrikes; i++) {
            user.damage (target, damage, "slashing");
        }

        user.setCooldown (getCooldown ());
    }
}
