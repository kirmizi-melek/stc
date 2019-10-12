package ru.kruglov.task15;

public enum Responses {
    WELCOME ("Select action \n" +
            "Type \"help\" for getting more info."),
    HELP("Use these commands: \n" +
            "create - for create new file \n" +
            "rename - for rename file \n" +
            "delete - for deleting file \n"+
            "copy - for copy file to new place"),
    GOODBYE("Application is  closing.\n"),
    WRONG_INPUT("Wrong input parameter");

    private String text;

    Responses(String text) {
        this.text = text;
    }

    public void printMessage() {
        System.out.println(text);
    }
}
