// Pawn – reprezentuje pionek gracza na planszy. Przechowuje pozycję, właściciela, czy jest w domu.
package ludoclub.model;

import java.io.Serializable;

public class Pawn implements Serializable {
    private Player owner;
    private int position; // Pozycja pionka na planszy (pole)
    private boolean atHome;

    public Pawn(Player owner) {
        this.owner = owner;
        this.position = 0; // start/baza
        this.atHome = false;
    }

    // Ruch pionka o podaną liczbę pól
    public void move(int steps) {
        this.position += steps;
        // TODO: ograniczenia (np. max 44 jeśli plansza ma 44 pola)
    }

    public Player getOwner() { return owner; }
    public int getPosition() { return position; }
    public void setPosition(int pos) { this.position = pos; }
    public boolean isAtHome() { return atHome; }
    public void setAtHome(boolean b) { this.atHome = b; }
}
