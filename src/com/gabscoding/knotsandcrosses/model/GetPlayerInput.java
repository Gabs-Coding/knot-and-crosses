package com.gabscoding.knotsandcrosses.model;

import java.util.Scanner;

public class GetPlayerInput {

    public static int getPositionToMove() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
