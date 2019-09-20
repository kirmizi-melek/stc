package ru.kruglov.task8.Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

class Calculator {
    private boolean appStatus;

    Calculator() {
        this.appStatus = true;
    }

    void start() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        while (appStatus) {
            System.out.println();
        }
    }

}
