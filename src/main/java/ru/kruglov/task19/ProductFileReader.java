package ru.kruglov.task19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProductFileReader {
    private final int multiplicity;
    private int countOfLines;
    private String pathToProductsList;
    private String[][] arrayOfData;
    private int countOfElementsOfArray;

    ProductFileReader(String path, int multiplicity) {
        this.pathToProductsList = path;
        this.multiplicity = multiplicity;
    }

    private void getCountOfArrayElements() {
        this.countOfElementsOfArray = (int)(countOfLines/multiplicity);
    }

    public String[][] arrayReturner() throws RemainderOfDivisionException, FileNotFoundException  {
        lineCounter();
        if (multiplicityDeterminer()){
            getCountOfArrayElements();
            try {
                makeArrayOfData();
                return arrayOfData;
            } catch (FileNotFoundException e) {
                throw new FileNotFoundException();
            }
        } else throw new RemainderOfDivisionException();
    }

    private void makeArrayOfData() throws FileNotFoundException {
        arrayOfData = new String[countOfElementsOfArray][multiplicity];
        Scanner scanner = new Scanner(new File(this.pathToProductsList));
        while (scanner.hasNext()) {
            for (int i = 0; i < countOfElementsOfArray; i++) {
                for (int j = 0; j < multiplicity; j++) {
                    arrayOfData[i][j] = scanner.nextLine();
                }
            }
        }
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
        return lineCounter() % multiplicity == 0;
    }
}
