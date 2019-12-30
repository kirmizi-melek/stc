package ru.kruglov.task43.jdbc;

import java.sql.*;

public class QueryRunner {
    public boolean runUpdateQuery (PreparedStatement preparedStatement) throws SQLException {
        return preparedStatement.execute();
    }

    public ResultSet runQuery(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }


}
