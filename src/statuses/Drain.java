package statuses;

import entities.Entity;

public class Drain extends Status {
    public Drain () {
        setName ("Drain");
        setTurnsLeft (3);
    }

    @Override
    public void onTurnBegin (Entity parent) {
        parent.damage (parent, parent.getMaxHealth () / 15, "poison");
    }
}
