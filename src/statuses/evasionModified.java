package statuses;

import entities.Entity;

public class evasionModified extends Status {
    public evasionModified (int playerEvasionModifier) {
        setName ("Evasion Modified");
        setTurnsLeft (999);
        evasionModifier = -1 * playerEvasionModifier;
    }

    private int evasionModifier = 0;

    @Override
    public void onBattleEnd (Entity parent) {
        parent.modifyEvasion (evasionModifier);
    }
}
