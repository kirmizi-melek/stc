package ru.kruglov.task14.vendingMachine;

public class NoMoneyException extends Throwable {

    public NoMoneyException() {
        super("User tried to order drink having not enough money");
    }
}
