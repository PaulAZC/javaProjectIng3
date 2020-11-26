/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ayzac
 */
public class Appointement {
    private final String URL = "jdbc:mysql://localhost:3308/medical_application";
    private String sqlStatement;
    private String researchStmt;
    private String temp;

    public void getDoctor(String spe, ArrayList array)
    {
        try
        {            
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
            
            sqlStatement = "SELECT * FROM doctor WHERE Specification='"+spe+"'";
            ResultSet result = stmt.executeQuery(sqlStatement);
            while(result.next())
            {
                array.add(result.getInt("Number"));
            }
            result.close();
            stmt.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public String getNameDoctor(int id)
    {
        try
        {            
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
            
            sqlStatement = "SELECT * FROM doctor WHERE Number='"+id+"'";
            ResultSet result = stmt.executeQuery(sqlStatement);
            result.next();
            temp = "Dr."+result.getString("Surname");
            result.close();
            stmt.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return temp;
    }
    
    public String getNamePatient(int id)
    {
        try
        {            
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
            
            sqlStatement = "SELECT * FROM patient WHERE Number='"+id+"'";
            ResultSet result = stmt.executeQuery(sqlStatement);
            result.next();
            temp = result.getString("Name");
            result.close();
            stmt.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return temp;
    }
    
    public String getSurnamePatient(int id)
    {
        try
        {            
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
            
            sqlStatement = "SELECT * FROM patient WHERE Number='"+id+"'";
            ResultSet result = stmt.executeQuery(sqlStatement);
            result.next();
            temp = result.getString("Surname");
            result.close();
            stmt.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return temp;
    }
    
    public String getPathologyPatient(int id)
    {
        try
        {            
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
            
            sqlStatement = "SELECT * FROM patient WHERE Number='"+id+"'";
            ResultSet result = stmt.executeQuery(sqlStatement);
            result.next();
            temp = result.getString("Pathology");
            result.close();
            stmt.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return temp;
    }
}
