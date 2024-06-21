package com.gabscoding.knotsandcrosses.model;

public class Grid {
    private static Grid gridInstance;
    private Integer grid[][];
    private Boolean isTheGridFull;
    private Boolean hasWinningSequenceMarked;

    private Grid () {
        grid = new Integer[3][3];
        isTheGridFull = false;
        hasWinningSequenceMarked = false;
    }

    public static Grid getGridInstance() {
        return gridInstance;
    }

    public static void setGridInstance(Grid gridInstance) {
        Grid.gridInstance = gridInstance;
    }

    public Integer[][] getGrid() {
        return grid;
    }

    public void setGrid(Integer[][] grid) {
        this.grid = grid;
    }

    public Boolean getTheGridFull() {
        return isTheGridFull;
    }

    public void setTheGridFull(Boolean theGridFull) {
        isTheGridFull = theGridFull;
    }

    public Boolean getHasWinningSequenceMarked() {
        return hasWinningSequenceMarked;
    }

    public void setHasWinningSequenceMarked(Boolean hasWinningSequenceMarked) {
        this.hasWinningSequenceMarked = hasWinningSequenceMarked;
    }

    public static Grid getInstance() {
        if (gridInstance == null) { return new Grid(); }
        return gridInstance;
    }
}
