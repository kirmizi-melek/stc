package ru.kruglov.task20;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            new Application().appHandler();
        } catch (IOException e) {
            Messages.ERROR_APP_HANDLER.printMessage();
            e.printStackTrace();
        }
    }
}
