package ru.kruglov.task43.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatementPreparator {
    Connection connection;

    public StatementPreparator(Connection connection) {
        this.connection = connection;
    }

    public PreparedStatement prepareGetReaderStatement(int id)
            throws SQLException {
        String statement = Queries.GET_READER_BY_ITS_ID;
        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        preparedStatement.setInt(1, id);
        return preparedStatement;
    }
}
