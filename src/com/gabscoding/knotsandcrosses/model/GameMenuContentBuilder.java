package com.gabscoding.knotsandcrosses.model;

public interface GameMenuContentBuilder {
    void reset();
    void buildGameMenuHeader(String header);
    void buildGameMenuOptions(String options);
}
