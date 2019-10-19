package ru.kruglov.task15;

public enum CommandMessages implements MessagesInterface {
    HELP ("help"),
    EXIT("exit"),
    CREATE("create"),
    COPY("copy"),
    RENAME("rename"),
    DELETE("delete"),
    TRAVERSAL("traversal");

    private String text;

    CommandMessages(String text) {
        this.text = text;
    }

    public String getMessage() {
        return text;
    }

    @Override
    public void printMessage() {
        System.out.println(text);
    }
}
