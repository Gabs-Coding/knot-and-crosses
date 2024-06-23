package com.gabscoding.knotsandcrosses.log;

import com.gabscoding.knotsandcrosses.model.GameSession;
import com.gabscoding.knotsandcrosses.model.Player;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GameSessionLogger {
    private static GameSessionLogger gameSessionLogger;
    private final Logger logger;

    public GameSessionLogger() {
        logger = Logger.getLogger(GameSession.class.getName());
    }

    public static GameSessionLogger getInstance() {
        return gameSessionLogger == null ? gameSessionLogger = new GameSessionLogger() : gameSessionLogger;
    }

    public void logNewGameSessionLog(GameSession gameSession) {
        logger.log(Level.INFO, "Nova sessão de jogo: " + gameSession.getNameOfTheGameSession());
    }

    public void logNewPlayerAdded(Player player) {
        logger.log(Level.INFO, "Novo jogador adicionado: " + player.getTheNameOfThePlayer());
    }

    public void logErrorWhileOpeningTheGameSessionLogFile() {
        logger.log(Level.SEVERE, "Impossível abrir o arquivo, ou o diretório, do GameSessionLogFile.");
    }
}
