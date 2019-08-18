package statuses;

import entities.Entity;

public class Status {
    private String name = "default";
    private int turnsLeft = 0;

    public void onTurnBegin (Entity parent) {

    }

    public void onBattleEnd (Entity parent) {

    }

    public void setName (String newName) { name = newName; }
    public String getName () { return name; }

    public void setTurnsLeft (int amount) { turnsLeft = amount; }
    public int getTurnsLeft () { return turnsLeft; }
    public void decreaseTurnsLeft () { turnsLeft--; }

}
