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
import java.util.Locale;
import javax.swing.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import Controller.AppointementControl;
import static Controller.AppointementControl.addDaysToDate;
import java.text.SimpleDateFormat;

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
    
    public void getDateDoctor(ArrayList<String> list, int id)
    {
        try
        {            
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
            
            sqlStatement = "SELECT * FROM appointement WHERE IDDoctor='"+id+"' ORDER BY Date DESC";
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
    
    public void getHourDoctor(ArrayList<String> list, int id, String date)
    {
        try
        {            
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
            
            sqlStatement = "SELECT * FROM appointement WHERE IDDoctor='"+id+"' && Date='"+date+"' ORDER BY Date DESC";
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
    
    public void removeApp(String date, String time, int idDoctor)
    {
        try
        {            
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
                        
            sqlStatement = "DELETE FROM appointement WHERE Date='"+date+"' && Time='"+time+"' && IDDoctor='"+idDoctor+"'";
            int rows = stmt.executeUpdate(sqlStatement);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void removeAppPatient(String date, String time, int idPatient)
    {
        try
        {            
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
                        
            sqlStatement = "DELETE FROM appointement WHERE Date='"+date+"' && Time='"+time+"' && IDPatient='"+idPatient+"'";
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
            a.checkHour(idDoctor, list, dateChoice);
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
    
    public void modifAppDoctor(String actualDate, String actualTime, String newDate, String newTime, int idDoctor)
    {
        try
        {            
            int idPatient;
            String notes;
            
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
            
            sqlStatement = "SELECT * FROM appointement WHERE Date='"+actualDate+"' && Time='"+actualTime+"' && IDDoctor='"+idDoctor+"'";
            ResultSet result = stmt.executeQuery(sqlStatement);
            result.next();
            idPatient=result.getInt("IDPatient");
            notes=result.getString("Note");
            result.close();
            
            sqlStatement = "DELETE FROM appointement WHERE DATE='"+actualDate+"' && Time='"+actualTime+"' && IDDoctor='"+idDoctor+"'";
            int rows = stmt.executeUpdate(sqlStatement);
            
            Appointement a = new Appointement();
            a.addAppointement(idDoctor, idPatient, newDate, newTime, notes);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void scheduleValuesDoctor(ArrayList<String> infoPatient, int id)
    {
        try
        {                
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
                        
            sqlStatement = "SELECT * FROM appointement WHERE IDDoctor='"+id+"'";
            ResultSet result = stmt.executeQuery(sqlStatement);
            while(result.next())
            {
                String temp = getNamePatient(result.getInt("IDPatient"))+" "+getSurnamePatient(result.getInt("IDPatient"))+" "+result.getString("Note");
                infoPatient.add(temp);
            }
            result.close();
     
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void getCoordSchedule(JTable table, int id, ArrayList<String> hours, ArrayList<String> infoPatient)
    {
            Date today = new Date();    
            Date day1 = new Date();
            Date day2 = new Date();
            Date day3 = new Date();
            Date day4 = new Date();
            Date day5 = new Date();
            Date day6 = new Date();
            
            ArrayList<Date> days = new ArrayList<Date>();
            ArrayList<Date> tempD = new ArrayList<Date>();
            
            SimpleDateFormat formater = null;
            formater=new SimpleDateFormat("yyyy-MM-dd");
            
            formater.format(today);
       
            day1 = addDaysToDate(today, 1);
            formater.format(day1);

            day2 = addDaysToDate(today, 2);
            formater.format(day2);

            day3 = addDaysToDate(today, 3);
            formater.format(day3);

            day4 = addDaysToDate(today, 4);
            formater.format(day4);

            day5 = addDaysToDate(today, 5);
            formater.format(day5);

            day6 = addDaysToDate(today, 6);
            formater.format(day6);
            
            days.add(today);
            days.add(day1);
            days.add(day2);
            days.add(day3);
            days.add(day4);
            days.add(day5);
            days.add(day6);
            
            formater = new SimpleDateFormat("EEEEEEEE");
            formater.format(today);

            day1 = addDaysToDate(today, 1);
            formater.format(day1);

            day2 = addDaysToDate(today, 2);
            formater.format(day2);

            day3 = addDaysToDate(today, 3);
            formater.format(day3);

            day4 = addDaysToDate(today, 4);
            formater.format(day4);

            day5 = addDaysToDate(today, 5);
            formater.format(day5);

            day6 = addDaysToDate(today, 6);
            formater.format(day6);

            tempD.add(today);
            tempD.add(day1);
            tempD.add(day2);
            tempD.add(day3);
            tempD.add(day4);
            tempD.add(day5);
            tempD.add(day6);
            
        try
        {                
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
            int[] tempInt = new int[2];
            int s=0;
            ArrayList<int []> t = new ArrayList<int []>();
            sqlStatement = "SELECT * FROM appointement WHERE IDDoctor='"+id+"'";
            ResultSet result = stmt.executeQuery(sqlStatement);
            
            while(result.next())
            {
               for(int i=0; i<days.size(); i++)
               {
                   formater = new SimpleDateFormat("yyyy-MM-dd");
                   String d = formater.format(days.get(i));
                   
                   if(result.getString("Date").equals(d))
                   {
                       formater = new SimpleDateFormat("EEEEEEEE");
                       
                       if("lundi".equals(formater.format(tempD.get(i))))
                       {
                           for(int j=0; j<hours.size(); j++)
                           {
                               if(result.getString("Time").equals(hours.get(j)))
                               {
                                   tempInt[0]=j;
                               }
                           }
                           tempInt[1]=1;
                       }
                       if("mardi".equals(formater.format(tempD.get(i))))
                       {
                           for(int j=0; j<hours.size(); j++)
                           {
                               if(result.getString("Time").equals(hours.get(j)))
                               {
                                   tempInt[0]=j;
                               }
                           }
                           tempInt[1]=2;
                       }
                       if("mercredi".equals(formater.format(tempD.get(i))))
                       {
                           for(int j=0; j<hours.size(); j++)
                           {
                               if(result.getString("Time").equals(hours.get(j)))
                               {
                                   tempInt[0]=j;
                               }
                           }
                           tempInt[1]=3;
                       }
                       if("jeudi".equals(formater.format(tempD.get(i))))
                       {
                           for(int j=0; j<hours.size(); j++)
                           {
                               if(result.getString("Time").equals(hours.get(j)))
                               {
                                   tempInt[0]=j;
                               }
                           }
                           tempInt[1]=4;
                       }
                       if("vendredi".equals(formater.format(tempD.get(i))))
                       {
                           for(int j=0; j<hours.size(); j++)
                           {
                               if(result.getString("Time").equals(hours.get(j)))
                               {
                                   tempInt[0]=j;
                               }
                           }
                           tempInt[1]=5;
                       }
                       if("samedi".equals(formater.format(tempD.get(i))))
                       {
                           for(int j=0; j<hours.size(); j++)
                           {
                               if(result.getString("Time").equals(hours.get(j)))
                               {
                                   tempInt[0]=j;
                               }
                           }
                           tempInt[1]=6;
                       }
                       if("dimanche".equals(formater.format(tempD.get(i))))
                       {
                           for(int j=0; j<hours.size(); j++)
                           {
                               if(result.getString("Time").equals(hours.get(j)))
                               {
                                   tempInt[0]=j;
                               }
                           }
                           tempInt[1]=7;
                       }
                   }
                   
               }
               if(tempInt[1]!=0)
               {
                    table.setValueAt(infoPatient.get(s), tempInt[0], tempInt[1]);
                    s++;
               }
            }
            result.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
