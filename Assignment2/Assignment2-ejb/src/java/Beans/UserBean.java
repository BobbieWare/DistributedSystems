package Beans;

import java.sql.*;
import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * This EJB is used to logic for the USER table in the SQL database.
 *
 * @author Bob
 */
@Stateless
@LocalBean
public class UserBean
{

    /**
     * Adds a new username to the SQL database.
     *
     * @param username To be added to the USER table
     */
    public void addUser(String username)
    {
        // Driver
        String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
        // The url for the DB
        String dbURL = "jdbc:derby://localhost:1527/SocialMediaDB;"
                + "create=true;user=bw;password=bw";
        String sqlQuery = "INSERT INTO USERS(USER_ID, USERNAME) values(?,?)";
        String countQuery = "SELECT COUNT(1) FROM USERS";
        try
        {
            int resultDB;
            ResultSet rs;
            int nextUserId;

            // Load the drivers for JAVA DB
            Class.forName(driverURL);

            Connection connection = DriverManager.getConnection(dbURL);

            Statement statement = connection.createStatement();

            rs = statement.executeQuery(countQuery);
            rs.next();
            nextUserId = rs.getInt("1") + 1;

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, nextUserId + "");
            preparedStatement.setString(2, username);

            // Inserting a record in the User table in the DB;
            resultDB = preparedStatement.executeUpdate();
        } catch (SQLException e)
        {
            System.out.println("SQL error: " + e.getMessage());
        } catch (ClassNotFoundException e)
        {
            System.out.println("Class not found " + e.getMessage());
        }

    }

    /**
     * Creates a list of every username found within the DB.
     *
     * @return All the usernames stored in the DB
     */
    public ArrayList<String> getUsernames()
    {
        ArrayList<String> usernames = new ArrayList<>();
        String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
        // The url to the DB
        String dbURL = "jdbc:derby://localhost:1527/SocialMediaDB;"
                + "create=true;user=bw;password=bw";
        try
        {
            String sqlQuery;
            ResultSet resultDB;

            // Load the drivers for JAVA DB
            Class.forName(driverURL);

            Connection connection = DriverManager.getConnection(dbURL);

            Statement statement = connection.createStatement();

            sqlQuery = "SELECT USERNAME FROM USERS";
            resultDB = statement.executeQuery(sqlQuery);

            while (resultDB.next())
            {
                usernames.add(resultDB.getString("USERNAME"));
            }
        } catch (SQLException e)
        {
            System.out.println("SQL error: " + e.getMessage());
        } catch (ClassNotFoundException e)
        {
            System.out.println("Class not found " + e.getMessage());
        }

        if (usernames.isEmpty())
        {
            usernames.add("No one");
        }

        return usernames;
    }

    /**
     * Gets a userid from a name using SQL commands
     * @param username
     * @return a userid
     */
    public int getUserID(String username)
    {
        int id = 0;

        String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
        // The dbURL to contain the Database URL
        String dbURL = "jdbc:derby://localhost:1527/SocialMediaDB;"
                + "create=true;user=bw;password=bw";
        try
        {
            // Creating SQL query string
            String sqlQuery;
            ResultSet rs;
            // Step 1: Loading the drivers for JAVA DB
            Class.forName(driverURL);

            Connection connection = DriverManager.getConnection(dbURL);

            // Creating the SQL Statement
            Statement statement = connection.createStatement();

            // Inserting a record in the User table in the DB
            sqlQuery = "SELECT USER_ID FROM USERS WHERE USERNAME = '" + username + "'";
            rs = statement.executeQuery(sqlQuery);

            rs.next();

            id = rs.getInt("USER_ID");
        } catch (SQLException e)
        {
            System.out.println("SQL error: " + e.getMessage());
        } catch (ClassNotFoundException e)
        {
            System.out.println("Class not found " + e.getMessage());
        }

        return id;
    }

    /**
     * Gets a username from an id using SQL commands
     * @param id
     * @return username
     */
    public String getUserName(int id)
    {
        String username = "";

        String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
        // The dbURL to contain the Database URL
        String dbURL = "jdbc:derby://localhost:1527/SocialMediaDB;"
                + "create=true;user=bw;password=bw";
        try
        {
            // Creating SQL query string
            String sqlQuery;
            ResultSet rs;
            // Step 1: Loading the drivers for JAVA DB
            Class.forName(driverURL);

            Connection connection = DriverManager.getConnection(dbURL);

            // Creating the SQL Statement
            Statement statement = connection.createStatement();

            // Inserting a record in the User table in the DB
            sqlQuery = "SELECT USERNAME FROM USERS WHERE USER_ID = " + id;
            rs = statement.executeQuery(sqlQuery);

            rs.next();

            username = rs.getString("USERNAME");
        } catch (SQLException e)
        {
            System.out.println("SQL error: " + e.getMessage());
        } catch (ClassNotFoundException e)
        {
            System.out.println("Class not found " + e.getMessage());
        }

        return username;
    }
}
