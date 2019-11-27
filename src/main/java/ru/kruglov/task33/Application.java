package ru.kruglov.task33;

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
                    case FIND:
                        Messages.TYPE_THE_WORD.printMessage();
                        printResult();
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

    private void printResult() {
        MaximumRepeatableCharFind mrch = new MaximumRepeatableCharFind(buff);
        String foundChar = mrch.returnFirstUnrepeatableChar();
        String inputWord = mrch.getInputWord();
        int countOfRepeting = mrch.getMaxRepeatingCount();

        System.out.printf("Character: %s has occurred maximum times in %s: %d \n", foundChar,inputWord,countOfRepeting);
    }
}

