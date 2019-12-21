package ru.kruglov.task43.jdbc;

public class Queries {
    public static final String GET_ALL_BOOKS_WITH_AUTHORS = "SELECT b.id, a.name, b.title FROM library.\"Books\" as b JOIN library.\"Authors\" as a ON b.author_id = a.id  ORDER BY b.id;";
}
