package ru.kruglov.task43.jdbc;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector {
    private String url;
    private String user;
    private String password;
    private Connection connection = null;

    public DBConnector() {
        parseDbAuthSettings();
        getDriver();
        dbConnect();
    }

    public Connection dbConnect() throws NullPointerException  {
        try {
            this.connection = DriverManager.getConnection(url,user, password);
        } catch (SQLException e) {
            System.out.println("Connection to DB Error");
        }
        return this.connection;
    }

    private void getDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Class org.postgresql.Driver not found");
        }
    }

    private void parseDbAuthSettings() {
        try {
            Properties properties = new Properties();
            properties.load(new FileReader("src/main/java/ru/kruglov/temp/jdbc/jdbc.properties"));
            this.url = properties.getProperty("url");
            this.user = properties.getProperty("user");
            this.password = properties.getProperty("pass");
        } catch (IOException e) {
            System.out.println("Property file not found or not available");
        }


    }
}
