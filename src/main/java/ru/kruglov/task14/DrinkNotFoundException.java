package ru.kruglov.task14;

public class DrinkNotFoundException extends Throwable {
    DrinkNotFoundException() {
        super("User selected wrong id of drink");
    }
}
