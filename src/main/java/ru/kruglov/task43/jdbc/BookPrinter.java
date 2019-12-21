package ru.kruglov.task43.jdbc;

import ru.kruglov.task43.model.Author;
import ru.kruglov.task43.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class BookPrinter {

    public void getBooks(ResultSet resultSet) throws SQLException {
        //printResult(resultSet);
        LinkedList<Book> listOfBooks = makeListOfBooks(resultSet);
        String format = "|%1$-5s|%2$-10s|%3$-15s|\n";
        for (int i = 0; i < listOfBooks.size(); i++) {
            listOfBooks.get(i).getTitle();
            System.out.format(format, i,
                    listOfBooks.get(i).getTitle(),
                    listOfBooks.get(i).getAuthor().getName());
        }
    }

    private static void printResult(ResultSet resultSet) throws SQLException {
        String format = "|%1$-5s|%2$-10s|%3$-15s|\n";
        System.out.format(format, "id", "title", "author");
        System.out.format(format, "=====", "==========", "===============");
        while (resultSet.next())
        {
            System.out.format(format,resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3));
        }
    }

    private LinkedList<Book> makeListOfBooks(ResultSet resultSet) throws SQLException {
        LinkedList<Book> listOfBooks = new LinkedList<>();
        while (resultSet.next()) {
            Book newBook = new Book(resultSet.getInt(1),
                                    resultSet.getString(2));
            newBook.setAuthor(new Author(resultSet.getInt(4),
                                         resultSet.getString(3)));
            listOfBooks.add(newBook);
        }
        return listOfBooks;
    }
}
