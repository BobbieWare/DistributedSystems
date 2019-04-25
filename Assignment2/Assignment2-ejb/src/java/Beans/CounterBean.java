package Beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;

/**
 *
 * @author Bob
 */
@Singleton
@LocalBean
@Startup
public class CounterBean
{

    private int userCount;
    private int hitCount;
    private int postCount;
    
    @PostConstruct
    public void init()
    {
        // Creating SQL query string
        String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
        // The dbURL to contain the Database URL
        String dbURL = "jdbc:derby://localhost:1527/SocialMediaDB;"
                + "create=true;user=bw;password=bw";
        String userCountQuery = "SELECT COUNT(1) FROM USERS";
        String postCountQuery = "SELECT COUNT(1) FROM POSTs";
        try
        {
            ResultSet rs;

            // Step 1: Loading the drivers for JAVA DB
            Class.forName(driverURL);

            Connection connection = DriverManager.getConnection(dbURL);
            
            Statement statement = connection.createStatement();

            rs = statement.executeQuery(userCountQuery);
            rs.next();
            userCount = rs.getInt("1");
            
            rs = statement.executeQuery(postCountQuery);
            rs.next();
            postCount = rs.getInt("1");
        } catch (SQLException e)
        {
            System.out.println("Could not connect to db " + e.getMessage());
        } catch (ClassNotFoundException e)
        {
            System.out.println("Class not found " + e.getMessage());
        }
    }

    public int getUserCount()
    {
        return userCount;
    }

    public void incUserCount()
    {
        userCount++;
    }

    public int getPostCount()
    {
        return postCount;
    }

    public void incPostCount()
    {
        postCount++;
    }

    public int getHitCount()
    {
        return hitCount;
    }

    public void incHitCount()
    {
        hitCount++;
    }

    
}
