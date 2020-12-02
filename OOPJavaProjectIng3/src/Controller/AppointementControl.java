/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
public class AppointementControl {
    private final String URL = "jdbc:mysql://localhost:3308/medical_application";
    private String sqlStatement;
    private String researchStmt;
    private String temp;
    private int bool;

    public void checkAppointement(int IDDoctor, String hour, String date)
    {
        try
        {            
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
            
            sqlStatement = "SELECT * FROM doctorschedule WHERE IDDoctor='"+IDDoctor+"'";
            
            ResultSet result = stmt.executeQuery(sqlStatement);
            if(result.next())
            {
                int h1 = Integer.parseInt(hour);
                int begin = Integer.parseInt(result.getString("BeginTime"));
                int end = Integer.parseInt(result.getString("EndTime"));
                
                System.out.println("Begin="+begin);
                System.out.println("End="+end);
                System.out.println("Hour="+hour);
            }
            result.close();
            stmt.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void getDays(int idDoctor, ArrayList<String> days)
    {
        
    }
}
