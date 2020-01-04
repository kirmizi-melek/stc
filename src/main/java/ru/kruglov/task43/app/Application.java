package ru.kruglov.task43.app;

import ru.kruglov.localLibs.InputDataHandle;
import ru.kruglov.task43.jdbc.DBConnector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;

public class Application {
    protected BufferedReader buff;
    private boolean appStatus = true;
    private DBConnector connector = new DBConnector();
    protected Connection connection;

    public Application() {
        buff = new BufferedReader(new InputStreamReader(System.in));
    }

    void establishConnection() {
        this.connection = this.connector.dbConnect();
    }

    private void exitApp() throws IOException {
        Messages.GOODBYE.printMessage();
        buff.close();
        appStatus = false;
    }

    private void getHelp() {
        Messages.HELP.printMessage();
    }

    private ApplicationFunctions runAppFunction() {
        return new ApplicationFunctions();
    }

    protected ApplicationTerminal appTerminalComands() {
        return new ApplicationTerminal();
    }

    public void appController() throws IOException {
        while (appStatus) {
            Messages.WELCOME.printMessage();
            try {
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
                        runAppFunction().getBooks();
                        break;
                    case GETREADER:
                        runAppFunction().getReader();
                        break;
                    case GETREADERBOOKS:
                        runAppFunction().getReaderBooks();
                        break;
                    case ASSIGNBOOK:
                        runAppFunction().assignBookToReader();
                        break;
                    case GETSTAT:
                        runAppFunction().getStatistic();
                        break;
                    case SEARCH:
                        //TODO Implemet search by book name
                        break;
                    case UNASSIGN:
                        runAppFunction().unassignBook();
                        break;
                }
            } catch (IOException e) {
                Messages.WRONG_INPUT.printMessage();
                buff.close();
                e.printStackTrace();
                appStatus = false;
            } catch (IllegalArgumentException e) {
                Messages.WRONG_COMMAND.printMessage();
            }
        }
    }
}
