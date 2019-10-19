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
            System.out.println("IOException");
            e.printStackTrace();
        }
    }

    private void list(File folder) {
        String folderPath = folder.getAbsolutePath();
        String[] listOfPaths = folder.list();
        for(int i = 0; i < listOfPaths.length; i++)
        {
            File f1 = new File(folderPath +
                    File.separator + listOfPaths[i]);

            if(f1.isFile())
                System.out.println(folderPath + File.separator + listOfPaths[i]);
            else
            {
                list(new File(folderPath + File.separator + listOfPaths[i]));
            }
        }


    }
}
