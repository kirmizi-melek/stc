package ru.kruglov.task7;

public enum Responses {
    WELCOME ("Welcome to vending machine user interface. \n" +
            "Type \"help\" for getting more info."),
    HELP("Help \n"),
    PRICELIST("Pricelist"),
    CURRENCY("rub."),
    GOODBYE("Application is being closing.\n"),
    PUT_MONEY("Please put money in coin acceptor");

    private String text;

    Responses(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}