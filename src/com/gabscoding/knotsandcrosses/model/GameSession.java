package com.gabscoding.knotsandcrosses.model;

import com.gabscoding.knotsandcrosses.registration.GameSessionRegistrator;

public class GameSession {
    private String nameOfTheSessionOfTheGame;
    private Player playerOne;
    private Player playerTwo;
    private Integer currentAmountOfPlayers;
    private final Integer maximumAmountOfPlayer = 2;

    public GameSession() {
        nameOfTheSessionOfTheGame = GameSessionRegistrator.createTheNameOfTheGameSession();
        currentAmountOfPlayers = 0;
    }

    public void addNewPlayer() {
        if (currentAmountOfPlayers == maximumAmountOfPlayer) {

        }
    }
}
