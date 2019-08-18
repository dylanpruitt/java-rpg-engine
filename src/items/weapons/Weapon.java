package items.weapons;

import entities.Entity;
import items.Item;
import skills.Skill;

import java.util.ArrayList;

public class Weapon extends Item {

    public Weapon () { }

    public Weapon (Weapon copy) {
        setName (copy.getName ());
        strength = copy.getStrength ();
        dexterity = copy.getDexterity ();
        magic = copy.getMagic ();
        speed = copy.getSpeed ();
        evasionPercent = copy.getEvasion ();
        criticalHitPercent = copy.getCritical ();
        experience = copy.getExperience ();
        experienceAmount = copy.getExperienceAmount ();

        for (int i = 0; i < copy.skills.size (); i++) {
            skills.add (copy.skills.get (i));
        }
    }

    private int strength = 0;
    private int dexterity = 0;
    private int magic = 0;

    private int speed = 0;
    private int evasionPercent = 0;
    private int criticalHitPercent = 0;

    private int experience = 0;
    private int experienceAmount = 1;

    public ArrayList <Skill> skills = new ArrayList<> ();

    public void onEquip (Entity user) {
        user.modifyStrength (strength);
        user.modifyDexterity (dexterity);
        user.modifyMagic (magic);
        user.modifySpeed (speed);
        user.modifyEvasion (evasionPercent);
        user.modifyCritical (criticalHitPercent);
    }
    private void onUnequip (Entity user) {
        user.modifyStrength (-1 * strength);
        user.modifyDexterity (-1 * dexterity);
        user.modifyMagic (-1 * magic);
        user.modifySpeed (-1 * speed);
        user.modifyEvasion (-1 * evasionPercent);
        user.modifyCritical (-1 * criticalHitPercent);
    }
    public void onMastery (Entity user) {

    }

    public void setStrength (int amount) { strength = amount; }
    public int getStrength () { return strength; }

    public void setDexterity (int amount) { dexterity = amount; }
    public int getDexterity () { return dexterity; }

    public void setMagic (int amount) { magic = amount; }
    public int getMagic () { return magic; }

    public void setSpeed (int amount) { speed = amount; }
    public int getSpeed () { return speed; }

    public void setEvasion (int amount) { evasionPercent = amount; }
    public int getEvasion () { return evasionPercent; }

    public void setCritical (int amount) { criticalHitPercent = amount; }
    public int getCritical () { return criticalHitPercent; }

    public void setExperience (int amount) { experience = amount; }
    public int getExperience () { return experience; }
    public void gainExperience () { experience += experienceAmount; }

    public void setExperienceAmount (int amount) { experienceAmount = amount; }
    public int getExperienceAmount () { return experienceAmount; }

    @Override
    public void onUse (Entity user) {
        user.getWeapon ().onUnequip (user);
        user.inventory.add (new Weapon (user.getWeapon ()));
        user.setWeapon (this);
        user.inventory.remove (this);
    }


}
