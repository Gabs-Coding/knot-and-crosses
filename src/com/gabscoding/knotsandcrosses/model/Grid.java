package com.gabscoding.knotsandcrosses.model;

import com.gabscoding.knotsandcrosses.log.GameSessionLogger;
import com.gabscoding.knotsandcrosses.log.PlayerLogger;

public class Grid {
    private final char[][] grid;
    private boolean hasWinningSequenceMarked;
    private static final char xSymbol = 'X';
    private static final char oSymbol = 'O';

    protected Grid () {
        grid = new char[3][3];
        hasWinningSequenceMarked = false;
    }

    public boolean isTheGridFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == '\u0000') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean getHasWinningSequenceMarked() {
        return hasWinningSequenceMarked;
    }

    public void setHasWinningSequenceMarked(Boolean hasWinningSequenceMarked) {
        this.hasWinningSequenceMarked = hasWinningSequenceMarked;
    }

    public void makeMove(Player playerOnTheMove, int positionChosedByThePlayerToMark) {
        if (hasTheConditionsToPlay(positionChosedByThePlayerToMark)) {
            PlayerLogger.getInstance().logPlayerTryingToMoveToOcuppiedGridPosition();
            return;
        }
        char symbolOfThePlayer = playerOnTheMove.getSymbolOfThePlayer();
        Integer[] gridPositionToMark = convertPositionToGridIndexes(positionChosedByThePlayerToMark);
        grid[gridPositionToMark[0]][gridPositionToMark[1]] = symbolOfThePlayer;
        if (checkIfHasWinningSequence(gridPositionToMark[0], gridPositionToMark[1], symbolOfThePlayer)) {
            hasWinningSequenceMarked = true;
            GameSessionLogger.getInstance().logEndGame();
        }
    }

    private boolean hasTheConditionsToPlay(int positionChosedByThePlayerToMark) {
        return isThePositionChosedValid(positionChosedByThePlayerToMark) && !isTheGridFull();
    }

    private boolean isThePositionChosedValid(int positionChosedByThePlayerToMark) {
        return (positionChosedToMoveIsInTheBounds(positionChosedByThePlayerToMark) &&
                positionAlreadyOccupied(positionChosedByThePlayerToMark));
    }

    private boolean positionChosedToMoveIsInTheBounds(int positionChosedByThePlayerToMark) {
        return positionChosedByThePlayerToMark > 0 && positionChosedByThePlayerToMark < 9;
    }

    private boolean positionAlreadyOccupied(int positionOnTheGrid) {
        Integer[] gridPosition = convertPositionToGridIndexes(positionOnTheGrid);
        return (grid[gridPosition[0]][gridPosition[1]] != '\u0000');
    }

    @org.jetbrains.annotations.Contract(value = "_ -> new", pure = true)
    private Integer @org.jetbrains.annotations.NotNull [] convertPositionToGridIndexes(int position) {
        int row;
        int column;
        if (position > 0 && position < 4) {
            row = 0;
            column = position - 1;
        } else if (position > 3 && position < 7) {
            row = 1;
            column = position - 4;
        } else { // 7 <= position <= 9
            row = 2;
            column = position - 7;
        }
        return new Integer[]{row, column};
    }

    private boolean checkIfHasWinningSequence(int row, int column,char symbolOfThePlayer) {
        return checkIfHasWinningInRow(row, symbolOfThePlayer) ||
                checkIfHasWinningInColumn(column, symbolOfThePlayer) ||
                checkIfHasWinningInDiagonal(symbolOfThePlayer);
    }

    private boolean checkIfHasWinningInRow(int row, char symbolOfThePlayer) {
        for (int i = 0; i < 3; i++) {
            if(grid[row][i] != symbolOfThePlayer) {
                return false;
            }
        }
        return true;
    }

    private boolean checkIfHasWinningInColumn(int column, char symbolOfThePlayer) {
        for (int i = 0; i < 3; i++) {
            if(grid[i][column] != symbolOfThePlayer) {
                return false;
            }
        }
        return true;
    }

    private boolean checkIfHasWinningInDiagonal(char symbolOfThePlayer) {
        boolean mainDiagonal = true;
        boolean secondaryDiagonal = true;
        for (int i = 0; i < 3; i++) {
            if(grid[i][i] != symbolOfThePlayer) {
                mainDiagonal = false;
            }
            if (grid[i][2 - i] != symbolOfThePlayer) {
                secondaryDiagonal = false;
            }
        }
        return mainDiagonal || secondaryDiagonal;
    }

    public void showGrid() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 2) {
                    System.out.println(grid[i][j]);
                } else {
                    System.out.print(grid[i][j]);
                }
            }
        }
    }
}
