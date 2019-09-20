package ru.kruglov.task8.Calculator;

public enum Responses {
    HELLO("Select operation");
    private String text;

    Responses(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }


}
