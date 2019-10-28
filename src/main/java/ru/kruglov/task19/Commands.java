package ru.kruglov.task19;

public enum Commands {
    HELP("help"),
    EXIT("exit"),
    CHEQUE("cheque");

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