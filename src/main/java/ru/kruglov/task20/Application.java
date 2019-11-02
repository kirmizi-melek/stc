package ru.kruglov.task20;

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
                    case PRINT:
                        printFacts();
                        break;
                }
            } catch (IOException e) {
                buff.close();
                e.printStackTrace();
                appStatus = false;
            }
        }
    }

    private void printFacts() {
        FactSerializator factSerializator = new FactSerializator();
        new FactPrinter().printFactfromArrayOfFacts(factSerializator.getArrayOfFactsFromFile());
    }

    private void sendGetRequest() {
        try {
            new URLConnectionReader().request();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

