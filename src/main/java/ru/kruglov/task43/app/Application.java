package ru.kruglov.task43.app;

import ru.kruglov.localLibs.InputDataHandle;
import ru.kruglov.task43.printers.PrettyPrinter;
import ru.kruglov.task43.jdbc.DBConnector;
import ru.kruglov.task43.controllers.BookController;
import ru.kruglov.task43.jdbc.QueryRunner;
import ru.kruglov.task43.controllers.ReaderController;
import ru.kruglov.task43.jdbc.StatementPreparator;
import ru.kruglov.task43.printers.StatPrettyPrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Application {
    private BufferedReader buff;
    boolean appStatus = true;
    DBConnector connector = new DBConnector();

    public Application() {
        buff = new BufferedReader(new InputStreamReader(System.in));
    }

    private void exitApp() throws IOException {
        Messages.GOODBYE.printMessage();
        buff.close();
        appStatus = false;
    }

    private void getHelp() {
        Messages.HELP.printMessage();
    }

    public void appHandler() throws IOException {
        while (appStatus) {
            Messages.WELCOME.printMessage();
            try {
                establishConnection();
                String inputPhrase = InputDataHandle.getDataFromSystemIn(this.buff);
                Commands command = Commands.valueOf(inputPhrase.toUpperCase());
                switch (command) {
                    case HELP:
                        getHelp();
                        break;
                    case EXIT:
                        exitApp();
                        break;
                    case GETBOOKS:
                        getBooks();
                        break;
                    case GETREADER:
                        getReader();
                        break;
                    case GETREADERBOOKS:
                        getReaderBooks();
                        break;
                    case ASSIGNBOOK:
                        assignBookToReader();
                        break;
                    case GETSTAT:
                        getStatistic();
                        break;
                    case SEARCH:
                        break;
                    case UNASSIGN:
                        unassignBook();
                        break;
                }
            } catch (IOException e) {
                Messages.WRONG_INPUT.printMessage();
                buff.close();
                e.printStackTrace();
                appStatus = false;
            } catch (SQLException e) {
                Messages.SQL_EXCEPTION.printMessage();
            }
        }
    }

    private void unassignBook() {
        Connection connection = establishConnection();
        try {
            PreparedStatement statement = new StatementPreparator(connection)
                    .prepareUnassignBookStatement(getBookIdFromConsole());
            if (!new QueryRunner().runUpdateQuery(statement)) {
                Messages.SUCCESSFUL_BOOK_ASSIGNMENT.printMessage();
            }
        } catch (SQLException e) {
            Messages.SQL_EXCEPTION.printMessage();
        }
    }

    private void assignBookToReader() {
        try {
            Connection connection = establishConnection();
            StatementPreparator statementPreparator = new StatementPreparator(connection);
            PreparedStatement statement = statementPreparator.prepareAssignBookToReaderStatement(
                    getBookIdFromConsole(),
                    getReaderIdFromConsole());
            if (!new QueryRunner().runUpdateQuery(statement)) {
                Messages.SUCCESSFUL_BOOK_UNASSIGNMENT.printMessage();
            }
        } catch (SQLException e) {
            Messages.SQL_EXCEPTION.printMessage();
        }
    }

    private void getBooks() throws SQLException {
        try {
            Connection connection = establishConnection();
            StatementPreparator statementPreparator = new StatementPreparator(connection);
            BookController bookController = new BookController(
                    new QueryRunner().runQuery(statementPreparator.prepareGetBooksStatement()));
            new PrettyPrinter(bookController.arrayListBooksMaker()).printBooks();
        } catch (SQLException e) {
            Messages.SQL_EXCEPTION.printMessage();
        }

    }

    private void getReader() {
        try {
            ReaderController readerController = new ReaderController();
            Connection connection = establishConnection();
            StatementPreparator statementPreparator = new StatementPreparator(connection);
            readerController.printReader(
                    readerController.makeReader(
                            new QueryRunner().runQuery(
                                    statementPreparator.prepareGetReaderStatement(getReaderIdFromConsole()))));
            connection.close();
        } catch (SQLException e) {
            Messages.SQL_EXCEPTION.printMessage();
        }
    }


    private void getStatistic() {
        Connection connection = establishConnection();
        try {
            PreparedStatement pStatement = new StatementPreparator(connection)
                    .prepareGetAllBooksStatisticStatement();
            BookController bookStatHandler = new BookController(new QueryRunner().runQuery(pStatement));
            StatPrettyPrinter prettyPrinter = new StatPrettyPrinter(bookStatHandler.arrayListStatisticMaker());
            prettyPrinter.printBooks();
        } catch (SQLException e) {
            Messages.SQL_EXCEPTION.printMessage();
        }

    }

    private void getReaderBooks() {
        try {
            Connection connection = establishConnection();
            StatementPreparator statementPreparator = new StatementPreparator(connection);
            PreparedStatement pStatement = statementPreparator.prepareGetReaderBooksStatement(getReaderIdFromConsole());
            BookController assignedBooksReaderHandler = new BookController(new QueryRunner().runQuery(pStatement));
            PrettyPrinter prettyPrinter = new PrettyPrinter(assignedBooksReaderHandler.arrayListBooksMaker());
            prettyPrinter.printBooks();
        } catch (SQLException e) {
            Messages.SQL_EXCEPTION.printMessage();
        }
    }

    private int getReaderIdFromConsole() {
        Messages.TYPE_READER_ID.printMessage();
        try {
            return Integer.parseInt(InputDataHandle.getDataFromSystemIn(this.buff));
        } catch (IOException | NumberFormatException e ) {
            Messages.WRONG_INPUT.printMessage();
        }
        return 0;
    }

    private int getBookIdFromConsole() {
        Messages.TYPE_BOOK_ID.printMessage();
        try {
            return Integer.parseInt(InputDataHandle.getDataFromSystemIn(this.buff));
        } catch (IOException | NumberFormatException e ) {
            Messages.WRONG_INPUT.printMessage();
        }
        return 0;
    }

    private Connection establishConnection() {
        return this.connector.dbConnect();
    }
}
