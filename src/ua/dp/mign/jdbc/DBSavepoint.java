package ua.dp.mign.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

class DBSavepoint {
    public static void main(String[] args) throws SQLException {
        Connection connection = DBConnect.getConnection();
        ResultSet resultSet = null;
        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            resultSet = statement.executeQuery("select * from familyGroup");
            System.out.println("Before inserting.");
            printFamilyGroup(resultSet);

            System.out.println("Starting to insert.");
            resultSet.moveToInsertRow();
            resultSet.updateString("nickName", "Tom");
            resultSet.insertRow();
            System.out.println("Inserted row for Tom.");
            printFamilyGroup(resultSet);

            Savepoint firstSavepoint = connection.setSavepoint();

            resultSet.moveToInsertRow();
            resultSet.updateString("nickName", "Dick");
            resultSet.insertRow();
            System.out.println("Inserted row for Dick.");
            printFamilyGroup(resultSet);

            Savepoint secondSavepoint = connection.setSavepoint("SavepointForDick");

            resultSet.moveToInsertRow();
            resultSet.updateString("nickName", "Harry");
            resultSet.insertRow();
            System.out.println("Inserted row for Harry.");
            printFamilyGroup(resultSet);

            Savepoint thirdSavepoint = connection.setSavepoint("SavepointForHarry");

            System.out.println("Table update competed.");
            System.out.println("Rolling back to the state where Tom and Dick were inserted.");
            
            /* 
             * During this rollback state of the connection will be 
             * corrected while state of the resultSet will be the same
             * as before rollback.
             * So if any further usage of the resultSet is assumed it
             * should be synchronized with the DB state.
             */
            connection.rollback(secondSavepoint);
            printFamilyGroup(resultSet);

            connection.commit();
            System.out.println("After inserting.");
            printFamilyGroup(resultSet);
        } catch (SQLException e) {
            System.err.printf("Error during db update %s.%n", e.getMessage());
            connection.rollback();
            e.printStackTrace();
        } finally {
            if(connection != null) connection.close();
            if(resultSet != null) resultSet.close();
        }
    }

    private static void printFamilyGroup(ResultSet resultSet) throws SQLException {
        resultSet.beforeFirst();
        while(resultSet.next()) {
            System.out.println(resultSet.getInt("Id") + " " + resultSet.getString("nickName"));
        }
    }
}
