// Klasa Player – reprezentuje gracza (dziedziczy po User). Zawiera listę pionków i status ukończenia.
package ludoclub.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player extends User implements Serializable {
    protected List<Pawn> pawns;
    protected boolean finished;

    public Player(String username, String colorName) {
        super(username, colorName);
        pawns = new ArrayList<>();
        finished = false;
    }

    // Dodaje pionka do gracza
    public void addPawn(Pawn pawn) {
        pawns.add(pawn);
    }

    public List<Pawn> getPawns() {
        return pawns;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public String getUserType() { return "Player"; }
}
