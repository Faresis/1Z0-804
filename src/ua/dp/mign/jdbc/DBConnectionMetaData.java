package ua.dp.mign.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;

class DBConnectionMetaData {
    public static void main(String[] args) {
        try (Connection connection = DBConnect.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println("DB meta data:");
            System.out.printf("Database is %s %s.%n", metaData.getDatabaseProductName(), metaData.getDatabaseProductVersion());
            System.out.printf("Driver is: %s %s.%n", metaData.getDriverName(), metaData.getDriverVersion());
            System.out.printf("URL for this connection is %s.%n", metaData.getURL());
            System.out.printf("User: %s.%n", metaData.getUserName());
            System.out.printf("Max num of rows to insert: %s.%n", metaData.getMaxRowSize());
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.exit(-1);
        }
    }
}
