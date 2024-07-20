package com.gabscoding.knotsandcrosses.model;

public class SimpleGameMenuBuilder implements GameMenuContentBuilder{
    private SimpleGameMenu simpleGameMenu;

    public SimpleGameMenuBuilder() {
        this.reset();
    }

    public void reset() {
        this.simpleGameMenu = new SimpleGameMenu();
    }

    public void buildGameMenuHeader(String header) {
        simpleGameMenu.setHeader(header);
    }

    public void buildGameMenuOptions(String options) {
        simpleGameMenu.setOptions(options);
    }

    public SimpleGameMenu getSimpleGameMenu() {
        SimpleGameMenu myNewSimpleGameMenu = this.simpleGameMenu;
        this.reset();
        return myNewSimpleGameMenu;
    }
}
