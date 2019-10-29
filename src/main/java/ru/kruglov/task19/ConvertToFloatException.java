package ru.kruglov.task19;

public class ConvertToFloatException extends Throwable{
    ConvertToFloatException() {
        super("Error during conversion from String to float");
    }
}
