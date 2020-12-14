/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.ArrayList;
import Model.Appointement;
import Controller.AppointementControl;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import  java.awt.*;
import  java.awt.event.*;/**
/*!
       \file PagePatient.java
       \brief Class which extends from JFrame and implements ActionListener

       \author       Paul Ayzac, Mathieu Chaix & Thaddée Roland-Gosselin
       \version      0.1
       \date         07/12/2020
*/
public class ScheduleTest extends JFrame implements ActionListener{

    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 500;
    private JPanel panel;
    private JLabel title;
    private JButton returnTo;
    private int id;

    public ScheduleTest(String [][] tab, int s)
    {
        super("Recapitulation of your appointements");
        setLayout(new FlowLayout());
        id = s;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        panel = new JPanel();

        title = new JLabel("Your appointements");

        returnTo = new JButton("Return to edit");
        returnTo.setSize(100, 50);


        panel.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        panel.setBackground(new java.awt.Color(255, 255, 255));

        tableModel.addColumn("Doctor");
        tableModel.addColumn("Date");
        tableModel.addColumn("Time");
        tableModel.addColumn("Notes");

        for(int i=0; i<tab.length; i++)
        {
            tableModel.insertRow(tableModel.getRowCount(), tab[i]);
        }

        panel.add(title);
        panel.add(new JScrollPane(table));
        panel.add(returnTo);

        add(panel);

        returnTo.addActionListener(this);
    }
    public  void    actionPerformed(ActionEvent e)
    {
        this.hide();
        new PagePatient(id).setVisible(true);
    }
}
