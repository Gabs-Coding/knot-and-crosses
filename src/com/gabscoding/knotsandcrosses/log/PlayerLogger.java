package com.gabscoding.knotsandcrosses.log;

import com.gabscoding.knotsandcrosses.model.Player;
import org.jetbrains.annotations.Contract;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PlayerLogger {
    private static PlayerLogger playerLogger;
    private final Logger logger;

    private PlayerLogger() {
        logger = Logger.getLogger(Player.class.getName());
    }

    public static PlayerLogger getInstance() {
        return playerLogger == null ? playerLogger = new PlayerLogger() : playerLogger;
    }

    public void logNewPlayerRegistered(Player newPlayer) {
        logger.log(Level.INFO, "New player registered: " + newPlayer.toString());
    }

    public void logPlayerTryingToMoveToOcuppiedGridPosition() {
        logger.log(Level.WARNING, "Impossível fazer essa jogada. A posição já está ocupada!");
    }
}
