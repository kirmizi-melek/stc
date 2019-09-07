package ru.kruglov.task2.WormColdGame;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WormCold {


    private String getDataFromSystemIn() throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String inputValue = buff.readLine();
        return inputValue;
    }

    private boolean numericComparator(int guessedNumeric, int playerGuess) {
        if ( playerGuess == guessedNumeric ) {
            return true;
        } else return false;
    }

    private String callbackOnPlayerAnswer(int guessedNumeric, int currentPlayerGuess, int previousPlayerGuess) {
        //String rightAnswer = "Right answer. Congragulation!";
        //String answerIsLess = "Wo ";

        if ((guessedNumeric-currentPlayerGuess) > (guessedNumeric-previousPlayerGuess)) {
            return "Warmer";
        } else return "Colder";
    }

    private int numericRandomizer() {
        float floatRandom = Math.round(Math.random()*100);
        int intRandom = (int) floatRandom;
        return intRandom;
    }

    private void startGame() throws IOException{
        int currentPlayerGuess = -1;
        int previousPlayerGuess = 0;
        int guessedNumeric = numericRandomizer();
        System.out.println("Welcome to the Cold Warm Game! Please type any numeric from 0 to 100");
        System.out.println("Guessed numeric = " + guessedNumeric);
        while (currentPlayerGuess != guessedNumeric) {
            System.out.println("Your answer:");
            currentPlayerGuess = Integer.parseInt(getDataFromSystemIn());
            System.out.println(
                    callbackOnPlayerAnswer(guessedNumeric, currentPlayerGuess, previousPlayerGuess));
        }
    }

    public static void main(String Args[]) {
        WormCold wcGame = new WormCold();
        try {
            wcGame.startGame();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.exit(1);
        }

    }
}
