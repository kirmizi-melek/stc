package ru.kruglov.task18;

import ru.kruglov.localLibs.FileCopier;
import ru.kruglov.localLibs.FileRead;
import ru.kruglov.localLibs.InputDataHandle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Application {
    private BufferedReader buff;
    boolean appStatus = true;
    private String pathToLibrary = "library.csv";

    Application() {
        buff = new BufferedReader(new InputStreamReader(System.in));
    }

    private void exitApp() throws IOException {
        Messages.GOODBYE.printMessage();
        buff.close();
        appStatus = false;
    }

    private void getHelp() {
        Messages.HELP.printMessage();
    }

    void appHandler() throws IOException {
        while (appStatus) {
            Messages.WELCOME.printMessage();
            try {
                String inputPhrase = InputDataHandle.getDataFromSystemIn(this.buff);
                if (inputPhrase.equals(Commands.HELP.getMessage())) {
                    getHelp();
                } else if (inputPhrase.equals(Commands.EXIT.getMessage())) {
                    exitApp();
                } else if (inputPhrase.equals(Commands.COPY.getMessage())) {
                    FileCopier.fileCopier("library.csv", "newLibrary.csv");
                } else {
                }
            } catch (IOException e) {
                buff.close();
                e.printStackTrace();
                appStatus = false;
            }
        }
    }
}

