package skills;

import entities.Entity;

public class Slash extends Skill {
    public Slash () {
        setName ("Slash");
        setDescription ("Slash an enemy. Damage scales with strength.");
        setCooldown (60);
    }

    @Override
    public void use (Entity user, Entity target) {
        int BASE_DAMAGE = 2;
        double experienceFactor = (user.getWeapon ().getExperience () / 200.00) + 0.5;
        int damage = (int) (experienceFactor * (BASE_DAMAGE + BASE_DAMAGE * (user.getStrength () / 2)));
        System.out.println (user.getName () + " used Slash!");

        user.damage (target, damage, "slashing");

        user.setCooldown (getCooldown ());
    }
}
