/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
/**
 *
 * @author ayzac
 */
public class Connexion {
    private final String URL = "jdbc:mysql://localhost:3308/medical_application";
    private String sqlStatement;
    private String researchStmt;
    private int id=0;

    public int verifConnection(String username, String password)
    {
        try
        {            
            int b=0;
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
            sqlStatement = "SELECT Id FROM connexion WHERE Username='" +username+ "' && Password='"+password+"'";
            ResultSet result = stmt.executeQuery(sqlStatement);
            while(result.next() && b==0)
            {
                if(result.getString("Username")==username && result.getString("Password")==password)
                {
                    id = result.getInt("Id");
                    b=1;
                }
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return id;
    }
    
    public void registration(String username, String password)
    {
        try
        {            
            int b=0;
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
            
            sqlStatement = "INSERT INTO connexion " +
                      "(Username, Password)" +
                      " VALUES " +
                      "('"+username+"','"+password+"')";
            
            sqlStatement = "SELECT Id FROM connexion WHERE Username='" +username+"'";
            ResultSet result = stmt.executeQuery(sqlStatement);
            while(result.next() && b==0)
            {
                if(result.getString("Username") == username)
                {
                    b=1;
                }
            }
            if(b==0)
            {
                int rows = stmt.executeUpdate(sqlStatement); 
            }
            else if(b==1)
            {
                System.out.println("Username already used");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
