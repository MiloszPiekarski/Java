package com.example.gry.games;

/**
 * Abstrakcyjna klasa reprezentująca gracza w grze.
 */
public abstract class Player {
    /**
     * Nazwa gracza. Traktowana jako ID. Każdy gracz ma unikalną nazwę.
     */
    protected String nickname;

    /**
     * Czy gracz jest online. 1 - jest online, 0 - jest offline.
     */
    protected boolean isOnline;

    /**
     * Konstruktor klasy Player.
     * @param nickname nazwa gracza. Musi być unikalna.
     */
    public Player(String nickname) {
        this.nickname = nickname; // TODO: Sprawdzenie czy nazwa gracza jest unikalna
        this.isOnline = true; // Domyślnie gracz jest online
    }

    /**
     * Metoda do wykonywania ruchu przez gracza.
     */
    public abstract void makeMove();
}
