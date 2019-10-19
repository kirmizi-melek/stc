package ru.kruglov.task15;

import ru.kruglov.localLibs.InputDataHandle;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class TreeTraversal {
    BufferedReader buff;

    TreeTraversal(BufferedReader buff) {
        this.buff = buff;
        method();
    }

    void method() {
        try {
            ConsoleMessages.TREE_TRAVERSAL.printMessage();
            String pathToFolder = InputDataHandle.getDataFromSystemIn(buff);
            File folder = new File(pathToFolder);
            if (!folder.exists()) {
                ConsoleMessages.FOLDER_NOT_EXIST.printMessage();
            } else {
                if (folder.isFile()) {
                    ConsoleMessages.TARGET_IS_A_FILE.printMessage();
                } else {
                    list(folder);
                }
            }
        } catch (IOException e) {
            ExceptionMessages.ERROR_TREE_TRAVERSAL.printMessage();
            e.printStackTrace();
        }
    }

    private void list(File folder) {
        String folderPath = folder.getAbsolutePath();
        String[] listOfPaths = folder.list();
        for (String listOfPath : listOfPaths) {
            File f1 = new File(folderPath + File.separator + listOfPath);
            if (f1.isFile())
                System.out.println(folderPath + File.separator + listOfPath);
            else {
                list(new File(folderPath + File.separator + listOfPath));
            }
        }
    }
}
