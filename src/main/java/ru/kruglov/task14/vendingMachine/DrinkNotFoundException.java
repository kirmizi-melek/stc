package ru.kruglov.task14.vendingMachine;

public class DrinkNotFoundException extends Throwable {
    DrinkNotFoundException() {
        super("User selected wrong id of drink");
    }
}
