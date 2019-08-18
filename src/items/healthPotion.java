package items;

import entities.Entity;

public class healthPotion extends Item {
    public healthPotion () {
        setName ("Health Potion");
    }

    @Override
    public void onUse (Entity user) {
        System.out.println (user.getName () + " used a Health Potion!");
        user.modifyHealth (15);
        if (user.getHealth () > user.getMaxHealth ()) {
            user.setHealth (user.getMaxHealth ());
        }
    }
}
