package ru.kruglov.task43.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryHandler {

    public static void getBooks(Connection dbConnection) throws SQLException {
        ResultSet resultSet = dbConnection.prepareStatement(
                Queries.GET_ALL_BOOKS_WITH_AUTHORS).executeQuery();
        printResult(resultSet);
        dbConnection.close();
    }

    private static void printResult(ResultSet resultSet) throws SQLException {
        String format = "|%1$-5s|%2$-10s|%3$-15s|\n";
        System.out.format(format, "id", "title", "author");
        System.out.format(format, "=====", "==========", "===============");
        while (resultSet.next())
        {
            System.out.format(format,resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3));
        }
    }
}
