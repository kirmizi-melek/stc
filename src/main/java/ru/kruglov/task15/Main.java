package ru.kruglov.task15;

import ru.kruglov.localLibs.InputDataHandle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
