package ua.dp.mign.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.Console;

class Absolute {
    public static void main(String[] args) {
        try (Connection connection = DBConnect.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from contact")) {
            printRows(resultSet);
            Console console = System.console();
            if(console == null) {
                System.err.println("Can't grab console input.");
                System.exit(-1);
            }
            while(true) {
                String rowNum = console.readLine("Enter row number: ");
                if(rowNum == null) {
                    break;
                }
                try {
                    int row = Integer.parseInt(rowNum);
                    resultSet.absolute(row);
                    printRow(resultSet);
                } catch (NumberFormatException nfe) {
                    System.out.println("Please enter a valid row number.");
                }
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.exit(-1);
        }
    }

    private static void printRows(ResultSet resultSet) throws SQLException {
            System.out.println("ID \tfName \tlName \temail \t\tphoneNo");
            resultSet.beforeFirst();
            while (resultSet.next()) {
                printRow(resultSet);
            }
    } 

    private static void printRow(ResultSet resultSet) throws SQLException {
                System.out.println(resultSet.getInt("Id") + "\t"
                                 + resultSet.getString("firstName") + "\t"
                                 + resultSet.getString("lastName") + "\t"
                                 + resultSet.getString("email") + "\t"
                                 + resultSet.getString("phoneNo"));
    }
}
