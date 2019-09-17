package ru.kruglov.task4.MultiplyTable;

import ru.kruglov.localLibs.InputDataHandle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplyTable {
    private int inputDigit;

    private boolean inputDigitSetter(String inputString) {
        try {
            inputDigit = Integer.parseInt(inputString);
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println("Wrong value. Please enter again\n");
            return false;
        }
    }

    private void multiplier() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(inputDigit + " x " + i + " = " + inputDigit * i);
        }
        System.out.println("\n");
    }

    public static void main(String[] args) throws IOException {
        boolean appStatus = true;
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        while (appStatus) {
            System.out.println("<<Multiplication table>>");
            System.out.println("Print any integer digit:");
            MultiplyTable multiplyTable = new MultiplyTable();
            String userInput = InputDataHandle.getDataFromSystemIn(buff);
            //String userInput = multiplyTable.getDataFromSystemIn();
            if (userInput.equals("exit")) {
                System.out.println("Application is being closing");
                appStatus = false;
            } else {
                if (!multiplyTable.inputDigitSetter(userInput)) continue;
                multiplyTable.multiplier();
            }
        }
    }
}
