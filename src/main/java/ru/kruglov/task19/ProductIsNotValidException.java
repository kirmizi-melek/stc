package ru.kruglov.task19;

public class ProductIsNotValidException extends Throwable {
    ProductIsNotValidException() {
        super("Product has no valid data");
    }
}
