package ru.kruglov.task19;

import ru.kruglov.localLibs.InputDataHandle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
                } else if (inputPhrase.equals(Commands.CHEQUE.getMessage())) {
                    getArray("products.txt", 3);
                } else {
                }
            } catch (IOException e) {
                buff.close();
                e.printStackTrace();
                appStatus = false;
            }
        }
    }

    private void getArray(String path, int mult) {
        ProductFileReader productFileReader = new ProductFileReader(path,mult);
        try {
            String[][] a = productFileReader.arrayReturner();
            for (String[] str: a) {
                for (String str1 : str) {
                    System.out.print(str1 + " ");
                }
                System.out.print("\n");
            }

        } catch (RemainderOfDivisionException e) {
            //TODO Handle exception
        } catch (FileNotFoundException e) {
            //TODO Handle exception
        }
    }
}

