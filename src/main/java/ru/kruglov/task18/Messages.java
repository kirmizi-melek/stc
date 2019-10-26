package ru.kruglov.task18;

public enum Messages {
    WELCOME ("Select action \n" +
            "Type \"help\" for getting more info."),
    HELP("Use these commands: \n" +
            "exit - for closing the application \n" +
            "copy - for copying file to a new destination with selected charset "
            ),
    GOODBYE("Application is  closing.\n"),
    ERROR_APP_HANDLER("Error during the handling of user input commands \n"),
    WRONG_INPUT("Wrong input parameter \n"),
    COPY_FROM_ORIGIN_PATH ("Enter path of file which you want to copy"),
    COPY_TO_NEW_PATH ("Enter a new destination of copied file"),
    SUCCESSFUL_OPERATION("Operation has been successfully finished\n"),
    UNSECCESSFUL_OPERATION("Target is not a file or not exist"),
    UNSUPPORTED_ENCODING("Unsupported encoding. Copying was stopped."),
    COPY_FILE_CHARSET("Enter a charset for new file. \nAvailable charsets: koi8-r,  utf-8, cp866, windows-1251)");

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