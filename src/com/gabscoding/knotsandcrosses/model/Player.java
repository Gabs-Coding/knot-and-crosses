package com.gabscoding.knotsandcrosses.model;

import com.gabscoding.knotsandcrosses.log.PlayerLogger;
import com.gabscoding.knotsandcrosses.registration.PlayerRegistration;

public class Player {
    private String theNameOfThePlayer;
    private Boolean isTheWinningPlayer;
    private final char symbolOfThePlayer;

    public Player(int numberOfThePlayer) {
        theNameOfThePlayer = PlayerRegistration.getNameOfPlayerFromUser();
        isTheWinningPlayer = false;
        symbolOfThePlayer = (numberOfThePlayer == 0) ? 'X' : 'O';
        PlayerLogger playerLogger = PlayerLogger.getInstance();
        playerLogger.logNewPlayerRegistered(this);
    }

    public char getSymbolOfThePlayer() {
        return symbolOfThePlayer;
    }

    public String getTheNameOfThePlayer() {
        return theNameOfThePlayer;
    }

    public void setTheNameOfThePlayer(String theNameOfThePlayer) {
        this.theNameOfThePlayer = theNameOfThePlayer;
    }

    public Boolean getIsTheWinningPlayer() {
        return isTheWinningPlayer;
    }

    public void setIsTheWinningPlayer(Boolean isTheWinningPlayer) {
        this.isTheWinningPlayer = isTheWinningPlayer;
    }

    @Override
    public String toString() {
        return "Jogador " + getTheNameOfThePlayer();
    }
}
