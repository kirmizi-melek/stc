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
    WRONG_INPUT("Wrong input parameter \n"),
    EMPTY_TITLE("Book title is empty \n"),
    EMPTY_AUTHOR("Author of book is empty \n"),
    EMPTY_YEAR("Year of publishing is empty \n"),
    TYPE_BOOK_TITLE("Enter title of book"),
    TYPE_BOOK_AUTHOR("Enter author of book"),
    TYPE_BOOK_YEAR("Enter year of publish"),
    BOOK_SUCCESSFULYY_ADDED("The book has been successfully added to the library \n");

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