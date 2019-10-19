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
        ConsoleMessages.GOODBYE.printMessage();
        buff.close();
        appStatus = false;
    }

    private void getHelp() {
        ConsoleMessages.HELP.printMessage();
    }

    void appHandler() throws IOException {
        while (appStatus) {
            ConsoleMessages.WELCOME.printMessage();
            try {
                String inputPhrase = InputDataHandle.getDataFromSystemIn(this.buff);
                if (inputPhrase.equals(CommandMessages.HELP.getMessage())) {
                    getHelp();
                } else if (inputPhrase.equals(CommandMessages.EXIT.getMessage())) {
                    exitApp();
                } else if (inputPhrase.equals(CommandMessages.CREATE.getMessage())) {
                    new FileAction(buff).createFile();
                } else if (inputPhrase.equals(CommandMessages.COPY.getMessage())) {
                    new FileAction(buff).copyFile();
                } else if (inputPhrase.equals(CommandMessages.RENAME.getMessage())) {
                    new FileAction(buff).renameFile();
                } else if (inputPhrase.equals(CommandMessages.DELETE.getMessage())) {
                    new FileAction(buff).deleteFile();
                } else if (inputPhrase.equals(CommandMessages.TRAVERSAL.getMessage())) {
                    new TreeTraversal(buff);
                } else {
                    wrongInput();
                }
            } catch (IOException e) {
                buff.close();
                ExceptionMessages.ERROR_APP_HANDLER.printMessage();
                e.printStackTrace();
            }
        }
    }

    private void wrongInput() {
        ConsoleMessages.WRONG_INPUT.printMessage();
    }
}
