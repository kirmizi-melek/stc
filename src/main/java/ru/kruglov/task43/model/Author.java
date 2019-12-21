package ru.kruglov.task43.model;

public class Author {
    private int id;
    private String name;

    public Author(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
