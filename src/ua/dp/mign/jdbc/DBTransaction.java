package ua.dp.mign.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

class DBTransaction {
    public static void main(String[] args) throws SQLException {
        Connection connection = DBConnect.getConnection();
        ResultSet resultSet1 = null, resultSet2 = null;
        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            resultSet1 = statement.executeQuery("select * from familyGroup");
            resultSet1.moveToInsertRow();
            resultSet1.updateString("nickName", "Sam Uncle");
            resultSet1.insertRow();

            System.out.println("First table updated.");

            resultSet2 = statement.executeQuery("select * from contact");
            resultSet2.moveToInsertRow();
            resultSet2.updateString("firstName", "Samuel");
            //resultSet2.updateString("firstName", "The great Samuel the billionaire from Washington DC");
            resultSet2.updateString("lastName", "Uncle");
            resultSet2.updateString("email", "uncle@gmail.com");
            resultSet2.updateString("phoneNo", "911");
            resultSet2.insertRow();
            
            System.out.println("Both tables are updated. Committing...");
            connection.commit();
        } catch (SQLException e) {
            System.err.printf("Error during db update %s.%n", e.getMessage());
            connection.rollback();
            e.printStackTrace();
        } finally {
            if(connection != null) connection.close();
            if(resultSet1 != null) resultSet1.close();
            if(resultSet2 != null) resultSet2.close();
        }
    }
}
