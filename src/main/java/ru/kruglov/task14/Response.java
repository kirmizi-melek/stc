package ru.kruglov.task14;

public enum Response {
    WELCOME ("Welcome to vending machine user interface. \n" +
            "Type \"help\" for getting more info."),
    HELP("Available commands: \n" +
            "\"help\" - get help about app \n" +
            "\"menu\" - get list of drinks \n" +
            "\"deposit\" - insert money \n" +
            "\"drink\" - buy a drink \n" +
            "\"change\" - get deposit back \n" +
            "\"check\" - get deposit balance \n" +
            "\"exit\" - leave the app"),
    PRICELIST("Pricelist"),
    CURRENCY("rub."),
    GOODBYE("Application is being closing.\n"),
    CURRENT_DEPOSIT("Your deposit: "),
    SELECT_DRINK("Type number of drink"),
    NOT_ENOUPH_MONEY("You don't have enough money on deposit. Please add more."),
    TAKE_DRINK("Please, take your drink: "),
    TAKE_CHANGE("Take your change: "),
    WRONG_INPUT("Wrong input parameter"),
    WRONG_DRINK_ID("Wrong id of drink"),
    PUT_MONEY("Please, put money in coin acceptor");

    private String text;
    Response(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}