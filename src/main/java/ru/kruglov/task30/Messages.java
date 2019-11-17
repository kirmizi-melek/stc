package ru.kruglov.task30;

public enum Messages {
    WELCOME ("Select action \n" +
            "Type \"help\" for getting more info."),
    HELP("Use these commands: \n" +
            "exit - for closing the application \n" +
            "find - to type word and the first unrepeatable char in it"
            ),
    GOODBYE("Application is  closing.\n"),
    ERROR_APP_HANDLER("Error during the handling of user input commands \n"),
    TYPE_THE_WORD("Type any word"),
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