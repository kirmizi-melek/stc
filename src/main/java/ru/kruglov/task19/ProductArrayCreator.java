package ru.kruglov.task19;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ProductArrayCreator {

    private float convertToFloat(String string) {
        try {
            return Float.valueOf(string);
        } catch (ArithmeticException e) {
            Messages.ERROR_CONVERT_STRING_TO_FLOAT.printMessage();
        }
        return 0;
    }

    public ArrayList<Product> makeArrayOfProducts(String path, int mult) {
        ArrayList<Product> products = new ArrayList<>();
        ProductFileReader productFileReader = new ProductFileReader(path,mult);
        try {
            String[][] arrayOfData = productFileReader.arrayReturner();
            for (String[] str: arrayOfData) {
                 try {
                     //System.out.println(str[0] + " " + str[1] + " " +str[2]);
                     float count = convertToFloat(str[1]);
                     float price = convertToFloat(str[2]);
                     products.add(new Product(str[0], count, price));
                 } catch (ProductIsNotValidException e) {
                     e.printStackTrace();
                 }
            }
        } catch (RemainderOfDivisionException e) {
            e.printStackTrace();
            //TODO Handle exception
        } catch (FileNotFoundException e) {
            //TODO Handle exception
            e.printStackTrace();
        }
        return products;
    }
}
