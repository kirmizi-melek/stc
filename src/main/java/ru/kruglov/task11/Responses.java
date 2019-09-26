package ru.kruglov.task11;

public enum Responses {
    HELLO("Type your text"),
    WRONG_VALUE("Wrong command. Try again \n"),
    MESSAGE(""),
    EXIT("Application is being closed"),
    RESULT("Your result: ");

    private String text;

    Responses(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}