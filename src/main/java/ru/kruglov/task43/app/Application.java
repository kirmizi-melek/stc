package ru.kruglov.task43.app;

import ru.kruglov.localLibs.InputDataHandle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    private BufferedReader buff;
    boolean appStatus = true;

    public Application() {
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

    public void appHandler() throws IOException {
        while (appStatus) {
            Messages.WELCOME.printMessage();
            try {
                String inputPhrase = InputDataHandle.getDataFromSystemIn(this.buff);
                Commands command = Commands.valueOf(inputPhrase.toUpperCase());
                switch (command) {
                    case HELP:
                        getHelp();
                        break;
                    case EXIT:
                        exitApp();
                        break;
                    case GETBOOKS:
                        break;
                    case RETREADER:
                        break;
                    case GETREADERBOOKS:
                        break;
                    case ASSIGNBOOK:
                        break;
                    case GETSTAT:
                        break;
                    case SEARCH:
                        break;
                }
            } catch (IOException e) {
                Messages.WRONG_INPUT.printMessage();
                buff.close();
                e.printStackTrace();
                appStatus = false;
            }
        }
    }
}
