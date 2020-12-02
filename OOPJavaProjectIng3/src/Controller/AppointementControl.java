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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
            while(result.next())
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
    
    public void getDays(int idDoctor, ArrayList<Date> days)
    {
        Date today = new Date();
        Date day1 = new Date();
        Date day2 = new Date();
        Date day3 = new Date();
        Date day4 = new Date();
        Date day5 = new Date();
        Date day6 = new Date();
        
        SimpleDateFormat formater = null;
        formater = new SimpleDateFormat("yyyy-MM-dd");
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
    }
    
    public static Date addDaysToDate(Date date, int nbDays){
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, nbDays);
        return cal.getTime();
    }
    
    public void checkHour(int idDoctor, ArrayList<Date> returnList, int idPatient, Date app)
    {
        ArrayList<Date> list = new ArrayList<Date>();
        
        SimpleDateFormat formatter = new SimpleDateFormat("kk:mm:ss");
        
        try{
            Date date = formatter.parse("08:00:00");
            list.add(date);
            date = formatter.parse("09:00:00");
            list.add(date);
            date = formatter.parse("10:00:00"); 
            list.add(date);
            date = formatter.parse("11:00:00");
            list.add(date);
            date = formatter.parse("12:00:00");
            list.add(date);
            date = formatter.parse("13:00:00");
            list.add(date);
            date = formatter.parse("14:00:00"); 
            list.add(date);
            date = formatter.parse("15:00:00");
            list.add(date);
            date = formatter.parse("16:00:00"); 
            list.add(date);
            date = formatter.parse("17:00:00");
            list.add(date);
            date = formatter.parse("18:00:00");
            list.add(date);
            date = formatter.parse("19:00:00");
            list.add(date);
            date = formatter.parse("20:00:00");
            list.add(date);
            
            Connection co = DriverManager.getConnection(URL, "root", "paul1234");
            Statement stmt = co.createStatement();
            
            sqlStatement = "SELECT * FROM doctorschedule WHERE IDDoctor='"+idDoctor+"'";
            
            ResultSet result = stmt.executeQuery(sqlStatement);
            result.next();
            Date begin = formatter.parse(result.getString("BeginTime"));
            Date end = formatter.parse(result.getString("EndTime"));
            
            for(int i=0; i<list.size(); i++)
            {
                if(list.get(i).compareTo(begin)==0 || list.get(i).compareTo(begin)>0)
                {
                    if(list.get(i).compareTo(end)==0 || list.get(i).compareTo(end)<0)
                    {
                        returnList.add(list.get(i));
                    }
                }
            }
            result.close();
            
            sqlStatement = "SELECT * FROM appointement WHERE IDDoctor='"+idDoctor+"' && IDPatient='"+idPatient+"'";
            result = stmt.executeQuery(sqlStatement);
            Date time = new Date();
            Date d = new Date();
            while(result.next())
            {
                for(int i=0; i<returnList.size(); i++)
                {
                    formatter = new SimpleDateFormat("kk:mm:ss");
                    time = formatter.parse(result.getString("Time"));
                    
                    formatter = new SimpleDateFormat("yyyy-MM-dd");
                    d = formatter.parse(result.getString("Date"));
                    
                            
                    if(returnList.get(i).compareTo(time)==0 && d.compareTo(app)==0)
                    {
                        returnList.remove(i);
                    }
                }
            }
            
            
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }  
    }
}
