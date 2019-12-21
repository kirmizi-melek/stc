package ru.kruglov.task43.app;

import ru.kruglov.localLibs.InputDataHandle;
import ru.kruglov.task43.jdbc.DBConnector;
import ru.kruglov.task43.jdbc.Queries;
import ru.kruglov.task43.jdbc.BookPrinter;
import ru.kruglov.task43.jdbc.QueryRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
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
                        //BookPrinter.getBooks(establishConnection());
                        new BookPrinter().getBooks(
                                new QueryRunner().runQuery(
                                        establishConnection(),
                                        Queries.GET_ALL_BOOKS_WITH_AUTHORS));
                        break;
                    case GETREADER:
                        break;
                    case GETREADERBOOKS:
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

    private Connection establishConnection() {
        return this.connector.dbConnect();
    }
}
