package ru.kruglov.task43.app;

import ru.kruglov.localLibs.InputDataHandle;
import ru.kruglov.task43.jdbc.DBConnector;
import ru.kruglov.task43.jdbc.Queries;
import ru.kruglov.task43.handlers.BookHandler;
import ru.kruglov.task43.jdbc.QueryRunner;
import ru.kruglov.task43.handlers.ReaderHandler;
import ru.kruglov.task43.jdbc.StatementPreparator;

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
                        new BookHandler(
                                new QueryRunner().runQuery(
                                        establishConnection(),
                                        Queries.GET_ALL_BOOKS_WITH_AUTHORS)
                        ).printReader();
                        break;
                    case GETREADER:
                        getReader();
                        break;
                    case GETREADERBOOKS:
                        getReaderBooks();
                        break;
                    case ASSIGNBOOK:
                        break;
                    case GETSTAT:
                        break;
                    case SEARCH:
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

    private void getReader() {
        try {
            ReaderHandler readerHandler = new ReaderHandler();
            Connection connection = establishConnection();
            StatementPreparator statementPreparator = new StatementPreparator(connection);
            readerHandler.printReader(
                    readerHandler.makeReader(
                            new QueryRunner().runQuery(
                                    statementPreparator.prepareGetReaderStatement(getReaderIdFromConsole()))));
            connection.close();
        } catch (SQLException e) {
            Messages.SQL_EXCEPTION.printMessage();
        }
    }

    private void getReaderBooks() {
        try {
            ReaderHandler assignedBooksReaderHandler = new ReaderHandler();
            Connection connection = establishConnection();
            StatementPreparator statementPreparator = new StatementPreparator(connection);
            PreparedStatement pStatement = statementPreparator.prepareGetReaderBooksStatement(getReaderIdFromConsole());
            assignedBooksReaderHandler.printReader(
                    assignedBooksReaderHandler.makeReader(
                            new QueryRunner().runQuery(pStatement)));
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

    private Connection establishConnection() {
        return this.connector.dbConnect();
    }
}
