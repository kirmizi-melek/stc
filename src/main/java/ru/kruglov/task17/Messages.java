package ru.kruglov.task17;

public enum Messages {
    WELCOME ("Select action \n" +
            "Type \"help\" for getting more info."),
    HELP("Use these commands: \n" +
            "add - for adding new book to the library \n" +
            "get - for getting list of all books in the library \n" +
            "exit - for closing the application \n"),
    GOODBYE("Application is  closing.\n"),
    ERROR_APP_HANDLER("Error during the handling of user input commands \n"),
    WRONG_INPUT("Wrong input parameter");

    private String text;

    Messages(String text) {
        this.text = text;
    }

    public String getMessage() {
        return text;
    }

    public void printMessage() {
        System.out.println(text);
    }
}