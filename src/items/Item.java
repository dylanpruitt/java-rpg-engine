package items;

import entities.Entity;

public class Item {
    private String name;

    public void setName (String newName) { name = newName; }
    public String getName () { return name; }

    public void onUse (Entity user) {

    }
}
