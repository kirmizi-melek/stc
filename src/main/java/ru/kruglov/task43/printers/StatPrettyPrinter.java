package ru.kruglov.task43.printers;

import dnl.utils.text.table.TextTable;
import ru.kruglov.task43.model.Book;

import java.util.ArrayList;

public class StatPrettyPrinter extends PrettyPrinter {

    public StatPrettyPrinter(ArrayList<Book> arrayListOfBooks) {
        super.arrayListOfBooks = arrayListOfBooks;
    }

    @Override
    protected TextTable getBooksInPrettyTable(String[][] arrayOfBooks) {
        TextTable textTable = new TextTable(
                new String[]{"bookID", "bookTITLE","authorID", "authorNAME", "readerID", "readerName"},
                arrayOfBooks);
        return textTable;
    }

//    public void printBooks() {
//        try {
//            getBooksInPrettyTable(getArrayOfBooks()).printTable();
//        } catch (IndexOutOfBoundsException e) {
//            Messages.ARRAY_BOUNDS_EXCEPTION.printMessage();
//        }
//    }
    @Override
    protected String[][] getArrayOfBooks()  throws IndexOutOfBoundsException {
        int countOfBookFields = arrayListOfBooks.get(0).getInstanceDataForStatPrettyPrinter().length;
        int sizeOfArray = super.arrayListOfBooks.size();
        String[][] arrayOfBooks = new String[sizeOfArray][countOfBookFields];
        for (int j = 0; j < sizeOfArray; j++) {
            arrayOfBooks[j] =  super.arrayListOfBooks.get(j).getInstanceDataForStatPrettyPrinter();
        }
        return arrayOfBooks;
    }
}
