package ru.kruglov.localLibs;

import java.io.*;
import java.util.Scanner;

public class FileWrite {
    private String pathToCSV;
    private String[] dataToWrite;
    private int countOfLines;

    public FileWrite(String path,
                     String[] inputData) {
        this.pathToCSV = path;
        this.dataToWrite = inputData;
        lineCounter();
    }

    private void bufferedFileWriter() {
        try(FileWriter fw = new FileWriter(pathToCSV, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {
            commaApplicator(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void commaApplicator(PrintWriter printWriter) {
        if (this.countOfLines > 0 ) {
            printWriter.print("\n");
        }
        for (String s : dataToWrite) printWriter.print(s + ",");
    }
    
    public void writeToFile() {
        bufferedFileWriter(); 
    }

    private int lineCounter() {
        this.countOfLines = 0;
        try {
            Scanner scanner = new Scanner(new File(this.pathToCSV));
            while (scanner.hasNextLine()) {
                this.countOfLines++;
                scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return this.countOfLines;
    }
}
