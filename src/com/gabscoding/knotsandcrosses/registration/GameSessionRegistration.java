package com.gabscoding.knotsandcrosses.registration;

import com.gabscoding.knotsandcrosses.log.GameSessionLogFile;

import java.time.LocalDate;

public class GameSessionRegistration {
    public static String createTheNameOfTheGameSession() {
        StringBuilder nameOfTheGameSession = new StringBuilder();
        LocalDate localDate = LocalDate.now();
        nameOfTheGameSession.append(localDate);
        nameOfTheGameSession.append("-game");
        nameOfTheGameSession.append(GameSessionLogFile.getTheLastIndexOfGameSessionLogFile());
        return nameOfTheGameSession.toString();
    }
}
