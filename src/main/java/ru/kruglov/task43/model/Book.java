package ru.kruglov.task43.model;

public class Book {
    private int id;
    private String title;
    private int author_id;
    private int reader_id;
    private Author author;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
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

    public String[] getInstanceDataInArray() {
        String[] arrayOfInstanceData = {
                Integer.toString(this.id),
                this.getTitle(),
                this.getAuthor().getName()};
        return arrayOfInstanceData;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}
