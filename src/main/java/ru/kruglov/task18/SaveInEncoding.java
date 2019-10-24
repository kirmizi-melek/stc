package ru.kruglov.task18;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class SaveInEncoding {


    public void saveToFile(String outputFile,
                           String word,
                           String charsetName) throws IOException {
        try(FileOutputStream outputStream = new FileOutputStream(outputFile)) {
            outputStream.write(word.getBytes(Charset.forName(charsetName)));
        }
    }
}
