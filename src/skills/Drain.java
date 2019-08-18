package skills;

import entities.Entity;

public class Drain extends Skill {
    public Drain () {
        setName ("Drain");
        setDescription ("Drains the target's health for three turns.");
        setCooldown (85);
    }

    @Override
    public void use (Entity user, Entity target) {
        System.out.println (user.getName () + " used Drain!");
        target.statuses.add (new statuses.Drain ());

        user.setCooldown (getCooldown ());
    }
}
