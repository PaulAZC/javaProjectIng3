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
import java.util.Date;
import Controller.AppointementControl;

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
    
    public void appointementInformation(int id, int monday, int tuesday,  int wednesday, int thursday, int friday, int saturday, int sunday, String beginDate, String endDate)
    {
        try
        {            
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();

            researchStmt = "SELECT * FROM `doctorschedule` WHERE IDDoctor="+id;
            ResultSet result = stmt.executeQuery(researchStmt);
            
            if(result.next())
            {
                sqlStatement = "UPDATE `doctorschedule` " +
                                "SET Monday='"+monday+"', Tuesday='"+tuesday+"', Wednesday='"+wednesday+"', Thursday='"+thursday+"', Friday='"+friday+"', Saturday='"+saturday+"', Sunday='"+sunday+"', "
                                + "BeginTime='"+beginDate+"', EndTime='"+endDate+"'"+
                                "WHERE IDDoctor="+id+";";
            }
            else{
                sqlStatement = "INSERT INTO `doctorschedule` (`IDDoctor`, `Monday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`, `Saturday`, `Sunday`, `BeginTime`, `EndTime`)"+
                                "VALUES ('"+id+"', '"+monday+"', '"+tuesday+"', '"+wednesday+"', '"+thursday+"', '"+friday+"', '"+saturday+"', '"+sunday+"',"
                                + " '"+beginDate+"', '"+endDate+"')";
            }
            int rows = stmt.executeUpdate(sqlStatement);
            System.out.println("Informations ok");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void addAppointement(int idDoctor, int idPatient, String date, String time, String note)
    {
        try
        {            
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();

            sqlStatement = "INSERT INTO appointement " +
                      "(`IDPatient`, `IDDoctor`, `Date`, `Time`, `Note`)" +
                      " VALUES " +
                      "('"+idPatient+"','"+idDoctor+"','"+date+"','"+time+"','"+note+"')";
            
            int rows = stmt.executeUpdate(sqlStatement);
            System.out.println("Appointement ok");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void getDatePatient(ArrayList<String> list, int id)
    {
        try
        {            
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
            
            sqlStatement = "SELECT * FROM appointement WHERE IDPatient='"+id+"' ORDER BY Date DESC";
            ResultSet result = stmt.executeQuery(sqlStatement);
            
            while(result.next())
            {
                list.add(result.getString("Date"));
            }
            
            result.close();
            stmt.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void getHourPatient(ArrayList<String> list, int id, String date)
    {
        try
        {            
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
            
            sqlStatement = "SELECT * FROM appointement WHERE IDPatient='"+id+"' && Date='"+date+"' ORDER BY Date DESC";
            ResultSet result = stmt.executeQuery(sqlStatement);
            
            while(result.next())
            {
                list.add(result.getString("Time"));
            }
            
            result.close();
            stmt.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void removeApp(String date, String time)
    {
        try
        {            
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
                        
            sqlStatement = "DELETE FROM appointement WHERE Date='"+date+"' && Time='"+time+"'";
            int rows = stmt.executeUpdate(sqlStatement);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void getListDateDoctor(String date, String time, int idPatient, ArrayList<Date> list)
    {
        try
        {            
            int idDoctor;
            
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
                        
            sqlStatement = "SELECT * FROM appointement WHERE Date='"+date+"' && Time='"+time+"' && IDPatient='"+idPatient+"'";
            ResultSet result = stmt.executeQuery(sqlStatement);
            result.next();
            idDoctor=result.getInt("IDDoctor");
            result.close();
            
            AppointementControl a = new AppointementControl();
            a.getDays(idDoctor, list);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void getListHourDoctor(String date, String time, int idPatient, ArrayList<Date> list, Date dateChoice)
    {
        try
        {            
            int idDoctor;
            
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
                        
            sqlStatement = "SELECT * FROM appointement WHERE Date='"+date+"' && Time='"+time+"' && IDPatient='"+idPatient+"'";
            ResultSet result = stmt.executeQuery(sqlStatement);
            result.next();
            idDoctor=result.getInt("IDDoctor");
            result.close();
            
            AppointementControl a = new AppointementControl();
            a.checkHour(idDoctor, list, idPatient, dateChoice);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void modifApp(String actualDate, String actualTime, String newDate, String newTime, int idPatient)
    {
        try
        {            
            int idDoctor;
            String notes;
            
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
            
            sqlStatement = "SELECT * FROM appointement WHERE Date='"+actualDate+"' && Time='"+actualTime+"' && IDPatient='"+idPatient+"'";
            ResultSet result = stmt.executeQuery(sqlStatement);
            result.next();
            idDoctor=result.getInt("IDDoctor");
            notes=result.getString("Note");
            result.close();
            
            sqlStatement = "DELETE FROM appointement WHERE DATE='"+actualDate+"' && Time='"+actualTime+"' && IDPatient='"+idPatient+"'";
            int rows = stmt.executeUpdate(sqlStatement);
            
            Appointement a = new Appointement();
            a.addAppointement(idDoctor, idPatient, newDate, newTime, notes);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
