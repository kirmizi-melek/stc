package ru.kruglov.task15;

import java.io.*;

public class FileAction {
    File file;

    FileAction(String path) {
        file = new File(path);
    }

    void createFile() {
        try {
            file.createNewFile();
            Responses.CREATE_FILE_SUCCESS.printMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    void renameFile(String path) {
        File tempFile = new File(path);
        file.renameTo(tempFile);
    }

    void deleteFile() {
        file.delete();
    }

    void copyFile(String path)  {
        File newFile = new File(path);
        try(InputStream inputStream = new BufferedInputStream(
                new FileInputStream(file));
            OutputStream outputStream = new BufferedOutputStream(
                new FileOutputStream(newFile))) {
            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = inputStream.read(buffer))>0) {
                outputStream.write(buffer, 0 , lengthRead);
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
