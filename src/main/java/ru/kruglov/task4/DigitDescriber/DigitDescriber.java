package ru.kruglov.task4.DigitDescriber;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DigitDescriber {
    private int inputDigit;

    public void inputDigitSetter(String inputString) {
        try {
            inputDigit = Integer.parseInt(inputString);
            digitDescriber();
        } catch (NumberFormatException nfe) {
            System.out.println("Wrong value. Please enter again");
        }
    }

    private String getDataFromSystemIn() throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String inputValue = buff.readLine();
        return inputValue;
    }

    private void digitDescriber() {
        System.out.println(
            "Inputted digit: " + inputDigit + "\n" +
            "Parity: " + parityDeterminer() + "\n" +
            "Sign: " + signOfDigitDeterminer() + "\n"
        );
    }

    private String signOfDigitDeterminer() {
        if (inputDigit > 0) {
            return "positive";
        } else if (inputDigit < 0 ) {
            return "negative";
        } else {
            return "zero";
        }
    }

    private String parityDeterminer() {
        if (inputDigit % 2 == 0) {
            return "even";
        } else return "odd";
    }

    public static void main(String[] args) throws IOException {
        boolean appStatus = true;
        while (appStatus) {
            DigitDescriber digitDescriber = new DigitDescriber();
            System.out.println("Print any integer digit:");
            String userInput= digitDescriber.getDataFromSystemIn();
            if (userInput.equals("exit")) {
                System.out.println("Application is being closing");
                appStatus = false;
            } else {
                digitDescriber.inputDigitSetter(userInput);
            }
        }
    }
}
