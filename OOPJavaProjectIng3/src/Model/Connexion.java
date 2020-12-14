/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
/*!
       \file Connexion.java
       \brief Class which tests the conncetion, register a new user or gets information about the user

       \author       Paul Ayzac, Mathieu Chaix & Thaddée Roland-Gosselin
       \version      0.1
       \date         07/12/2020
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
            result.close();
            stmt.close();
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
            result.close();
            stmt.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return b;
    }

    public void information(int id, String name, String surname, String spe, String function)
    {
        try
        {
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
            if(function=="Doctor")
            {
                sqlStatement = "INSERT INTO `doctor` (`Number`, `Name`, `Surname`, `Specification`) "
                        + "VALUES ('"+id+"','"+name+"','"+surname+"','"+spe+"');";
            }
            else if(function=="Patient")
            {
                sqlStatement = "INSERT INTO `patient` (`Number`, `Name`, `Surname`, `Pathology`) "
                        + "VALUES ('"+id+"','"+name+"','"+surname+"','"+spe+"');";
            }
            int rows = stmt.executeUpdate(sqlStatement);
            stmt.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public int getLastID()
    {
        try
        {
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
            researchStmt = "SELECT * FROM connexion ORDER BY Id DESC LIMIT 0, 1";
            ResultSet result = stmt.executeQuery(researchStmt);
            result.next();
            id=result.getInt("Id");
            System.out.println("Id: "+id);
            result.close();
            stmt.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return id;
    }
}
