package statuses;

import entities.Entity;

public class criticalModified extends Status {
    public criticalModified (int playerCriticalModifier) {
        setName ("Critical Modified");
        setTurnsLeft (999);
        criticalModifier = -1 * playerCriticalModifier;
    }

    private int criticalModifier = 0;

    @Override
    public void onBattleEnd (Entity parent) {
        parent.modifyCritical (criticalModifier);
    }
}
