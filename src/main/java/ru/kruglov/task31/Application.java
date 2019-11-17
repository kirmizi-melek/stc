package ru.kruglov.task31;

import ru.kruglov.localLibs.InputDataHandle;
import ru.kruglov.task30.FirstUnrepeatableCharFind;

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
                    case REVERT_DOUBLESIDE:
                        Messages.TYPE_THE_WORD.printMessage();
                        RevertWord doubleRevertWord = new RevertWord(buff);
                        doubleRevertWord.doubleSideRever();
                        System.out.println(doubleRevertWord.getOutputWord());
                        //System.out.println(new FirstUnrepeatableCharFind(buff).returnFirstUnrepeatableChar());
                        break;
                    case REVERT_STANDART:
                        Messages.TYPE_THE_WORD.printMessage();
                        RevertWord standartRevertWord = new RevertWord(buff);
                        standartRevertWord.standartRevert();
                        System.out.println(standartRevertWord.getOutputWord());
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

