package ua.dp.mign.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

class DBUpdate {
    public static void main(String[] args) {
        try (Connection connection = DBConnect.getConnection();
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery("Select * from contact")) {
            System.out.println("Before update:");
            System.out.println("ID \tfName \tlName \temail \t\tphoneNo");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("Id") + "\t"
                                 + resultSet.getString("firstName") + "\t"
                                 + resultSet.getString("lastName") + "\t"
                                 + resultSet.getString("email") + "\t"
                                 + resultSet.getString("phoneNo"));
            }
            resultSet.absolute(1);
            resultSet.updateString("phoneNo", "+919876543210");
            resultSet.updateRow();
            System.out.println("After update:");
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
