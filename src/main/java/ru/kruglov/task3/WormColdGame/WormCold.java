package ru.kruglov.task3.WormColdGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WormCold {

    private String getDataFromSystemIn() throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        return buff.readLine();
    }

    private boolean numericComparator(int guessedNumeric, int playerGuess) {
        return playerGuess == guessedNumeric;
    }

    private String callbackOnPlayerAnswer(int guessedNumeric, int currentPlayerGuess, int previousPlayerGuess) {
        int diffBetweenGuessedAndCurrent = (guessedNumeric - currentPlayerGuess);
        int diffBetweenGuessedAndPrevious = (guessedNumeric - previousPlayerGuess);
        if (currentPlayerGuess < guessedNumeric) {
            if (diffBetweenGuessedAndPrevious > diffBetweenGuessedAndCurrent) {
                return "Warmer\n";
            } else return "Colder\n";
        } else {
            if (diffBetweenGuessedAndCurrent > diffBetweenGuessedAndPrevious) {
                return "Warmer\n";
            } else return "Colder\n";
        }
    }

    private int numericRandomizer() {
        float floatRandom = Math.round(Math.random()*100);
        return (int) floatRandom;
    }

    private void startGame() throws IOException{
        int currentPlayerGuess = -1;
        int previousPlayerGuess = 0;
        int guessedNumeric = numericRandomizer();
        System.out.println("Welcome to the Cold Warm Game! \nPlease type any numeric from 0 to 100\n");
        while (!(numericComparator(guessedNumeric, currentPlayerGuess))) {
            System.out.println("Your answer:");
            String playerInputPhrase = getDataFromSystemIn();
            if (playerInputPhrase.equals("exit")) {
                System.out.println("Bye-bye");
                //System.exit(0);
            } else if (playerInputPhrase.equals("help")) {
                System.out.println("\nApplication commands\n" +
                        "help - get help about the game\n" +
                        "exit - quit the game\n");
            } else {
                currentPlayerGuess = Integer.parseInt(playerInputPhrase);
                if (!(numericComparator(guessedNumeric, currentPlayerGuess))) {
                    System.out.println(
                            callbackOnPlayerAnswer(guessedNumeric, currentPlayerGuess, previousPlayerGuess));
                } else System.out.println("You're won! Congragulation!");
                previousPlayerGuess = currentPlayerGuess;
            }
        }
    }

    public static void main(String[] args) {
        WormCold wcGame = new WormCold();
        try {
            wcGame.startGame();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
