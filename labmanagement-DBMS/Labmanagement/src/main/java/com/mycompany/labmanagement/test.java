/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.labmanagement;

/**
 *
 * @author Sona
 */
import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.*;
import java.io.*;
public class test extends javax.swing.JFrame {

    /**
     * Creates new form test
     */
    int hr,min,hr1,min1;
    Timer timer;
    boolean flag=true;
    boolean ifStop=false;
    public test() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lHour = new javax.swing.JLabel();
        colon = new javax.swing.JLabel();
        lmin = new javax.swing.JLabel();
        cHour = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cMin = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        start = new javax.swing.JToggleButton();
        stop = new javax.swing.JToggleButton();
        reset = new javax.swing.JToggleButton();
        rootPane = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lHour.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lHour.setForeground(new java.awt.Color(204, 255, 204));
        lHour.setText("00");

        colon.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        colon.setForeground(new java.awt.Color(204, 255, 204));
        colon.setText(":");

        lmin.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lmin.setForeground(new java.awt.Color(204, 255, 204));
        lmin.setText("00");

        cHour.setBackground(new java.awt.Color(0, 0, 0));
        cHour.setForeground(new java.awt.Color(153, 255, 153));
        cHour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", " " }));
        cHour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cHourActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(153, 255, 153));
        jLabel4.setText("Hours:");

        cMin.setBackground(new java.awt.Color(0, 0, 0));
        cMin.setForeground(new java.awt.Color(153, 255, 153));
        cMin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        cMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cMinActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(153, 255, 153));
        jLabel5.setText("Minutes");

        start.setBackground(new java.awt.Color(153, 255, 153));
        start.setText("START");
        start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startMouseClicked(evt);
            }
        });
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        stop.setBackground(new java.awt.Color(153, 255, 153));
        stop.setText("STOP");
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        reset.setBackground(new java.awt.Color(153, 255, 153));
        reset.setText("RESET");

        rootPane.setBackground(new java.awt.Color(0, 0, 0));
        rootPane.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        rootPane.setForeground(new java.awt.Color(0, 255, 0));
        rootPane.setText("Timer");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(lHour))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(colon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lmin, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(start)
                        .addGap(27, 27, 27)
                        .addComponent(stop)
                        .addGap(42, 42, 42)
                        .addComponent(reset)))
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(rootPane, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(rootPane, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lmin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(colon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lHour, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(start)
                    .addComponent(stop)
                    .addComponent(reset))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cHourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cHourActionPerformed
        // TODO add your handling code here:
        lHour.setText(""+cHour.getSelectedItem());
        hr=Integer.parseInt(lHour.getText());
        
    }//GEN-LAST:event_cHourActionPerformed

    private void cMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cMinActionPerformed
        // TODO add your handling code here:
        lmin.setText(""+cMin.getSelectedItem());
        min=Integer.parseInt(lmin.getText());
    }//GEN-LAST:event_cMinActionPerformed

    private void startMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startMouseClicked
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_startMouseClicked

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        // TODO add your handling code here:
        timer =new Timer(5000, (ActionEvent e) -> {
            
            if(ifStop){
                min=min1;
                hr=hr1;
                ifStop=false;
            }
            if(min==0){
                min=60;
                hr--;
            }
            if(hr==0){
               lmin.setForeground(Color.red);
               lHour.setForeground(Color.red);
               colon.setForeground(Color.red);
            }
            if(hr<0){
               JOptionPane.showMessageDialog(rootPane,"TIME IS UP!!","Stopped",0);
               hr=0;min=0;
               timer.stop();
               rootPane.setForeground(Color.red);
               rootPane.setText("Time's up");
               try{
                
               
                    Thread.sleep(1000);
                for(int x=60;x>=0;x--)
                {
                        System.out.println(x);
                        Toolkit.getDefaultToolkit().beep();
                        Thread.sleep(600);
                }
                    Thread.sleep(2000);
                Toolkit.getDefaultToolkit().beep();
                   
               
            
            
        }
        catch(Exception ex) { 
            JOptionPane.showMessageDialog( null,ex.getMessage());
        }
            }
            else{
            min--;
            if(min<10){
              lmin.setText("0"+min);
              flag=false;
            }
            if(hr<1){
                lmin.setText("0"+hr);
                if(min<10)
                    lmin.setText("0"+min);
                    else
                      lmin.setText("0"+min);
                       flag=false;
                
            }
            lHour.setText(""+hr);
            lmin.setText(""+min);
            }
            
        });
        timer.start();
    }//GEN-LAST:event_startActionPerformed

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        // TODO add your handling code here:
        min1=min;
        hr1=hr;
        ifStop=true;
        timer.stop();
    }//GEN-LAST:event_stopActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cHour;
    private javax.swing.JComboBox<String> cMin;
    private javax.swing.JLabel colon;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lHour;
    private javax.swing.JLabel lmin;
    private javax.swing.JToggleButton reset;
    private javax.swing.JLabel rootPane;
    private javax.swing.JToggleButton start;
    private javax.swing.JToggleButton stop;
    // End of variables declaration//GEN-END:variables
}
