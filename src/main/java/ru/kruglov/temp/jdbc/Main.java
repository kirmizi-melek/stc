package ru.kruglov.temp.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("org.postgresql.Driver");
        Properties properties = new Properties();
        properties.load(new FileReader("src/main/java/ru/kruglov/temp/jdbc/jdbc.properties"));
        Connection connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("user"),
                properties.getProperty("pass"));
        Statement statement = connection.createStatement();
        PreparedStatement insertStatement = connection.prepareStatement(
                "INSERT INTO public.pets(id, name, type, age) VALUES (?,?,?,?)");
        insertStatement.setInt(1, 22);
        insertStatement.setString(2, "NEW");
        insertStatement.setInt(3, 1);
        insertStatement.setInt(4, 1);
        insertStatement.executeUpdate();
        ResultSet resultSet = statement.executeQuery("SELECT id, name, type, age\n" +
                "\tFROM public.pets;");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) +"|" +
                    resultSet.getString(2) + "|" +
                    resultSet.getInt(3));
        }
        statement.close();
        connection.close();
        }
    }
