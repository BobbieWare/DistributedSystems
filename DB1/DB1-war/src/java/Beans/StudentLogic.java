/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import java.sql.*;
import javax.ejb.Remote;

/**
 *
 * @author Bob
 */
@Remote
public interface StudentLogic
{
    public void addStudent(int id, String fName, String lName) throws SQLException, ClassNotFoundException;
    public ResultSet showStudent(int id) throws SQLException, ClassNotFoundException;
}
