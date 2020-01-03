package ru.kruglov.task43.printers;

import dnl.utils.text.table.TextTable;
import ru.kruglov.task43.app.Messages;
import ru.kruglov.task43.model.Book;

import java.util.ArrayList;

public class PrettyPrinter {
    protected ArrayList<Book> arrayListOfBooks;
    protected String[] tableTitleColumns = new String[]{"id","title", "author"};

    public PrettyPrinter(ArrayList<Book> arrayListOfBooks) {
        this.arrayListOfBooks = arrayListOfBooks;
    }

    public PrettyPrinter() {

    }

    private TextTable getBooksInPrettyTable(String[][] arrayOfBooks) {
        TextTable textTable = new TextTable(this.tableTitleColumns,arrayOfBooks);
        return textTable;
    }

    public void printBooks() {
        try {
            getBooksInPrettyTable(getArrayOfBooks()).printTable();
        } catch (IndexOutOfBoundsException e) {
            Messages.ARRAY_BOUNDS_EXCEPTION.printMessage();
        }
    }

    private String[][] getArrayOfBooks()  throws IndexOutOfBoundsException {
        int countOfBookFields = this.tableTitleColumns.length;
        int sizeOfArray = arrayListOfBooks.size();
        String[][] arrayOfBooks = new String[sizeOfArray][countOfBookFields];
        for (int j = 0; j < sizeOfArray; j++) {
            arrayOfBooks[j] = instanceDataExtractor(j);
        }
        return arrayOfBooks;
    }

    protected String[] instanceDataExtractor(int j) {
        return arrayListOfBooks.get(j).getInstanceDataForBookPrettyPrinter();
    }

}
