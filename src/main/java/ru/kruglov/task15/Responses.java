package ru.kruglov.task15;

public enum Responses {
    WELCOME ("Select action \n" +
            "Type \"help\" for getting more info."),
    HELP("Use these commands: \n" +
            "create - for create new file \n" +
            "rename - for rename file \n" +
            "delete - for deleting file \n"+
            "copy - for copy file to new place\n"),
    GOODBYE("Application is  closing.\n"),
    CREATE_NEW_FILE_NAME("Enter a path of new file"),
    COPY_FROM_ORIGIN_PATH ("Enter path of file which you want to copy"),
    COPY_TO_NEW_PATH ("Enter a new destination of copied file"),
    WRONG_INPUT("Wrong input parameter\n"),
    RENAME_ORIGIN_NAME("Enter path of file, which you want to rename"),
    RENAME_NEW_NAME("Enter new name of file"),
    SUCCESSFUL_OPERATION("Operation has been successfully finished\n"),
    DELETE_FILE_NAME("Enter path of file which you want to delete"),
    UNSECCESSFUL_OPERATION("Target is not a file or not exist");

    private String text;

    Responses(String text) {
        this.text = text;
    }

    public String getMessage() {
        return text;
    }

    public void printMessage() {
        System.out.println(text);
    }
}
