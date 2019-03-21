/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.*;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Bob
 */
@Stateless
@LocalBean
public class StudentBean implements StudentLogic
{

    public void addStudent(int id, String fName, String lName) throws SQLException, ClassNotFoundException{
       String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
        // The dbURL to contain the Database URL
        String dbURL = "jdbc:derby://localhost:1527/DMSDB;" + 
                "create=true;user=dms;password=dms2018";
        // Creating SQL query string
        String sqlQuery;
        int resultDB;
        
        // Step 1: Loading the drivers for JAVA DB
        Class.forName(driverURL);
        // Network Driver both will work with this example.
        // You can use any one of them
        //Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        // Connecting to sample Database in Java DB
        Connection connection = DriverManager.getConnection(dbURL);
        System.out.println("Database is created...");
        
        // Creating the SQL Statement
        Statement statement = connection.createStatement();
        
        // Inserting a record in the Student table in DMSDB
        sqlQuery = "INSERT INTO STUDENT VALUES" +
                "(" + id + ", '"+ fName + "', '"+ lName +"')";
        resultDB = statement.executeUpdate(sqlQuery); 
    }
    
    public ResultSet showStudents(int id) throws SQLException, ClassNotFoundException{
        String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
        // The dbURL to contain the Database URL
        String dbURL = "jdbc:derby://localhost:1527/DMSDB;" + 
                "create=true;user=dms;password=dms2018";
        // Creating SQL query string
        String sqlQuery;
        ResultSet resultSet;
        int resultDB;
        
        // Step 1: Loading the drivers for JAVA DB
        Class.forName(driverURL);
        // Network Driver both will work with this example.
        // You can use any one of them
        //Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        // Connecting to sample Database in Java DB
        Connection connection = DriverManager.getConnection(dbURL);
        System.out.println("Database is created...");
        
        // Creating the SQL Statement
        Statement statement = connection.createStatement();        
        
        sqlQuery = "Select * from STUDENT WHERE StID =" + id;
        return statement.executeQuery(sqlQuery);
    }
}
