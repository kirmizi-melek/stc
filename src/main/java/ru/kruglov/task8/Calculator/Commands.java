package ru.kruglov.task8.Calculator;

public enum Commands {
    ADDITION("addition"),
    SUBSTRACTION("substraction"),
    MULTIPLICATION("substraction"),
    DIVISION("division"),
    PERCENTAGE("percentage");

    private String text;

    Commands(String value) {
        this.text = value;
    }

    public String getText() {
        return text;
    }
}
