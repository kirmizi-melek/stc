package ru.kruglov.task9;

public abstract class Animal {
    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    protected abstract String getName();
}
