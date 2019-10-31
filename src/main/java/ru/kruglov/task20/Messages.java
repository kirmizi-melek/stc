package ru.kruglov.task20;

public enum Messages {
    WELCOME ("Select action \n" +
            "Type \"help\" for getting more info."),
    HELP("Use these commands: \n" +
            "exit - for closing the application \n"
            ),
    GOODBYE("Application is  closing.\n"),
    ERROR_APP_HANDLER("Error during the handling of user input commands \n"),
    WRONG_INPUT("Wrong input parameter \n"),
    ERROR_CONVERT_STRING_TO_FLOAT("Error during conversion from String to float");

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