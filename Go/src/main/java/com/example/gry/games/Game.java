package com.example.gry.games;

import com.example.gry.games.Player;

import java.util.List;

/**
 * Abstrakcyjna klasa reprezentująca grę.
 */
public abstract class Game {
    /**
     * Lista graczy uczestniczących w grze.
     */
    protected List<Player> players;

    /**
     * Konstruktor klasy Game.
     */
    public abstract void startGame(List<Player> players);

    /**
     * Destruktor klasy Game.
     */
    public abstract void endGame();

    /**
     * Metoda zapisująca aktualny stan gry.
     */
    public abstract void saveGame();

    /**
     * Metoda zapisująca przebieg rozgrywki.
     */
    protected abstract void logAction();
}