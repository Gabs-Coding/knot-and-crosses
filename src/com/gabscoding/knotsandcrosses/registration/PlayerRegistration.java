package com.gabscoding.knotsandcrosses.registration;

import java.util.Scanner;

public class PlayerRegistration {
    public static String getNameOfPlayerFromUser(){
        try (Scanner userInputScanner = new Scanner(System.in)) {
            System.out.println("Insira o nome do jogador: ");
            return userInputScanner.next();
        }
    }
}
