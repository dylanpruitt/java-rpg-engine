package skills;

import entities.Entity;
import utility.Input;

public class useItem extends Skill {
    public useItem () {
        setName ("Use Item");
        setDescription ("Use an item in your inventory.");
        setCooldown (60);
    }

    @Override
    public void use (Entity user, Entity target) {
        if (user.inventory.size () > 0) {
            for (int i = 0; i < user.inventory.size (); i++) {
                System.out.println (i + " - " + user.inventory.get (i).getName ());
            }

            System.out.println ("Choose an item:");
            int targetIndex = Input.getIntegerInputInRange (0, user.inventory.size () - 1);

            user.inventory.get (targetIndex).onUse (target);

            System.out.println (user.getName () + " used an item!");

            user.setCooldown (getCooldown ());
        } else {
            System.out.println (user.getName () + " has no items!");
        }
    }
}
