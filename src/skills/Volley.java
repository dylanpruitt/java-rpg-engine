package skills;

import entities.Entity;

public class Volley extends Skill {
    public Volley () {
        setName ("Volley");
        setDescription ("Shoot a volley of arrows at an enemy. Damage scales with dexterity.");
        setCooldown (60);
    }

    @Override
    public void use (Entity user, Entity target) {
        int BASE_DAMAGE = 2;
        double experienceFactor = (user.getWeapon ().getExperience () / 200.00) + 0.5;
        int damage = (int) (experienceFactor * (BASE_DAMAGE + BASE_DAMAGE * (user.getDexterity () / 2)));
        System.out.println (user.getName () + " used Volley!");

        user.damage (target, damage, "arrow");

        user.setCooldown (getCooldown ());
    }
}
