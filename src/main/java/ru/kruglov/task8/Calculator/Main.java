package ru.kruglov.task8.Calculator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        try {
            calc.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
