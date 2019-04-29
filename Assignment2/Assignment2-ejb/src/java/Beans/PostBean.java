/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Bob
 */
@Stateless
@LocalBean
public class PostBean
{

    /**
     *
     * @param title
     * @param content
     */
    public void addPost(String title, String content, String userID)
    {
        // Creating SQL query string
        String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
        // The dbURL to contain the Database URL
        String dbURL = "jdbc:derby://localhost:1527/SocialMediaDB;"
                + "create=true;user=bw;password=bw";
        String sqlQuery = "INSERT INTO USERS(POST_ID, TITLE, CONTENT, LIKED_BY, USER_ID) values(?,?,?,?,?)";
        String countQuery = "SELECT COUNT(1) FROM POSTS";
        String likedBy = "0";
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
            preparedStatement.setString(1, nextUserId+"");
            preparedStatement.setString(2, title);
            preparedStatement.setString(3, content);
            preparedStatement.setString(4, likedBy);
            preparedStatement.setString(5, userID);

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
    public ResultSet getPosts()
    {
        ResultSet postSet = null;
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
            sqlQuery = "SELECT * FROM POSTS";
            resultDB = statement.executeQuery(sqlQuery);
            
        } catch (SQLException e)
        {
            System.out.println("Could not connect to db " + e.getMessage());
        } catch (ClassNotFoundException e)
        {
            System.out.println("Class not found " + e.getMessage());
        }

        return postSet;
    }
    
    public void likePost(String postID, String userID)
    {
         // Creating SQL query string
        String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
        // The dbURL to contain the Database URL
        String dbURL = "jdbc:derby://localhost:1527/SocialMediaDB;"
                + "create=true;user=bw;password=bw";
        String sqlQuery = "UPDATE POSTS SET LIKED_BY = ";
        String getQuery = "SELECT LIKED_BY FROM POSTS WHERE POST_ID = " + postID;
        try
        {
            int resultFromQuery;
            ResultSet rs;

            // Step 1: Loading the drivers for JAVA DB
            Class.forName(driverURL);

            Connection connection = DriverManager.getConnection(dbURL);
            
            Statement statement = connection.createStatement();

            rs = statement.executeQuery(getQuery);

            rs.next();
            String likedBy = rs.getString("LIKED_BY");
            likedBy += ", " + userID;
            
            sqlQuery += "'" + likedBy + "' WHERE POST_ID = " + postID;
            resultFromQuery = statement.executeUpdate(sqlQuery);
            
        } catch (SQLException e)
        {
            System.out.println("Could not connect to db " + e.getMessage());
        } catch (ClassNotFoundException e)
        {
            System.out.println("Class not found " + e.getMessage());
        }
    }
    
    public void unlikePost(String postID, String userID)
    {
         // Creating SQL query string
        String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
        // The dbURL to contain the Database URL
        String dbURL = "jdbc:derby://localhost:1527/SocialMediaDB;"
                + "create=true;user=bw;password=bw";
        String sqlQuery = "UPDATE POSTS SET LIKED_BY = ";
        String getQuery = "SELECT LIKED_BY FROM POSTS WHERE POST_ID = " + postID;
        userID = ", " + userID;
        try
        {
            int resultFromQuery;
            ResultSet rs;

            // Step 1: Loading the drivers for JAVA DB
            Class.forName(driverURL);

            Connection connection = DriverManager.getConnection(dbURL);
            
            Statement statement = connection.createStatement();

            rs = statement.executeQuery(getQuery);

            rs.next();
            String likedBy = rs.getString("LIKED_BY");
            likedBy.replace(userID, "");
            
            sqlQuery += "'" + likedBy + "' WHERE POST_ID = " + postID;
            resultFromQuery = statement.executeUpdate(sqlQuery);
            
        } catch (SQLException e)
        {
            System.out.println("Could not connect to db " + e.getMessage());
        } catch (ClassNotFoundException e)
        {
            System.out.println("Class not found " + e.getMessage());
        }
    }
}
