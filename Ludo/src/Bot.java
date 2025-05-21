// Klasa Bot – reprezentuje bota (komputerowego gracza) w grze Ludo. Dziedziczy po Player.
package ludoclub.model;

import java.util.Random;

public class Bot extends Player {
    public Bot(String username, String colorName) {
        super(username, colorName);
    }

    @Override
    public String getUserType() { return "Bot"; }

    // Bot losowo wybiera pionka do ruchu
    public Pawn choosePawnToMove() {
        if (pawns.isEmpty()) return null;
        Random rand = new Random();
        return pawns.get(rand.nextInt(pawns.size()));
    }
}
