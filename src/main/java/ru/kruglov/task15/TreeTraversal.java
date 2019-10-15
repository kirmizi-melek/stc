package ru.kruglov.task15;

import ru.kruglov.localLibs.InputDataHandle;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class TreeTraversal {
    BufferedReader buff;

    TreeTraversal(BufferedReader buff) {
        this.buff = buff;
    }

    void method() {
        try {
            Responses.TREE_TRAVERSAL.printMessage();
            String pathToFolder = InputDataHandle.getDataFromSystemIn(buff);
            File folder = new File(pathToFolder);
            if (!folder.exists()) {
                System.out.println("Folder is not exist");
            } else {
                if (folder.isFile()) {
                    System.out.println("Target is a file");
                } else {
                    list(folder);
                }
            }

        } catch (IOException e) {

        }
    }

    private void list(File folder) {

    }
}
