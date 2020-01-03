package ru.kruglov.task43.handlers;

import ru.kruglov.task43.app.Messages;
import ru.kruglov.task43.model.Reader;
import java.sql.*;

public class ReaderHandler {

    public Reader makeReader(ResultSet resultSet) throws SQLException {
            while (resultSet.next()) {
                Reader newReader = new Reader(
                        resultSet.getInt("id"),
                        resultSet.getString("name"));
                return newReader;
            }
            return null;
    }

    public void printReader(Reader reader) {
        try {
            reader.getInstanceDataInPrettyTable().printTable();
        } catch (NullPointerException e) {
            Messages.UNEXISTED_VALUE.printMessage();
        }
    }
}
