package com.gabscoding.knotsandcrosses.log;

import java.io.File;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameSessionLogFile {
    private static final String GAME_SESSION_LOG_FILE_PATH =
            "/logfiles";
    private static final String LOG_FILE_ARCHIVE_EXTENSION = ".txt";
    private static final String PATTERN_OF_THE_GAME_SESSION_LOG_FILE_NAME =
            "\\d{4}-\\d{2}-\\d{2}-game(\\d+)";
    private final File gameSessionLogFile;

    public GameSessionLogFile(String nameOfTheGameSession) {
        gameSessionLogFile = tryCreateTheLogFile(nameOfTheGameSession);
    }

    public File getGameSessionLogFile() {
        return gameSessionLogFile;
    }

    private File tryCreateTheLogFile(String nameOfTheGameSession) {
        return new File(GAME_SESSION_LOG_FILE_PATH + "/" +
                nameOfTheGameSession + LOG_FILE_ARCHIVE_EXTENSION);
    }

    // fiquei com preguiça (estou o dia inteiro fazendo esse código) e peguei mais da metade desse
    // método do GPT; tmj!
    public static int getTheLastIndexOfGameSessionLogFile() {
        File directoryToSearch = new File(GAME_SESSION_LOG_FILE_PATH);
        Pattern pattern = Pattern.compile(PATTERN_OF_THE_GAME_SESSION_LOG_FILE_NAME);

        if (!directoryToSearch.isDirectory()) {
            GameSessionLogger.getInstance().logErrorWhileOpeningTheGameSessionLogFile();
            return -1; // error
        }

        File[] filesThatMatchThePattern = directoryToSearch.listFiles((pathname, name) -> {
            Matcher matcher = pattern.matcher(name);
            return matcher.matches();
        });

        int highestNumber = -1;

        for (File file : Objects.requireNonNull(filesThatMatchThePattern)) {
            Matcher matcher = pattern.matcher(file.getName());
            if (matcher.matches()) {
                int number = Integer.parseInt(matcher.group(1));
                if (number > highestNumber) {
                    highestNumber = number;
                }
            }
        }
        return highestNumber;
    }
}
