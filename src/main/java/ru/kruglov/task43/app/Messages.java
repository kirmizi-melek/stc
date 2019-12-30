package ru.kruglov.task43.app;

public enum Messages {
    WELCOME ("Select action \n" +
            "Type \"help\" for getting more info."),
    HELP("Use these commands: \n" +
            "exit - for closing the application \n"
            ),
    GOODBYE("Application is  closing.\n"),
    ERROR_APP_HANDLER("Error during the handling of user input commands \n"),
    SQL_EXCEPTION("SQL exception \n"),
    TYPE_READER_ID("Type reader id"),
    TYPE_BOOK_ID("Type book id"),
    SUCCESSFUL_BOOK_ASSIGNMENT("Book was successfully assigned \n"),
    UNEXISTED_VALUE("Nothing exists by input value \n"),
    WRONG_INPUT("Wrong input parameter \n");

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