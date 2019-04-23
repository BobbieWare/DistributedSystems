package Beans;

import java.sql.*;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Bob
 */
@Stateless
public class UserBean
{

    /**
     *
     * @param username
     */
    public void addUser(String username)
    {
        try
        {
            String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
            // The dbURL to contain the Database URL
            String dbURL = "jdbc:derby://localhost:1527/SocialMediaDB;"
                    + "create=true;user=bw;password=bw";

            // Creating SQL query string
            String sqlQuery;
            int resultDB;

            // Step 1: Loading the drivers for JAVA DB
            Class.forName(driverURL);

            Connection connection = DriverManager.getConnection(dbURL);

            // Creating the SQL Statement
            Statement statement = connection.createStatement();

            // Inserting a record in the User table in the DB
            sqlQuery = "INSERT INTO STUDENT VALUES"
                    + "(" + username + "')";
            resultDB = statement.executeUpdate(sqlQuery);
        } catch (SQLException e)
        {
            System.out.println("Could not connect to db " + e.getMessage());
        } catch (ClassNotFoundException e)
        {
            System.out.println("Class not found " + e.getMessage());
        }

    }

    /**
     *
     * @return
     */
    public ArrayList<String> getUsernames()
    {
        ArrayList<String> usernames = new ArrayList<>();

        try
        {
            String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
            // The dbURL to contain the Database URL
            String dbURL = "jdbc:derby://localhost:1527/SocialMediaDB;"
                    + "create=true;user=bw;password=bw";

            // Creating SQL query string
            String sqlQuery;
            ResultSet resultDB;

            // Step 1: Loading the drivers for JAVA DB
            Class.forName(driverURL);

            Connection connection = DriverManager.getConnection(dbURL);

            // Creating the SQL Statement
            Statement statement = connection.createStatement();

            // Inserting a record in the User table in the DB
            sqlQuery = "SELECT USERNAME FROM USERS";
            resultDB = statement.executeQuery(sqlQuery);

            while (resultDB.next())
            {
                usernames.add(resultDB.getString("USERNAME"));
            }
        } catch (SQLException e)
        {
            System.out.println("Could not connect to db " + e.getMessage());
        } catch (ClassNotFoundException e)
        {
            System.out.println("Class not found " + e.getMessage());
        }
        
        if (usernames.size() == 0)
        {
            usernames.add("No one");
        }

        return usernames;
    }
}
