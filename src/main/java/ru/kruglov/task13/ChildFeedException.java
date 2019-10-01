package ru.kruglov.task13;

public class ChildFeedException extends RuntimeException {
    ChildFeedException(String message) {
        super("Ребенок не хочет есть " + message);
    }
}
