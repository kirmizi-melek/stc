package ru.kruglov.task19;

public class ProductIsNotValidException extends Throwable {
    ProductIsNotValidException(String name, float count, float price) {
        super("Product has no valid data:" + name +"," + count + "," + price);
    }
}
