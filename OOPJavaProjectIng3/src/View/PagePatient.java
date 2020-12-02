/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.ArrayList;
import Model.Appointement;
import Controller.AppointementControl;
/**
 *
 * @author ayzac
 */
public class PagePatient extends javax.swing.JFrame {
    private int id;
    private int idDoctor;
    private ArrayList<Integer> listIdDoctor= new ArrayList<Integer>();
    
    public PagePatient(int i) {
        id = i;
        initComponents();
        dataUser();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    private void displayAppointement()
    {
        String [] colnames = {"Doctor", "Hour"};
        String [][] data;
    }
    
    private void dataUser()
    {
        Appointement a = new Appointement();
        namePatient.setText(a.getNamePatient(id));
        surnamePatient.setText(a.getSurnamePatient(id));
        jComboBox3.hide();
        jComboBox4.hide();
        jButton2.hide();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        namePatient = new javax.swing.JLabel();
        surnamePatient = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        pathology = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        namePatient.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 16)); // NOI18N
        namePatient.setForeground(new java.awt.Color(255, 255, 255));
        namePatient.setText("Name");

        surnamePatient.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 16)); // NOI18N
        surnamePatient.setForeground(new java.awt.Color(255, 255, 255));
        surnamePatient.setText("Surname");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General medicine", "Cardiology", "Orthopedics", "Physiotherapy", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Take a new appointement");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose your practitioner" }));
        jComboBox2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jComboBox2ComponentHidden(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton1.setText("Check the schedule");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available times" }));

        jButton2.setText("Take this appointement");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        pathology.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 16)); // NOI18N
        pathology.setForeground(new java.awt.Color(255, 255, 255));
        pathology.setText("Pathology");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select your day", " " }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(namePatient)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox4, 0, 277, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(surnamePatient)
                                        .addGap(18, 18, 18)
                                        .addComponent(pathology))
                                    .addComponent(jComboBox2, 0, 277, Short.MAX_VALUE)
                                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namePatient)
                    .addComponent(surnamePatient)
                    .addComponent(pathology))
                .addGap(49, 49, 49)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(92, 92, 92)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if("General medicine".equals(jComboBox1.getSelectedItem().toString()))
        {
            ArrayList<Integer> nameDoctor = new ArrayList<Integer>();
            Appointement a = new Appointement();
            a.getDoctor("General medicine", nameDoctor);
            jComboBox2.removeAllItems();
            for(int i=0; i<nameDoctor.size(); i++)
            {
                jComboBox2.addItem(a.getNameDoctor(nameDoctor.get(i)));
            }
            listIdDoctor = nameDoctor;
        }
        else if("Cardiology".equals(jComboBox1.getSelectedItem().toString()))
        {
            ArrayList<Integer> nameDoctor = new ArrayList<Integer>();
            Appointement a = new Appointement();
            a.getDoctor("Cardiologist", nameDoctor);
            jComboBox2.removeAllItems();
            for(int i=0; i<nameDoctor.size(); i++)
            {
                jComboBox2.addItem(a.getNameDoctor(nameDoctor.get(i)));
            }
            listIdDoctor = nameDoctor;
        }
        else if("Orthopedics".equals(jComboBox1.getSelectedItem().toString()))
        {
            ArrayList<Integer> nameDoctor = new ArrayList<Integer>();
            Appointement a = new Appointement();
            a.getDoctor("Orthopedist", nameDoctor);
            jComboBox2.removeAllItems();
            for(int i=0; i<nameDoctor.size(); i++)
            {
                jComboBox2.addItem(a.getNameDoctor(nameDoctor.get(i)));
            }
            listIdDoctor = nameDoctor;
        }
        else if("Physiotherapy".equals(jComboBox1.getSelectedItem().toString()))
        {
            ArrayList<Integer> nameDoctor = new ArrayList<Integer>();
            Appointement a = new Appointement();
            a.getDoctor("Physiotherapist", nameDoctor);
            jComboBox2.removeAllItems();
            for(int i=0; i<nameDoctor.size(); i++)
            {
                jComboBox2.addItem(a.getNameDoctor(nameDoctor.get(i)));
            }
            listIdDoctor = nameDoctor;
        }
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jComboBox2ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ComponentHidden

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jComboBox3.setVisible(true);
        jComboBox4.setVisible(true);
        jButton2.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        idDoctor = listIdDoctor.get(jComboBox2.getSelectedIndex());
        
        ArrayList<String> days = new ArrayList<String>();
        AppointementControl a = new AppointementControl();
        
        a.getDays(idDoctor, days);
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    }//GEN-LAST:event_jButton2ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel namePatient;
    private javax.swing.JLabel pathology;
    private javax.swing.JLabel surnamePatient;
    // End of variables declaration//GEN-END:variables
}
