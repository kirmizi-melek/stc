package ru.kruglov.task15;

import ru.kruglov.localLibs.InputDataHandle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Application {
    private BufferedReader buff;
    boolean appStatus = true;

    Application() {
        buff = new BufferedReader(new InputStreamReader(System.in));
    }

    private void exitApp() throws IOException {
        Responses.GOODBYE.printMessage();
        buff.close();
        appStatus = false;
    }

    private void getHelp() {
        Responses.HELP.printMessage();
    }

    void appHandler() throws IOException {
        while (appStatus) {
            Responses.WELCOME.printMessage();
            try {
                String inputPhrase = InputDataHandle.getDataFromSystemIn(this.buff);
                if (inputPhrase.equals(Commands.HELP.getMessage())) {
                    getHelp();
                } else if (inputPhrase.equals(Commands.EXIT.getMessage())) {
                    exitApp();
                } else if (inputPhrase.equals(Commands.CREATE.getMessage())) {
                    new FileAction(buff).createFile();
                } else if (inputPhrase.equals(Commands.COPY.getMessage())) {
                    new FileAction(buff).copyFile();
                } else if (inputPhrase.equals(Commands.RENAME.getMessage())) {
                    new FileAction(buff).renameFile();
                } else if (inputPhrase.equals(Commands.DELETE.getMessage())) {
                    new FileAction(buff).deleteFile();
                } else {
                    wrongInput();
                }
            } catch (IOException e) {
                buff.close();
                e.printStackTrace();
            }
        }
    }

    private void wrongInput() {
        Responses.WRONG_INPUT.printMessage();
    }
}
