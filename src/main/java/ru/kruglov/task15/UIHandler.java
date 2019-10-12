package ru.kruglov.task15;

import ru.kruglov.localLibs.InputDataHandle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UIHandler {
    private BufferedReader buff;

    UIHandler() {
        buff = new BufferedReader(new InputStreamReader(System.in));
    }

    public void fileWorker() throws IOException {
        boolean appStatus = true;
        Responses.WELCOME.printMessage();
        while (appStatus) {
            try {
                String inputPhrase = InputDataHandle.getDataFromSystemIn(this.buff);
                if (inputPhrase.equals(Commands.HELP.getMessage())) {
                        Responses.HELP.printMessage();
                } else if (inputPhrase.equals(Commands.EXIT.getMessage())) {
                    Responses.GOODBYE.printMessage();
                    buff.close();
                    appStatus = false;
                } else if (inputPhrase.equals(Commands.CREATE.getMessage())) {

                } else if (inputPhrase.equals(Commands.COPY.getMessage())) {

                } else if (inputPhrase.equals(Commands.RENAME.getMessage())) {

                } else if (inputPhrase.equals(Commands.DELETE.getMessage())) {

                } else {
                    Responses.WRONG_INPUT.printMessage();
                }
            } catch (IOException e) {
                buff.close();
                e.printStackTrace();
            }
        }
    }
}
