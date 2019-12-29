package ru.kruglov.task43.jdbc;

public class Queries {
    public static final String GET_ALL_BOOKS_WITH_AUTHORS =
            "SELECT b.id, b.title, a.name, a.id FROM library.\"Books\" as b " +
            "JOIN library.\"Authors\" as a ON b.author_id = a.id  ORDER BY b.id;";
    public static final String GET_READER_BY_ITS_ID =
            "SELECT r.id, r.name FROM  library.\"Readers\" as r where id = ?  LIMIT 1";
    public static final String GET_ALL_BOOKS_ASSIGNED_TO_READER =
            "SELECT b.id, b.title, a.name \n" +
            "FROM library.\"Books\" as b \n" +
            "JOIN library.\"Authors\" as a ON b.author_id = a.id\n" +
            "JOIN library.\"Readers\" as r ON b.reader_id = r.id\n" +
            "WHERE r.id = ?";
}
