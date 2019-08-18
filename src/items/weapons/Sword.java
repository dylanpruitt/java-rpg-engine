package items.weapons;

import entities.Entity;
import skills.Minos;
import skills.Slash;

public class Sword extends Weapon {
    public Sword () {
        setName ("Sword");
        setStrength (2);
        setExperienceAmount (3);
        skills.add (new Slash ());
        skills.add (new Minos ());
    }

    @Override
    public void onMastery (Entity user) {
        System.out.println (user.getName () + " has become a master at using the " + getName () + "! They have become stronger!");
        user.modifyStrength (1);
    }
}
