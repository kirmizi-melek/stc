package ru.kruglov.task15;

public enum ExceptionMessages implements MessagesInterface {
    ERROR_COPY("Error during copying file"),
    ERROR_RUN_APPLICATION("Error during starting the application"),
    ERROR_TREE_TRAVERSAL("Error during the recursive traversal of directories"),
    ERROR_APP_HANDLER("Error during the handling of user input commands");

    private String text;

    ExceptionMessages(String text) {
        this.text = text;
    }

    public String getMessage() {
        return text;
    }

    public void printMessage() {
        System.out.println(text);
    }
}
