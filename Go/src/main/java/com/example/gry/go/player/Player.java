package com.example.gry.go.player;

public abstract class Player extends com.example.gry.games.Player{
    /**
     * Konstruktor klasy Player.
     *
     * @param nickname nazwa gracza. Musi być unikalna.
     */
    public Player(String nickname) {
        super(nickname);
    }
}
