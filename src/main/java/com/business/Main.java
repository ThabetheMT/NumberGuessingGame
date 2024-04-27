package com.business;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            int option = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Please choose from the option below:\n" +
                            "1) To play the game\n" +
                            "0) exit\n"));
            int score = 0;
            int gamesPlayed = 0;
            String outcome = "";

            switch (option){
                case 1:

            while (option != 0) {
                int userGuess = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Enter a number between (1-10)"));
                int computerGuess = randomNumber();
                while (!verifyRange(userGuess)) {
                    userGuess = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "invalid number! Enter a number between (1-10)"));
                }
                if (correctGuess(userGuess, computerGuess)) {
                    score++;
                    outcome = outcome(userGuess, computerGuess);
                } else {
                    outcome = outcome(userGuess, computerGuess);
                }
                gamesPlayed++;
                option = Integer.parseInt(JOptionPane.showInputDialog(null, "" +
                        outcome +
                        "\nYour guess: " + userGuess +
                        "\nComputer generated: " + computerGuess +
                        "\nPlay again?\n" +
                        "1) To play the game\n" +
                        "0) exit\n"));
            }
                break;
                default: JOptionPane.showMessageDialog(null,"Invalid option");
            }
            JOptionPane.showMessageDialog(null, "Games played: " + gamesPlayed +
            "\nUser won: " + score +
            "\nComputer won: " + (gamesPlayed - score));

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public static int randomNumber(){
        return new Random().nextInt(10) + 1;
    }
    public static boolean verifyUserGuess(int userGuess){
        return Character.isDigit(userGuess);
    }
    public static boolean verifyRange(int userGuess){
        return userGuess >= 0 && userGuess <= 10;
    }
    public static boolean correctGuess(int userGuess, int computerGuess){
        return userGuess == computerGuess;
    }
    public static String outcome(int userGuess, int computerGuess){
        return correctGuess(userGuess, computerGuess)? "Correct":"wrong";
    }
}