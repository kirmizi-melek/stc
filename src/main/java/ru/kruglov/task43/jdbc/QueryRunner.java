package ru.kruglov.task43.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryRunner {
    public ResultSet runQuery(Connection dbConnection,
                                String query) throws SQLException {
        ResultSet resultSet = dbConnection.prepareStatement(query).executeQuery();
        dbConnection.close();
        return resultSet;
    }
}
