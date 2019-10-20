package ru.kruglov.task17;

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
                } else if (inputPhrase.equals(Commands.ADD_BOOK.getMessage())) {
                   // new FileAction(buff).createFile();
                } else if (inputPhrase.equals(Commands.GET_LIST_OF_BOOKS.getMessage())) {
                    //new FileAction(buff).copyFile();
                } else {
                    wrongInput();
                }
            } catch (IOException e) {
                buff.close();
                Messages.ERROR_APP_HANDLER.printMessage();
                e.printStackTrace();
            }
        }
    }

    private void wrongInput() {
        Messages.WRONG_INPUT.printMessage();
    }
}

