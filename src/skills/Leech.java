package skills;

import entities.Entity;

public class Leech extends Skill {
    public Leech () {
        setName ("Leech");
        setDescription ("Bite an enemy and heal for some of the damage. Damage scales with strength.");
        setCooldown (60);
    }

    @Override
    public void use (Entity user, Entity target) {
        int BASE_DAMAGE = 2;
        double experienceFactor = (user.getWeapon ().getExperience () / 200.00) + 0.5;
        int damage = (int) (experienceFactor * (BASE_DAMAGE + BASE_DAMAGE * (user.getStrength () / 2)));
        System.out.println (user.getName () + " used Leech!");

        user.damage (target, damage, "slashing");

        int amountHealed = damage / 3;

        user.modifyHealth (amountHealed);
        if (user.getHealth () > user.getMaxHealth ()) {
            user.setHealth (user.getMaxHealth ());
        }

        user.setCooldown (getCooldown ());
    }
}
