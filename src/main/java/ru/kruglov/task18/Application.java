package ru.kruglov.task18;

import ru.kruglov.localLibs.FileCopier;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.UnsupportedCharsetException;

import static ru.kruglov.localLibs.InputDataHandle.*;

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
                String inputPhrase = getDataFromSystemIn(this.buff);
                if (inputPhrase.equals(Commands.HELP.getMessage())) {
                    getHelp();
                } else if (inputPhrase.equals(Commands.EXIT.getMessage())) {
                    exitApp();
                } else if (inputPhrase.equals(Commands.COPY.getMessage())) {
                    copyFile();
                } else {
                    //TODO
                }
            } catch (IOException e) {
                buff.close();
                e.printStackTrace();
                appStatus = false;
            }
        }
    }

    private void copyFile() {
        try {
            Messages.COPY_FROM_ORIGIN_PATH.printMessage();
            String originPath = getDataFromSystemIn(buff);
            File file = new File(originPath);
            if (file.exists() && !file.isDirectory()) {
                Messages.COPY_TO_NEW_PATH.printMessage();
                String newPath = getDataFromSystemIn(buff);
                Messages.COPY_FILE_CHARSET.printMessage();
                String charset = getDataFromSystemIn(buff);
                FileCopier.fileCopier(file.getCanonicalPath(), newPath, charset);
                Messages.SUCCESSFUL_OPERATION.printMessage();
            } else {
                Messages.UNSECCESSFUL_OPERATION.printMessage();
            }
        } catch (UnsupportedCharsetException e) {
            Messages.UNSUPPORTED_ENCODING.printMessage();
        } catch (IOException e) {
            Messages.WRONG_INPUT.printMessage();
        }
    }
}

