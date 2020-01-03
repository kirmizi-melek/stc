package ru.kruglov.task43.printers;

import dnl.utils.text.table.TextTable;
import ru.kruglov.task43.app.Messages;
import ru.kruglov.task43.model.Book;

import java.util.ArrayList;

public class PrettyPrinter {
    protected ArrayList<Book> arrayListOfBooks;

    public PrettyPrinter(ArrayList<Book> arrayListOfBooks) {
        this.arrayListOfBooks = arrayListOfBooks;
    }

    public PrettyPrinter() {

    }

    protected TextTable getBooksInPrettyTable(String[][] arrayOfBooks) {
        TextTable textTable = new TextTable(new String[]{"id","title", "author"},arrayOfBooks);
        return textTable;
    }

    public void printBooks() {
        try {
            getBooksInPrettyTable(getArrayOfBooks()).printTable();
        } catch (IndexOutOfBoundsException e) {
            Messages.ARRAY_BOUNDS_EXCEPTION.printMessage();
        }
    }

    protected String[][] getArrayOfBooks()  throws IndexOutOfBoundsException {
        int countOfBookFields = arrayListOfBooks.get(0).getInstanceDataForBookPrettyPrinter().length;
        int sizeOfArray = arrayListOfBooks.size();
        String[][] arrayOfBooks = new String[sizeOfArray][countOfBookFields];
        for (int j = 0; j < sizeOfArray; j++) {
            arrayOfBooks[j] =  arrayListOfBooks.get(j).getInstanceDataForBookPrettyPrinter();
        }
        return arrayOfBooks;
    }

}
