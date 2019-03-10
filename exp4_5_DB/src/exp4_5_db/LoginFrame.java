/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exp4_5_db;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author sohel
 */
public class LoginFrame extends javax.swing.JFrame {

    JLabel l1, l2, l3;
    JTextField t1;
    JPasswordField t2;
    JButton b1;

    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();

        Font f = new Font("Arial", Font.BOLD, 24);

        l1 = new JLabel("Login");
        l1.setBounds(40, 40, 200, 40);
        l1.setFont(f);
        l1.setForeground(Color.BLUE);

        l2 = new JLabel("Username");
        l2.setBounds(40, 100, 200, 20);
        l2.setForeground(new Color(0, 128, 0));

        f = new Font("Arial", Font.PLAIN, 20);
        t1 = new JTextField();
        t1.setBounds(40, 120, 300, 40);
        t1.setFont(f);

        l3 = new JLabel("Password");
        l3.setBounds(40, 180, 200, 20);
        l3.setForeground(new Color(0, 128, 0));

        f = new Font("Arial", Font.PLAIN, 20);
        t2 = new JPasswordField();
        t2.setBounds(40, 200, 300, 40);
        t2.setFont(f);

        b1 = new JButton("Login");
        b1.setBounds(240, 260, 100, 40);

        add(l1);
        add(l2);
        add(t1);
        add(l3);
        add(t2);
        add(b1);

        setLayout(null);
        setVisible(true);
        setSize(400, 500);

        getContentPane().setBackground(Color.LIGHT_GRAY);

        // Starts the JFrame in the center of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                t1.setText("");
//                t2.setText("");
                try {
                    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/student", "APP", " ");

                    String q = "Select username, password from users where username='" + t1.getText() + "' and password= '" + t2.getText() + "' ";
                    PreparedStatement st = conn.prepareStatement(q);

                    ResultSet rs = st.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Login succesfully");
                        setVisible(false);
                        new Home();
                    } else {
                        JOptionPane.showMessageDialog(null, "Login failed", "Invalid Username orPassword", JOptionPane.ERROR_MESSAGE);
                    }

                    if (conn != null) {
                        System.out.println("Connection Successful!");
                    } else {
                        System.out.println("So sad.");
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
