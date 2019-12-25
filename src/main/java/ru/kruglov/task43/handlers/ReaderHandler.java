package ru.kruglov.task43.handlers;

import ru.kruglov.task43.jdbc.Queries;
import ru.kruglov.task43.model.Reader;
import java.sql.*;

public class ReaderHandler {
    public PreparedStatement statementPreparator(Connection connection,int id) throws SQLException {
        String statement = Queries.GET_READER_BY_ITS_ID;
        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        preparedStatement.setInt(1, id);
        return preparedStatement;
    }

    public Reader makeReader(ResultSet resultSet) throws SQLException {
            while (resultSet.next()) {
                Reader newReader = new Reader(resultSet.getInt("id"));
                newReader.setName(resultSet.getString("name"));
                return newReader;
            }
            return null;
    }

    public void printReader(Reader reader) {
        reader.getInstanceDataInPrettyTable().printTable();
    }
}
