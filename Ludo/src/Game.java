// Klasa Game – główna logika rozgrywki, przechowuje listę graczy, obsługuje tury itp.
package ludoclub.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Game implements Serializable {
    private List<Player> players;
    private int currentPlayerIdx;

    public Game() {
        players = new ArrayList<>();
        currentPlayerIdx = 0;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIdx);
    }

    public void nextTurn() {
        currentPlayerIdx = (currentPlayerIdx + 1) % players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
