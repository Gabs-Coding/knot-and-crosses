package com.gabscoding.knotsandcrosses;

import com.gabscoding.knotsandcrosses.model.GameSession;

public class KnotsAndCrosses {

    public static void main(String[] args) {
        GameSession gameSession = new GameSession();
        gameSession.listPlayersOfThisSession();
        gameSession.letsPlay();
    }
}
