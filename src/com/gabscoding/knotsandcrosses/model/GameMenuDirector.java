package com.gabscoding.knotsandcrosses.model;

public class GameMenuDirector {
    public void constructSimpleGameMenu(SimpleGameMenuBuilder builder) {
        String headerOfGameMenu = "KNOTH AND CROSSES: THE CONSOLE GAME" +
                "\nThe beloved classic game.";
        String optionsOfGameMenu = """
                1 \t Iniciar um novo jogo\

                2 \t Ver histórico de jogos
                3 \t Fechar o jogo""";
        builder.buildGameMenuHeader(headerOfGameMenu);
        builder.buildGameMenuOptions(optionsOfGameMenu);
    }
}
