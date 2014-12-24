package ua.dp.mign.jdbc;

import java.io.Console;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

class DBConnect {
    private static final String dbUrl = "jdbc:mysql://localhost:3306/";
    private static final String dbName = "addressBook";

    public static Connection getConnection() throws SQLException {
        Console console = System.console();
        if(console == null) {
            System.err.println("Can't get input to initialize db credentials.");
            System.exit(-1);
        }
        String login = console.readLine("Login: ");
        char[] pass = console.readPassword("Password: ");
        return DriverManager.getConnection(dbUrl + dbName, login, new String(pass));
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            System.out.println("Database connection: Successful.");
        } catch (Exception ex) {
            System.err.printf("Error during connection to DB: %s.%n", ex.getMessage());
            ex.printStackTrace();
            System.exit(-1);
        }
    }
}
