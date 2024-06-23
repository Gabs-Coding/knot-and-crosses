package com.gabscoding.knotsandcrosses.model;

import com.gabscoding.knotsandcrosses.log.PlayerLogger;
import com.gabscoding.knotsandcrosses.registration.PlayerRegistration;

public class Player {
    private final PlayerLogger playerLogger;
    private String theNameOfThePlayer;
    private Boolean isTheWinningPlayer;

    public Player() {
        theNameOfThePlayer = PlayerRegistration.getNameOfPlayerFromUser();
        isTheWinningPlayer = false;
        playerLogger = PlayerLogger.getInstance();
        playerLogger.logNewPlayerRegistered(this);
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
