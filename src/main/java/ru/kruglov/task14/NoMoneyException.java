package ru.kruglov.task14;

public class NoMoneyException extends Throwable {

    public NoMoneyException() {
        super("User tried to order drink having not enough money");
    }
}
