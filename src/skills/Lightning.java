package skills;

import entities.Entity;

public class Lightning extends Skill {
    public Lightning () {
        setName ("Lightning");
        setDescription ("Summon a lightning bolt. Damage scales with magic.");
        setCooldown (95);
    }

    @Override
    public void use (Entity user, Entity target) {
        int BASE_DAMAGE = 3;
        double experienceFactor = (user.getWeapon ().getExperience () / 200.00) + 0.5;
        int damage = (int) Math.pow ((BASE_DAMAGE + BASE_DAMAGE * (user.getMagic () / 2.00)), experienceFactor);
        System.out.println (user.getName () + " used Lightning!");

        user.damage (target, damage, "lightning");

        user.setCooldown (getCooldown ());
    }
}
