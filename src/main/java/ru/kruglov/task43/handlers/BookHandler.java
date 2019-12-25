package ru.kruglov.task43.handlers;

import dnl.utils.text.table.TextTable;
import ru.kruglov.task43.model.Author;
import ru.kruglov.task43.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

public class BookHandler {

    public void getBooks(ResultSet resultSet) throws SQLException {
        ArrayList<Book> listOfBooks = makeArrayListOfBooks(resultSet);
        String format = "|%1$-5s|%2$-10s|%3$-15s|\n";
        for (int i = 0; i < listOfBooks.size(); i++) {
            listOfBooks.get(i).getTitle();
            System.out.format(format, i,
                    listOfBooks.get(i).getTitle(),
                    listOfBooks.get(i).getAuthor().getName());
        }
    }

    private TextTable getBooksInPrettyTable(String[][] arrayOfBooks) {
        TextTable textTable = new TextTable(new String[]{"id","title", "author"},arrayOfBooks);
        return textTable;
    }

    public void printReader(ResultSet resultSet) {
        try {
            getBooksInPrettyTable(getArrayOfBooks(resultSet)).printTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String[][] getArrayOfBooks(ResultSet resultSet) throws SQLException {
        ArrayList<Book> arrayListOfBooks = makeArrayListOfBooks(resultSet);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int i = 0;
        while ( i < arrayListOfBooks.size()){
            arrayList.add(arrayListOfBooks.get(i).getInstanceDataInArray());
            i++;
        }
        int sizeOfArray = arrayList.size();
        //String[][] arrayOfBooks = new String[][]

        //String[][] a = (String[][]) arrayList.toArray();

        String[][] arrayOfBooks = arrayList.toArray(new String[sizeOfArray][3]);
        return arrayOfBooks;
    }

    private ArrayList<Book> makeArrayListOfBooks(ResultSet resultSet) throws SQLException {
        //System.out.println(resultSet.getString(2));
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
