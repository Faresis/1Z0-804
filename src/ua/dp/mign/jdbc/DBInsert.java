package ua.dp.mign.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

class DBInsert {
    public static void main(String[] args) {
        try (Connection connection = DBConnect.getConnection();
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery("Select * from contact")) {
            System.out.println("Before insert:");
            System.out.println("ID \tfName \tlName \temail \t\tphoneNo");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("Id") + "\t"
                                 + resultSet.getString("firstName") + "\t"
                                 + resultSet.getString("lastName") + "\t"
                                 + resultSet.getString("email") + "\t"
                                 + resultSet.getString("phoneNo"));
            }
            resultSet.moveToInsertRow();
            resultSet.updateString("firstName", "John");
            resultSet.updateString("lastName", "K.");
            resultSet.updateString("email", "john@abc.com");
            resultSet.updateString("phoneNo", "+380634547782");
            resultSet.insertRow();
            System.out.println("After insert:");
            resultSet.beforeFirst();
            System.out.println("ID \tfName \tlName \temail \t\tphoneNo");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("Id") + "\t"
                                 + resultSet.getString("firstName") + "\t"
                                 + resultSet.getString("lastName") + "\t"
                                 + resultSet.getString("email") + "\t"
                                 + resultSet.getString("phoneNo"));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.exit(-1);
        }
    }
}
