package skills;

import entities.Entity;

public class Bludgeon extends Skill {
    public Bludgeon () {
        setName ("Bludgeon");
        setDescription ("Hit an enemy for high damage. Damage scales with strength.");
        setCooldown (140);
    }

    @Override
    public void use (Entity user, Entity target) {
        int BASE_DAMAGE = 3;
        double experienceFactor = (user.getWeapon ().getExperience () / 200.00) + 0.5;
        int damage = (int) (experienceFactor * (BASE_DAMAGE + BASE_DAMAGE * (user.getStrength () / 2)));
        System.out.println (user.getName () + " used Bludgeon!");

        user.damage (target, damage, "bludgeon");

        user.setCooldown (getCooldown ());
    }
}
