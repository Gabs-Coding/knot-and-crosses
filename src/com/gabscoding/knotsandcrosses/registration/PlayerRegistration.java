package com.gabscoding.knotsandcrosses.registration;

import java.util.Scanner;

public class PlayerRegistration {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getNameOfPlayerFromUser() {
        System.out.print("Insira o nome do jogador: ");
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        } else {
            throw new IllegalStateException("Nenhuma linha de entrada encontrada.");
        }
    }
}
