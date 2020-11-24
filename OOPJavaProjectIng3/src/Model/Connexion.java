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
    private int b=1;

    public int verifConnection(String username, String password, String function)
    {
        try
        {            
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
            
            sqlStatement = "SELECT * FROM connexion WHERE Username='" +username+ "' && Password='"+password+"'";
            ResultSet result = stmt.executeQuery(sqlStatement);
            result.next();
            if(function.equals(result.getString("Function")))
            {
                id = result.getInt("Id");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return id;
    }
    
    public int registration(String username, String password, String function)
    {
        try
        {            
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
            
            sqlStatement = "INSERT INTO connexion " +
                      "(`Function`, `Username`, `Password`)" +
                      " VALUES " +
                      "('"+function+"','"+username+"','"+password+"')";
            
            researchStmt = "SELECT * FROM connexion WHERE Username='" +username+"'";
            ResultSet result = stmt.executeQuery(researchStmt);
            while(result.next() && b==1)
            {
                if(username.equals(result.getString("Username")))
                {
                    b=0;
                }
            }
            if(b==1)
            {
                int rows = stmt.executeUpdate(sqlStatement);
                System.out.println("Registration ok");
            }
            else if(b==0)
            {
                System.out.println("Username already used");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return b;
    }
}
