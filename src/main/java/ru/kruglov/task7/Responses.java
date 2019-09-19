package ru.kruglov.task7;

public enum Responses {
    WELCOME ("Welcome to vending machine user interface. \n" +
            "Type \"help\" for getting more info."),
    HELP("Help \n"),
    PRICELIST("Pricelist"),
    CURRENCY("rub."),
    GOODBYE("Application is being closing.\n"),
    CURRENT_DEPOSITE("Your deposit: "),
    SELECT_DRINK("Type number of drink"),
    NOT_ENOUPH_MONEY("You don't have enough money on deposit. Please add more."),
    TAKE_DRINK("Please, take your drink: "),
    PUT_MONEY("Please, put money in coin acceptor");

    private String text;

    Responses(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}