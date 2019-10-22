package ru.kruglov.task17;

public class Book  {
    String title;
    String author;
    String year;

    private Book(String title,String author, String year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public Book() {

    }

    public String getInfo() {
        return ("Title: " + this.title + "\n" +
                "Author: " + this.author + "\n" +
                "Year: " + this.year + "\n ");
    }

    private boolean checkValues(String title,String author, String year) {
        if ((title == null) || (title.isEmpty())) {
            Messages.EMPTY_TITLE.getMessage();
            return false;
        } else if ((author == null) || (author.isEmpty())) {
            Messages.EMPTY_AUTHOR.getMessage();
            return false;
        } else if ((year == null) || (year.isEmpty())) {
            Messages.EMPTY_YEAR.getMessage();
            return false;
        } else {
            //addBook(title, author, year);
            return true;
        }
    }

    private Book addBook(String title,String author, String year) {
        if (checkValues(title, author, year)) {
            return new Book(title, author, year);
        }
        return null;
    }

    public Book addBookToLibrary(String title,String author, String year) {
        if (checkValues(title, author, year)) {
            return new Book(title, author, year);
        }
        return null;
    }

    public static Book[] createLibrary(String[][] inputData) {
        Book[] library = new Book[inputData.length];
        for (int i = 0; i < inputData.length; i++) {
            library[i] = new Book(
                    inputData[i][0],
                    inputData[i][1],
                    inputData[i][2]);
        }
        return library;
    }

    public String[] bookToString() {
        String[] stringBook = new String[3];
        stringBook[0] = this.title;
        stringBook[1] = this.author;
        stringBook[2] = this.year;
        return stringBook;
    }
}
