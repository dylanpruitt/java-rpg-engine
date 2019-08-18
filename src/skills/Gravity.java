package skills;

import entities.Entity;

public class Gravity extends Skill {
    public Gravity () {
        setName ("Gravity");
        setDescription ("Halves the target's health.");
        setCooldown (100);
    }

    @Override
    public void use (Entity user, Entity target) {
        int damage = target.getHealth () / 2;
        System.out.println (user.getName () + " used Gravity!");

        user.damage (target, damage, "arcane");

        user.setCooldown (getCooldown ());
    }
}
