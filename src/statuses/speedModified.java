package statuses;

import entities.Entity;

public class speedModified extends Status {
    public speedModified (int playerAttackModifier) {
        setName ("Speed Modified");
        setTurnsLeft (999);
        speedModifier = -1 * playerAttackModifier;
    }

    private int speedModifier = 0;

    @Override
    public void onBattleEnd (Entity parent) {
        parent.modifySpeed (speedModifier);
    }
}
