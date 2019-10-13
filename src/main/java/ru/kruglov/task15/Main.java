package ru.kruglov.task15;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            UIHandler uiHandler = new UIHandler();
            uiHandler.fileWorker();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
