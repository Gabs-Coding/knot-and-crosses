package com.gabscoding.knotsandcrosses.model;

public class Player {
    private String theNameOfThePlayer;

    public Player(String theNameOfThePlayer) {
        this.theNameOfThePlayer = theNameOfThePlayer;
    }

    public String getTheNameOfThePlayer() {
        return theNameOfThePlayer;
    }

    public void setTheNameOfThePlayer(String theNameOfThePlayer) {
        this.theNameOfThePlayer = theNameOfThePlayer;
    }

    @Override
    public String toString() {
        return "Jogador: " + getTheNameOfThePlayer();
    }
}
