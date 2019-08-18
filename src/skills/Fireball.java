package skills;

import entities.Entity;

public class Fireball extends Skill {
    public Fireball () {
        setName ("Fireball");
        setDescription ("Summon a fireball. Damage scales with magic.");
        setCooldown (80);
    }

    @Override
    public void use (Entity user, Entity target) {
        int BASE_DAMAGE = 2;
        double experienceFactor = (user.getWeapon ().getExperience () / 200.00) + 0.5;
        int damage = (int) (experienceFactor * (BASE_DAMAGE + BASE_DAMAGE * (user.getMagic () / 2)));
        System.out.println (user.getName () + " used Fireball!");

        user.damage (target, damage, "fire");

        user.setCooldown (getCooldown ());
    }
}
