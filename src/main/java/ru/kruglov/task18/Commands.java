package ru.kruglov.task18;

public enum Commands {
    HELP("help"),
    EXIT("exit"),
    COPY("copy");

    private String text;

    Commands(String text) {
        this.text = text;
    }

    public String getMessage() {
        return text;
    }

    public void printMessage() {
        System.out.println(text);
    }
}