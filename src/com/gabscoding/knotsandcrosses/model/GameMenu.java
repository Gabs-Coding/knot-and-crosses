package com.gabscoding.knotsandcrosses.model;

import com.gabscoding.knotsandcrosses.util.ClearConsole;

import java.util.*;

public class GameMenu {
    public enum GameMenuParts {
        HEADER, OPTIONS
    }
    private Map<GameMenuParts, String> gameMenuContent;

    public GameMenu() {
        GameMenuDirector director = new GameMenuDirector();
        SimpleGameMenuBuilder builder = new SimpleGameMenuBuilder();
        director.constructSimpleGameMenu(builder);
        SimpleGameMenu simpleGameMenu = builder.getSimpleGameMenu();
        gameMenuContent = new HashMap<>();
        gameMenuContent.put(GameMenuParts.HEADER, simpleGameMenu.getHeader());
        gameMenuContent.put(GameMenuParts.OPTIONS, simpleGameMenu.getOptions());
    }

    public void showMainMenu() {
        ClearConsole.clearConsole();
        for (String gameMenuElement : gameMenuContent.values()){
            System.out.println(gameMenuElement);
        }
    }

    private int getTheInputForMenuFromTheUser() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
