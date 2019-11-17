package ru.kruglov.task31;

public enum Messages {
    WELCOME ("Select action \n" +
            "Type \"help\" for getting more info."),
    HELP("Use these commands: \n" +
            "exit - for closing the application \n" +
            "revert_standart - to revert word using standard methods of the String \n" +
            "revert_doubleside - to revert word using transfer fron both sides \n"
            ),
    GOODBYE("Application is  closing.\n"),
    ERROR_APP_HANDLER("Error during the handling of user input commands \n"),
    TYPE_THE_WORD("Type any word to revert it"),
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