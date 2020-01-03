package ru.kruglov.task43.handlers;

import ru.kruglov.task43.model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookHandler {
    private ArrayList<Book> arrayListOfBooks;
    private ResultSet resultSet;

    public BookHandler(ResultSet inputResultSet) {
        this.resultSet = inputResultSet;
    }

    public ArrayList<Book> arrayListBooksMaker() {
        try {
            return this.arrayListOfBooks = makeArrayListOfBooks(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<Book> makeArrayListOfBooks(ResultSet resultSet) throws SQLException {
        ArrayList<Book> listOfBooks = new ArrayList<>();
        while (resultSet.next()) {
            Book newBook = new Book(resultSet.getInt(1),
                                    resultSet.getString(2));
            newBook.setAuthor(new Author(resultSet.getInt(4),
                                         resultSet.getString(3)));
            listOfBooks.add(newBook);
        }
        return listOfBooks;
    }

    public ArrayList<Book> arrayListStatisticMaker() {
        try {
            return this.arrayListOfBooks = makeArrayListOfStatistic(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<Book> makeArrayListOfStatistic(ResultSet resultSet) throws SQLException {
        arrayListOfBooks = new ArrayList<>();
        while (resultSet.next()) {
            Book newBook = new Book(resultSet.getInt(1),
                    resultSet.getString(2));
            newBook.setAuthor(new Author(resultSet.getInt(3),
                    resultSet.getString(4)));
            newBook.setReader(new Reader(resultSet.getInt(5),
                    resultSet.getString(6)));
            arrayListOfBooks.add(newBook);
        }
        return arrayListOfBooks;
    }
}
