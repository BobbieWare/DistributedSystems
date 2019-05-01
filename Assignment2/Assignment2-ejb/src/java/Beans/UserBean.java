package Beans;

import java.sql.*;
import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Bob
 */
@Stateless
@LocalBean
public class UserBean
{

    /**
     *
     * @param username
     */
    public void addUser(String username)
    {
        // Creating SQL query string
        String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
        // The dbURL to contain the Database URL
        String dbURL = "jdbc:derby://localhost:1527/SocialMediaDB;"
                + "create=true;user=bw;password=bw";
        String sqlQuery = "INSERT INTO USERS(USER_ID, USERNAME) values(?,?)";
        String countQuery = "SELECT COUNT(1) FROM USERS";
        try
        {
            int resultDB;
            ResultSet rs;
            int nextUserId;

            // Step 1: Loading the drivers for JAVA DB
            Class.forName(driverURL);

            Connection connection = DriverManager.getConnection(dbURL);

            Statement statement = connection.createStatement();

            rs = statement.executeQuery(countQuery);
            rs.next();
            nextUserId = rs.getInt("1") + 1;

            // Creating the SQL Statement
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, nextUserId + "");
            preparedStatement.setString(2, username);

            // Inserting a record in the User table in the DB;
            resultDB = preparedStatement.executeUpdate();
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
        String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
        // The dbURL to contain the Database URL
        String dbURL = "jdbc:derby://localhost:1527/SocialMediaDB;"
                + "create=true;user=bw;password=bw";
        try
        {
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

        if (usernames.isEmpty())
        {
            usernames.add("No one");
        }

        return usernames;
    }

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
            System.out.println("Could not connect to db " + e.getMessage());
        } catch (ClassNotFoundException e)
        {
            System.out.println("Class not found " + e.getMessage());
        }

        return id;
    }

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
            System.out.println("Could not connect to db " + e.getMessage());
        } catch (ClassNotFoundException e)
        {
            System.out.println("Class not found " + e.getMessage());
        }

        return username;
    }
}
