package ru.kruglov.task11;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Censor calc = new Censor();
        try {
            calc.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
