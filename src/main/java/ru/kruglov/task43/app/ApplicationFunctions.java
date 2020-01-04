package ru.kruglov.task43.app;

import ru.kruglov.task43.controllers.*;
import ru.kruglov.task43.jdbc.*;
import ru.kruglov.task43.printers.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class ApplicationFunctions extends Application{
    //Connection connection;

    ApplicationFunctions() {
        super.establishConnection();
    }

    protected void getBooks() {
        try {
            StatementPreparator statementPreparator = new StatementPreparator(super.connection);
            BookController bookController = new BookController(
                    new QueryRunner().runQuery(statementPreparator.prepareGetBooksStatement()));
            new PrettyPrinter(bookController.arrayListBooksMaker()).printBooks();
            super.connection.close();
        } catch (SQLException e) {
            Messages.SQL_EXCEPTION.printMessage();
        }
    }

    protected void getReader() {
        try {
            ReaderController readerController = new ReaderController();
            StatementPreparator statementPreparator = new StatementPreparator(super.connection);
            readerController.printReader(
                    readerController.makeReader(
                            new QueryRunner().runQuery(
                                    statementPreparator.prepareGetReaderStatement(
                                            super.appTerminalComands().getReaderIdFromConsole()))));
            super.connection.close();
        } catch (SQLException e) {
            Messages.SQL_EXCEPTION.printMessage();
        }
    }


    protected void getStatistic() {
        try {
            PreparedStatement pStatement = new StatementPreparator(super.connection)
                    .prepareGetAllBooksStatisticStatement();
            BookController bookStatHandler = new BookController(new QueryRunner().runQuery(pStatement));
            StatPrettyPrinter prettyPrinter = new StatPrettyPrinter(bookStatHandler.arrayListStatisticMaker());
            prettyPrinter.printBooks();
            super.connection.close();
        } catch (SQLException e) {
            Messages.SQL_EXCEPTION.printMessage();
        }
    }

    protected void getReaderBooks() {
        try {
            StatementPreparator statementPreparator = new StatementPreparator(connection);
            PreparedStatement pStatement = statementPreparator
                    .prepareGetReaderBooksStatement(super.appTerminalComands().getReaderIdFromConsole());
            BookController assignedBooksReaderHandler = new BookController(new QueryRunner().runQuery(pStatement));
            PrettyPrinter prettyPrinter = new PrettyPrinter(assignedBooksReaderHandler.arrayListBooksMaker());
            prettyPrinter.printBooks();
            super.connection.close();
        } catch (SQLException e) {
            Messages.SQL_EXCEPTION.printMessage();
        }
    }



    protected void unassignBook() {
        try {
            PreparedStatement statement = new StatementPreparator(super.connection)
                    .prepareUnassignBookStatement(super.appTerminalComands().getBookIdFromConsole());
            if (!new QueryRunner().runUpdateQuery(statement)) {
                Messages.SUCCESSFUL_BOOK_ASSIGNMENT.printMessage();
            }
            super.connection.close();
        } catch (SQLException e) {
            Messages.SQL_EXCEPTION.printMessage();
        }
    }

    protected void assignBookToReader() {
        try {
            StatementPreparator statementPreparator = new StatementPreparator(super.connection);
            PreparedStatement statement = statementPreparator.prepareAssignBookToReaderStatement(
                    super.appTerminalComands().getBookIdFromConsole(),
                    super.appTerminalComands().getReaderIdFromConsole());
            if (!new QueryRunner().runUpdateQuery(statement)) {
                Messages.SUCCESSFUL_BOOK_UNASSIGNMENT.printMessage();
            }
            super.connection.close();
        } catch (SQLException e) {
            Messages.SQL_EXCEPTION.printMessage();
        }
    }
}
