package ru.kruglov.task15;

import ru.kruglov.localLibs.InputDataHandle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UIHandler {
    private BufferedReader buff;

    UIHandler() {
        buff = new BufferedReader(new InputStreamReader(System.in));
    }

    public void fileWorker() throws IOException {
        boolean appStatus = true;
        while (appStatus) {
            Responses.WELCOME.printMessage();
            try {
                String inputPhrase = InputDataHandle.getDataFromSystemIn(this.buff);
                if (inputPhrase.equals(Commands.HELP.getMessage())) {
                    Responses.HELP.printMessage();
                } else if (inputPhrase.equals(Commands.EXIT.getMessage())) {
                    Responses.GOODBYE.printMessage();
                    buff.close();
                    appStatus = false;
                } else if (inputPhrase.equals(Commands.CREATE.getMessage())) {
                    String pathToFile = InputDataHandle.getDataFromSystemIn(this.buff);
                    FileAction file = new FileAction(pathToFile);
                    file.createFile();
                    Responses.SUCCESSFUL_OPERATION.printMessage();
                } else if (inputPhrase.equals(Commands.COPY.getMessage())) {
                    Responses.COPY_FROM_ORIGIN_PATH.printMessage();
                    String originPath = InputDataHandle.getDataFromSystemIn(this.buff);
                    Responses.COPY_TO_NEW_PATH.printMessage();
                    String newPath = InputDataHandle.getDataFromSystemIn(this.buff);
                    FileAction file = new FileAction(originPath);
                    file.copyFile(newPath);
                    Responses.SUCCESSFUL_OPERATION.printMessage();

                } else if (inputPhrase.equals(Commands.RENAME.getMessage())) {
                    Responses.RENAME_ORIGIN_NAME.printMessage();
                    String originName = InputDataHandle.getDataFromSystemIn(this.buff);
                    Responses.RENAME_NEW_NAME.printMessage();
                    String newName = InputDataHandle.getDataFromSystemIn(this.buff);
                    FileAction file = new FileAction(originName);
                    file.renameFile(newName);
                    Responses.SUCCESSFUL_OPERATION.printMessage();
                } else if (inputPhrase.equals(Commands.DELETE.getMessage())) {
                    Responses.DELETE_FILE_NAME.printMessage();
                    String name = InputDataHandle.getDataFromSystemIn(this.buff);
                    FileAction file = new FileAction(name);
                    file.deleteFile();
                    Responses.SUCCESSFUL_OPERATION.printMessage();
                } else {
                    Responses.WRONG_INPUT.printMessage();
                }
            } catch (IOException e) {
                buff.close();
                e.printStackTrace();
            }
        }
    }
}
