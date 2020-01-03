package ru.kruglov.task43.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatementPreparator {
    Connection connection;

    public StatementPreparator(Connection connection) {
        this.connection = connection;
    }

    public PreparedStatement prepareGetBooksStatement()
            throws SQLException {
        String statement = Queries.GET_ALL_BOOKS_WITH_AUTHORS;
        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        return preparedStatement;
    }

    public PreparedStatement prepareGetReaderStatement(int id)
            throws SQLException {
        String statement = Queries.GET_READER_BY_ITS_ID;
        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        preparedStatement.setInt(1, id);
        return preparedStatement;
    }

    public PreparedStatement prepareGetReaderBooksStatement(int id)
            throws SQLException {
        String statement = Queries.GET_ALL_BOOKS_ASSIGNED_TO_READER;
        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        preparedStatement.setInt(1, id);
        return preparedStatement;
    }

    public PreparedStatement prepareAssignBookToReaderStatement(int bookId, int readerId)
            throws SQLException {
        String statement = Queries.ASSIGN_BOOK_TO_READER;
        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        preparedStatement.setInt(1, readerId);
        preparedStatement.setInt(2, bookId);
        return preparedStatement;
    }

    public PreparedStatement prepareUnassignBookStatement(int bookId)
            throws SQLException {
        String statement = Queries.UNASSIGN_BOOK;
        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        preparedStatement.setInt(1, bookId);
        return preparedStatement;
    }

    public PreparedStatement prepareGetAllBooksStatisticStatement()
            throws SQLException {
        return connection.prepareStatement(Queries.GET_TOTAL_STATISTIC);
    }


}
