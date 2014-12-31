package ua.dp.mign.jdbc;

import java.io.Console;
import java.sql.SQLException;
import javax.sql.RowSet;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.RowSetFactory;

class DBRowSet {
    private static final String dbUrl = "jdbc:mysql://localhost:3306/addressBook";

    public static void main(String[] args) {
        try {
            Console console = System.console();
            if(console == null) {
                System.err.println("Can't get input to initialize db credentials.");
                System.exit(-1);
            }
            String login = console.readLine("Login: ");
            char[] pass = console.readPassword("Password: ");

            RowSetFactory rowSetFactory = RowSetProvider.newFactory();
            RowSet rowSet = rowSetFactory.createJdbcRowSet();
            rowSet.setUrl(dbUrl);
            rowSet.setUsername(login);
            rowSet.setPassword(new String(pass));
            rowSet.setCommand("select * from contact");
            rowSet.execute();
            System.out.println("id \tfName \tlName \temail \t\tphoneNo");
            while(rowSet.next()) {
                System.out.println(rowSet.getInt("id") + "\t"
                                 + rowSet.getString("firstName") + "\t"
                                 + rowSet.getString("lastName") + "\t"
                                 + rowSet.getString("email") + "\t"
                                 + rowSet.getString("phoneNo"));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
