package statuses;

import entities.Entity;

public class attackModified extends Status {
    public attackModified (int playerAttackModifier) {
        setName ("Attack Modified");
        setTurnsLeft (999);
        attackModifier = -1 * playerAttackModifier;
    }

    private int attackModifier = 0;

    @Override
    public void onBattleEnd (Entity parent) {
        parent.modifyStrength (attackModifier);
    }
}
