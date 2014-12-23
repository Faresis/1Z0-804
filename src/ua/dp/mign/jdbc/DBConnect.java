package ua.dp.mign.jdbc;

import java.io.Console;
import java.sql.DriverManager;
import java.sql.Connection;

class DBConnect {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/";
        String dbName = "addressBook";
        Console console = System.console();
        if(console == null) {
            System.err.println("Can't get input to initialize db credentials.");
            System.exit(-1);
        }
        String login = console.readLine("Login: ");
        char[] pass = console.readPassword("Password: ");
        try (Connection conn = DriverManager.getConnection(dbUrl + dbName, login, new String(pass))) {
            System.out.println("Database connection: Successful.");
        } catch (Exception ex) {
            System.err.printf("Error during connection to DB: %s.%n", ex.getMessage());
            ex.printStackTrace();
            System.exit(-1);
        }
    }
}
