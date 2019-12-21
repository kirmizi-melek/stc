package ru.kruglov.task43.model;

public class Book {
    private int id;
    private String title;
    private int author_id;
    private int reader_id;

    public Book(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public int getReader_id() {
        return reader_id;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }
}
