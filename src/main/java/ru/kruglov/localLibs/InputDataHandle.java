package ru.kruglov.localLibs;

import java.io.BufferedReader;
import java.io.IOException;

public class InputDataHandle {

    public static String getDataFromSystemIn(BufferedReader buff) throws IOException {
        String inputValue = buff.readLine();
        return inputValue;
    }
}
