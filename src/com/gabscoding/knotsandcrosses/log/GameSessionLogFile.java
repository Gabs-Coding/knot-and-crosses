package com.gabscoding.knotsandcrosses.log;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameSessionLogFile {
    private static final String LOG_FILE_ARCHIVE_EXTENSION = ".txt";
    private static final String PATTERN_OF_THE_GAME_SESSION_LOG_FILE_NAME =
            "\\d{4}-\\d{2}-\\d{2}-game(\\d+)";
    private static final String LOG_FILE_PATH = "./logfiles";
    private final File gameSessionLogFile;
    private final String gameSessionLogFilePath;

    public GameSessionLogFile(String nameOfTheGameSession) {
        this.gameSessionLogFilePath = LOG_FILE_PATH;
        this.gameSessionLogFile = tryCreateTheLogFile(nameOfTheGameSession);
    }

    private File tryCreateTheLogFile(String nameOfTheGameSession) {
        File directory = new File(gameSessionLogFilePath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File logFile = new File(directory, nameOfTheGameSession + LOG_FILE_ARCHIVE_EXTENSION);
        try {
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return logFile;
    }

    public static int getTheLastIndexOfGameSessionLogFile() {
        File directoryToSearch = new File(LOG_FILE_PATH);
        Pattern pattern = Pattern.compile(PATTERN_OF_THE_GAME_SESSION_LOG_FILE_NAME);

        if (!directoryToSearch.exists()) {
            directoryToSearch.mkdirs(); // Cria o diretório se ele não existir
        }

        if (!directoryToSearch.isDirectory()) {
            GameSessionLogger.getInstance().logErrorWhileOpeningTheGameSessionLogFile();
            throw new IllegalStateException("The log directory does not exist.");
        }

        File[] filesThatMatchThePattern = directoryToSearch.listFiles((pathname, name) -> {
            Matcher matcher = pattern.matcher(name);
            return matcher.matches();
        });

        if (filesThatMatchThePattern == null || filesThatMatchThePattern.length == 0) {
            return 0; // No log files found
        }

        int highestNumber = 0;

        for (File file : filesThatMatchThePattern) {
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
