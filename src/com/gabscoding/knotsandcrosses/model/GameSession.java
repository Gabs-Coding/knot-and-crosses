package com.gabscoding.knotsandcrosses.model;

import com.gabscoding.knotsandcrosses.log.GameSessionLogFile;
import com.gabscoding.knotsandcrosses.log.GameSessionLogger;
import com.gabscoding.knotsandcrosses.registration.GameSessionRegistration;

import java.util.ArrayList;
import java.util.List;

public class GameSession {
    private final String nameOfTheGameSession;
    private final GameSessionLogger gameSessionLogger;
    private final List<Player> playersOfThisGameSession;
    private static final int MAX_PLAYERS = 2;
    private final Grid grid;
    private final GameMenu gameMenu;

    public GameSession() {
        nameOfTheGameSession = GameSessionRegistration.createTheNameOfTheGameSession();
        playersOfThisGameSession = new ArrayList<>();
        grid = new Grid();
        gameSessionLogger = GameSessionLogger.getInstance();
        registerThePlayersOfThisGameSession();
        new GameSessionLogFile(nameOfTheGameSession);
        gameMenu = new GameMenu();
        gameSessionLogger.logNewGameSessionLog(this);
    }

    public String getNameOfTheGameSession() {
        return nameOfTheGameSession;
    }

    private void registerThePlayersOfThisGameSession() {
        if (!checkIfThisGameSessionReachedTheMaxLimitOfPlayers()) {
            for (int i = 0; i < MAX_PLAYERS; i++) {
                addNewPlayerToThisGameSession(i + 1);
            }
        }
    }

    private void addNewPlayerToThisGameSession(int numberOfThePlayer) {
        Player player = new Player(numberOfThePlayer);
        playersOfThisGameSession.add(player);
        gameSessionLogger.logNewPlayerAdded(player);
    }

    private boolean checkIfThisGameSessionReachedTheMaxLimitOfPlayers() {
        return playersOfThisGameSession.size() >= MAX_PLAYERS;
    }

    private boolean hasThisGameSessionRegisteredPlayers() {
        return !playersOfThisGameSession.isEmpty();
    }

    public void listPlayersOfThisSession() {
        if (!hasThisGameSessionRegisteredPlayers()) {
            System.out.println("Impossível listar jogadores, pois esta sessão não possui nenhum jogador cadastrado.");
            return;
        }
        System.out.print("Jogadores registrados nesta sessão: ");
        for (Player currentPlayer : playersOfThisGameSession) {
            System.out.print("{" + currentPlayer.getTheNameOfThePlayer() + "} ");
        }
        System.out.println();
    }

    public void letsPlay() {
        gameMenu.showMainMenu();
        while (hasConditionsToPlay()) {
            for (Player playerOnTheMove : playersOfThisGameSession) {
                grid.showGrid();
                turnOf(playerOnTheMove);
                if (isThePlayerWinned()) {
                    playerWinnedEndGameMessage(playerOnTheMove);
                    return;
                }
            }
        }
    }

    private boolean hasConditionsToPlay() {
        return !grid.getHasWinningSequenceMarked() && !grid.isTheGridFull();
    }

    private void turnOf(Player player) {
        grid.makeMove(player, GetPlayerInput.getPositionToMove());
    }

    private boolean isThePlayerWinned() {
        return grid.getHasWinningSequenceMarked();
    }

    private void playerWinnedEndGameMessage(Player player) {
        String winningMessage = "O vencedor da partida é " + player.toString() + "! Foi um ótimo jogo.";
        System.out.println(winningMessage);
    }

    @Override
    public String toString() {
        return "Nome da sessão de jogo: " + getNameOfTheGameSession();
    }
}
