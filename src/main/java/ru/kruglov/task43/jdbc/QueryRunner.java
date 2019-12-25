package ru.kruglov.task43.jdbc;

import java.sql.*;

public class QueryRunner {
    public ResultSet runQuery(Connection dbConnection,
                              String query) throws SQLException {
        ResultSet resultSet = dbConnection.prepareStatement(query).executeQuery();
        dbConnection.close();
        return resultSet;
    }

    public ResultSet runQuery(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }


}
