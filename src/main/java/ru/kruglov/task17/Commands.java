package ru.kruglov.task17;

public enum Commands {
    HELP("help"),
    EXIT("exit"),
    ADD_BOOK("add"),
    GET_LIST_OF_BOOKS("get");

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