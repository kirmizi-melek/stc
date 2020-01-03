package ru.kruglov.task43.printers;

import ru.kruglov.task43.model.Book;

import java.util.ArrayList;

public class StatPrettyPrinter extends PrettyPrinter {
    private String[] tableTitleColumns = {"bookID", "bookTITLE","authorID", "authorNAME", "readerID", "readerName"};

    public StatPrettyPrinter(ArrayList<Book> arrayListOfBooks) {
        super(arrayListOfBooks);
        super.tableTitleColumns = this.tableTitleColumns;
    }

    @Override
    protected String[] instanceDataExtractor(int j) {
        return arrayListOfBooks.get(j).getInstanceDataForStatPrettyPrinter();
    }
}
