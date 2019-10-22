package ru.kruglov.localLibs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileRead {
    private int countOfColumns;
    private int countOfLines;
    private String pathToCSV;
    private char delimiter = ',';
    private String[][] arrayOfData;

    public FileRead(String path) {
        this.pathToCSV = path;
        this.countOfLines = lineCounter();
        this.countOfColumns = commaCounter();
        if (arrayCreator()) {
            lineSplitter();
        }
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

    private int commaCounter() {
        int countOfCommas = 0;
        try {
            Scanner scanner = new Scanner(new File(this.pathToCSV));
            String firstString = scanner.nextLine();
            for(char ch: firstString.toCharArray()) {
                if (ch == this.delimiter) { countOfCommas++;}
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return countOfCommas;
    }

    private boolean arrayCreator() {
        if (countOfColumns>0 && countOfLines>0){
            this.arrayOfData = new String[this.countOfLines][this.countOfColumns];
            return true;
        } else return false;
    }

    private void lineSplitter(){
        try {
            Scanner scanner = new Scanner(new File(pathToCSV));
            scanner.useDelimiter(String.valueOf(this.delimiter));
            while (scanner.hasNext()) {
                for (int i = 0; i < countOfLines; i++) {
                    for (int j = 0; j < countOfColumns; j++) {
                        arrayOfData[i][j]= scanner.next();
                    }
                    scanner.nextLine();
                }
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
        }
    }

    public String[][] getArrayOfData() {
        return arrayOfData;
    }
}
