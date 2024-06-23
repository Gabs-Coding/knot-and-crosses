package com.gabscoding.knotsandcrosses.model;

import com.gabscoding.knotsandcrosses.log.GameSessionLogFile;
import com.gabscoding.knotsandcrosses.log.GameSessionLogger;
import com.gabscoding.knotsandcrosses.registration.GameSessionRegistration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameSession {
    private final String nameOfTheGameSession;
    private final GameSessionLogger gameSessionLogger;
    private final List<Player> playersOfThisGameSession;
    private final Integer MAX_PLAYERS = 2;
    private Grid grid;
    private final GameSessionLogFile gameSessionLogFile;

    public GameSession() {
        nameOfTheGameSession = GameSessionRegistration.createTheNameOfTheGameSession();
        playersOfThisGameSession = new ArrayList<>();
        registerThePlayersOfThisGameSession();
        gameSessionLogFile = new GameSessionLogFile(nameOfTheGameSession);
        gameSessionLogger = GameSessionLogger.getInstance();
        gameSessionLogger.logNewGameSessionLog(this);
    }

    public String getNameOfTheGameSession() {
        return nameOfTheGameSession;
    }

    private void registerThePlayersOfThisGameSession() {
        if (!checkIfThisGameSessionReachedTheMaxLimitOfPlayers()) {
            for (int i = 0; i < MAX_PLAYERS; i++) {
                addNewPlayerToThisGameSession(i+1);
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
    
    public void renamePlayerName() {
        try (Scanner scanner = new Scanner(System.in)) {
            if (!hasThisGameSessionRegisteredPlayers()) {
                return;
            }
            listPlayersOfThisSession();
            System.out.print("Digite o número do jogador a ser renomeado (1 ou 2): ");
            int indexOfPlayerToBeRenamed = scanner.nextInt();
            System.out.print("\nDigite o novo nome: ");
            String newNameOfThePlayer = scanner.next();
            playersOfThisGameSession.get(indexOfPlayerToBeRenamed).setTheNameOfThePlayer(newNameOfThePlayer);
        }
    }
    
    public void listPlayersOfThisSession() {
        if (hasThisGameSessionRegisteredPlayers()) {
            System.out.println("Impossível listar jogadores, pois esta sessão não possui nenhum jogador cadastrado.");
            return;
        }
        System.out.print("Jogadores registrados nessa sessão: ");
        for (Player currentPlayer : playersOfThisGameSession) {
            System.out.print("{" + currentPlayer.getTheNameOfThePlayer() + "}" + " ");
        }
    }

    @Override
    public String toString() {
        return "Nome da sessão de jogo: " + getNameOfTheGameSession();
    }
}
