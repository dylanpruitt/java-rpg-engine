package skills;

import entities.Entity;

public class Skill {

    private String name = "Skill";
    private String description = "default text";
    private int cooldown = 50;

    public void setName (String newName) { name = newName; }
    public String getName () { return name; }

    public void setDescription (String newDescription) { description = newDescription; }
    public String getDescription () { return description; }

    public void setCooldown (int amount) { cooldown = amount; }
    public int getCooldown () { return cooldown; }

    public void use (Entity user, Entity target) {

    }
}
