package ua.dp.mign.jdbc;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

class DBDelete {
    public static void main(String[] args) {
        try (Connection connection = DBConnect.getConnection();
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery("Select * from contact")) {
            Set<String> contactNames = new HashSet<String>();
            System.out.println("Before removing duplicates:");
            System.out.println("ID \tfName \tlName \temail \t\tphoneNo");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("Id") + "\t"
                                 + resultSet.getString("firstName") + "\t"
                                 + resultSet.getString("lastName") + "\t"
                                 + resultSet.getString("email") + "\t"
                                 + resultSet.getString("phoneNo"));

                if(!contactNames.add(resultSet.getString("firstName"))) {
                    resultSet.deleteRow();
                }
            }

            System.out.println("After duplicates are removed:");
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
