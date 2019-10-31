package ru.kruglov.task20;

import ru.kruglov.localLibs.InputDataHandle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

class Application {
    private BufferedReader buff;
    boolean appStatus = true;
    private final static String PATH_TO_API = "https://cat-fact.herokuapp.com";
    private final static String GET_FACTS = "/facts";
    private final static String GET_USERS = "/users";

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
                Commands command = Commands.valueOf(inputPhrase.toUpperCase());
                switch (command) {
                    case HELP:
                        getHelp();
                        break;
                    case EXIT:
                        exitApp();
                        break;
                    case GET:
                        sendGetRequest();
                        break;
                }
            } catch (IOException e) {
                buff.close();
                e.printStackTrace();
                appStatus = false;
            }
        }
    }

    private void sendGetRequest() {

    }
}

