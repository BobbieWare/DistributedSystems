/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.ejb.LocalBean;
import java.sql.*;

/**
 *
 * @author ktj2012
 */
@LocalBean
public class StudentBean {
    
    private int id;
    private String fName;
    private String lName;
    private ResultSet resultSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }   

    void addStudent() throws SQLException, ClassNotFoundException{
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
        
        // Inserting a record in the Student table in DMSDB
        sqlQuery = "INSERT INTO STUDENT VALUES" +
                "(" + id + ", '"+ fName + "', '"+ lName +"')";
        resultDB = statement.executeUpdate(sqlQuery); 
    }
    
    void getStudentInfo(int id) throws SQLException, ClassNotFoundException{
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
        resultSet = statement.executeQuery(sqlQuery);
    }
        
}
