package ru.kruglov.task43.handlers;

import dnl.utils.text.table.TextTable;
import ru.kruglov.task43.model.Author;
import ru.kruglov.task43.model.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookHandler {
    private ArrayList<Book> arrayListOfBooks;

    public BookHandler(ResultSet resultSet) {
        try {
            this.arrayListOfBooks = makeArrayListOfBooks(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private TextTable getBooksInPrettyTable(String[][] arrayOfBooks) {
        TextTable textTable = new TextTable(new String[]{"id","title", "author"},arrayOfBooks);
        return textTable;
    }

    public void printBooks() {
        getBooksInPrettyTable(getArrayOfBooks()).printTable();
    }

    private String[][] getArrayOfBooks()  {
        int countOfBookFields = arrayListOfBooks.get(0).getInstanceDataInArray().length;
        int sizeOfArray = arrayListOfBooks.size();
        String[][] arrayOfBooks = new String[sizeOfArray][countOfBookFields];
        for (int j = 0; j < sizeOfArray; j++) {
            arrayOfBooks[j] =  arrayListOfBooks.get(j).getInstanceDataInArray();
        }
        return arrayOfBooks;
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
}
