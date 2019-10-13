package ru.kruglov.task15;

import ru.kruglov.localLibs.InputDataHandle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class UIHandler {
    private BufferedReader buff;

    UIHandler() {
        buff = new BufferedReader(new InputStreamReader(System.in));
    }

    void fileWorker() throws IOException {
        boolean appStatus = true;
        while (appStatus) {
            Responses.WELCOME.printMessage();
            try {
                String inputPhrase = InputDataHandle.getDataFromSystemIn(this.buff);
                if (inputPhrase.equals(Commands.HELP.getMessage())) {
                    Responses.HELP.printMessage();
                } else if (inputPhrase.equals(Commands.EXIT.getMessage())) {
                    Responses.GOODBYE.printMessage();
                    buff.close();
                    appStatus = false;
                } else if (inputPhrase.equals(Commands.CREATE.getMessage())) {
                    new FileAction(buff).createFile();
                } else if (inputPhrase.equals(Commands.COPY.getMessage())) {
                    new FileAction(buff).copyFile();
                } else if (inputPhrase.equals(Commands.RENAME.getMessage())) {
                    new FileAction(buff).renameFile();
                } else if (inputPhrase.equals(Commands.DELETE.getMessage())) {
                    new FileAction(buff).deleteFile();
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
