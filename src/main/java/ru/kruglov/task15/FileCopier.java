package ru.kruglov.task15;

import java.io.*;

public class FileCopier {
    public static void fileCopier(File file, String pathOfNewFile) {
        File newFile = new File(pathOfNewFile);
        try (InputStream inputStream = new BufferedInputStream(
                new FileInputStream(file));
             OutputStream outputStream = new BufferedOutputStream(
                     new FileOutputStream(newFile))) {
            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, lengthRead);
                outputStream.flush();
            }
        } catch (IOException e) {
            ExceptionMessages.ERROR_COPY.printMessage();
            e.printStackTrace();
            System.out.println();
        }
    }
}
