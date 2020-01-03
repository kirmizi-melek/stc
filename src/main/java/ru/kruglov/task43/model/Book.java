package ru.kruglov.task43.model;

public class Book {
    private int id;
    private String title;
    private Reader reader;
    private Author author;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    String getTitle() {
        return title;
    }

    Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public String[] getInstanceDataForBookPrettyPrinter() {
        return new String[] {
                Integer.toString(this.id),
                this.getTitle(),
                this.getAuthor().getName()};
    }

    public String[] getInstanceDataForStatPrettyPrinter() {
        return new String[] {
                Integer.toString(this.id),
                this.getTitle(),
                Integer.toString(this.getAuthor().getId()),
                this.getAuthor().getName(),
                Integer.toString(this.getReader().getId()),
                this.getReader().getName()};
    }

}
