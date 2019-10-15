package ru.kruglov.task15;

public enum Commands {
    HELP ("help"),
    EXIT("exit"),
    CREATE("create"),
    COPY("copy"),
    RENAME("rename"),
    DELETE("delete"),
    TRAVERSAL("traversal");

    private String text;

    Commands(String text) {
        this.text = text;
    }

    public String getMessage() {
        return text;
    }
}
