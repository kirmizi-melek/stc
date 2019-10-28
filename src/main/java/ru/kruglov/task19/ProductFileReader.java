package ru.kruglov.task19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProductFileReader {
    private final int multiplicity;
    private int countOfLines;
    private String pathToProductsList;

    ProductFileReader(String path, int multiplicity) {
        this.pathToProductsList = path;
        this.multiplicity = multiplicity;
    }

    public void func() {

    }

    private int lineCounter() {
        this.countOfLines = 0;
        try {
            Scanner scanner = new Scanner(new File(this.pathToProductsList));
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

    private boolean multiplicityDeterminer() {
        if (lineCounter()%multiplicity == 0) {return true;
        } else
            return false;
    }
}
