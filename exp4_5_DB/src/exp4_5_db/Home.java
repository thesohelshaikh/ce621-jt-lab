/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exp4_5_db;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.*;

/**
 *
 * @author sohel
 */
public class Home {

    JFrame frame;
    JLabel l1, l2, l3;
    JLabel l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19;
    JTextField t1, t3, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14;
    JPasswordField t2, t4;
    JButton createButton, deleteButton, addButton, updateButton, displayButton;

    public Home() {
        frame = new JFrame("Home");
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JTabbedPane tp = new JTabbedPane();

        tp.setBounds(50, 50, 575, 550);
        tp.add("Create", p1);
        tp.add("Delete", p2);
        tp.add("Add Details", p3);
        tp.add("Update Details", p4);
        tp.add("Display Details", p5);

        Font f = new Font("Arial", Font.BOLD, 24);

        l1 = new JLabel("Create user");
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

        createButton = new JButton("Create");
        createButton.setBounds(240, 260, 100, 30);

        p1.add(l1);
        p1.add(l2);
        p1.add(t1);
        p1.add(l3);
        p1.add(t2);
        p1.add(createButton);

        p1.setLayout(null);

        f = new Font("Arial", Font.BOLD, 24);

        l4 = new JLabel("Delete user");
        l4.setBounds(40, 40, 200, 40);
        l4.setFont(f);
        l4.setForeground(Color.BLUE);

        l5 = new JLabel("Username");
        l5.setBounds(40, 100, 200, 20);
        l5.setForeground(new Color(0, 128, 0));

        f = new Font("Arial", Font.PLAIN, 20);
        t3 = new JTextField();
        t3.setBounds(40, 120, 300, 40);
        t3.setFont(f);

        l6 = new JLabel("Password");
        l6.setBounds(40, 180, 200, 20);
        l6.setForeground(new Color(0, 128, 0));

        f = new Font("Arial", Font.PLAIN, 20);
        t4 = new JPasswordField();
        t4.setBounds(40, 200, 300, 40);
        t4.setFont(f);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(240, 260, 100, 30);

        p2.add(l4);
        p2.add(l5);
        p2.add(t3);
        p2.add(l6);
        p2.add(t4);
        p2.add(deleteButton);

        p2.setLayout(null);

        f = new Font("Arial", Font.BOLD, 24);

        l7 = new JLabel("Add details");
        l7.setBounds(40, 40, 200, 40);
        l7.setFont(f);
        l7.setForeground(Color.BLUE);

        // User name
        l8 = new JLabel("User name");
        l8.setBounds(40, 100, 200, 20);
        l8.setForeground(new Color(0, 128, 0));

        f = new Font("Arial", Font.PLAIN, 20);
        t5 = new JTextField();
        t5.setBounds(40, 120, 300, 40);
        t5.setFont(f);

        // First name
        l9 = new JLabel("First name");
        l9.setBounds(40, 180, 200, 20);
        l9.setForeground(new Color(0, 128, 0));

        f = new Font("Arial", Font.PLAIN, 20);
        t6 = new JTextField();
        t6.setBounds(40, 200, 300, 40);
        t6.setFont(f);

        // Last name
        l10 = new JLabel("Last name");
        l10.setBounds(40, 260, 200, 20);
        l10.setForeground(new Color(0, 128, 0));

        f = new Font("Arial", Font.PLAIN, 20);
        t7 = new JTextField();
        t7.setBounds(40, 280, 300, 40);
        t7.setFont(f);

        // Email
        l11 = new JLabel("Email");
        l11.setBounds(40, 340, 200, 20);
        l11.setForeground(new Color(0, 128, 0));

        f = new Font("Arial", Font.PLAIN, 20);
        t8 = new JTextField();
        t8.setBounds(40, 360, 300, 40);
        t8.setFont(f);

        // Number
        l12 = new JLabel("Number");
        l12.setBounds(40, 400, 200, 20);
        l12.setForeground(new Color(0, 128, 0));

        f = new Font("Arial", Font.PLAIN, 20);
        t9 = new JTextField();
        t9.setBounds(40, 420, 300, 40);
        t9.setFont(f);

        addButton = new JButton("Add");
        addButton.setBounds(240, 480, 100, 30);

        p3.add(l7);
        p3.add(l8);
        p3.add(l9);
        p3.add(l10);
        p3.add(l11);
        p3.add(l12);
        p3.add(t5);
        p3.add(t6);
        p3.add(t7);
        p3.add(t8);
        p3.add(t9);
        p3.add(addButton);

        p3.setLayout(null);

        f = new Font("Arial", Font.BOLD, 24);

        l13 = new JLabel("Update details");
        l13.setBounds(40, 40, 200, 40);
        l13.setFont(f);
        l13.setForeground(Color.BLUE);

        // User name
        l14 = new JLabel("User name");
        l14.setBounds(40, 100, 200, 20);
        l14.setForeground(new Color(0, 128, 0));

        f = new Font("Arial", Font.PLAIN, 20);
        t10 = new JTextField();
        t10.setBounds(40, 120, 300, 40);
        t10.setFont(f);

        // First name
        l15 = new JLabel("First name");
        l15.setBounds(40, 180, 200, 20);
        l15.setForeground(new Color(0, 128, 0));

        f = new Font("Arial", Font.PLAIN, 20);
        t11 = new JTextField();
        t11.setBounds(40, 200, 300, 40);
        t11.setFont(f);

        // Last name
        l16 = new JLabel("Last name");
        l16.setBounds(40, 260, 200, 20);
        l16.setForeground(new Color(0, 128, 0));

        f = new Font("Arial", Font.PLAIN, 20);
        t12 = new JTextField();
        t12.setBounds(40, 280, 300, 40);
        t12.setFont(f);

        // Email
        l17 = new JLabel("Email");
        l17.setBounds(40, 340, 200, 20);
        l17.setForeground(new Color(0, 128, 0));

        f = new Font("Arial", Font.PLAIN, 20);
        t13 = new JTextField();
        t13.setBounds(40, 360, 300, 40);
        t13.setFont(f);

        // Number
        l18 = new JLabel("Number");
        l18.setBounds(40, 400, 200, 20);
        l18.setForeground(new Color(0, 128, 0));

        f = new Font("Arial", Font.PLAIN, 20);
        t14 = new JTextField();
        t14.setBounds(40, 420, 300, 40);
        t14.setFont(f);

        updateButton = new JButton("Update");
        updateButton.setBounds(240, 480, 100, 30);

        p4.add(l13);
        p4.add(l14);
        p4.add(l15);
        p4.add(l16);
        p4.add(l17);
        p4.add(l18);
        p4.add(t10);
        p4.add(t11);
        p4.add(t12);
        p4.add(t13);
        p4.add(t14);
        p4.add(updateButton);

        p4.setLayout(null);
        
        f = new Font("Arial", Font.BOLD, 24);

        l19 = new JLabel("Display user details");
        l19.setBounds(40, 40, 400, 40);
        l19.setFont(f);
        l19.setForeground(Color.BLUE);
        
        displayButton = new JButton("Display");
        displayButton.setBounds(40, 100, 100, 30);

        p5.add(l19);
        p5.add(displayButton);
        
        p5.setLayout(null);
        
        JMenuBar mb = new JMenuBar();
        
        JMenu mUser = new JMenu("User");
        JMenu mDetails = new JMenu("Details");
        JMenu mHelp = new JMenu("Help");
        
        JMenuItem jmiCreate = new JMenuItem("Create user");
        JMenuItem jmiDelete = new JMenuItem("Delete user");
        JMenuItem jmiExit = new JMenuItem("Log out");
        
        JMenuItem jmiAdd = new JMenuItem("Add Details");
        JMenuItem jmiUpdate = new JMenuItem("Update Details");
        JMenuItem jmiDisplay = new JMenuItem("Display Details");
        
        JMenuItem jmiAbout = new JMenuItem("About the app");
        JMenuItem jmiHelp = new JMenuItem("Get Help");
        
        mUser.add(jmiCreate);
        mUser.add(jmiDelete);
        mUser.add(jmiExit);
        
        mDetails.add(jmiAdd);
        mDetails.add(jmiUpdate);
        mDetails.add(jmiDisplay);
        
        mHelp.add(jmiAbout);
        mHelp.add(jmiHelp);
        
        mb.add(mUser);
        mb.add(mDetails);
        mb.add(mHelp);
        
        frame.setJMenuBar(mb);
        
        jmiCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tp.setSelectedIndex(0);
            }
        });
        
        jmiDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tp.setSelectedIndex(1);
            }
        });
        
        jmiExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        jmiAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tp.setSelectedIndex(2);
            }
        });
        
        jmiUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tp.setSelectedIndex(3);
            }
        });
        
        jmiDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tp.setSelectedIndex(4);
            }
        });
        

        frame.add(tp);

        frame.setSize(700, 700);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        // Starts the JFrame in the center of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/student", "APP", " ");

                    Statement st = conn.createStatement();

                    String q = "insert into users values('" + t1.getText() + "','" + t2.getText() + "') ";

                    int status = st.executeUpdate(q);

                    if (status == 1) {
                        JOptionPane.showMessageDialog(null, "User created succesfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "User creation failed", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    if (conn != null) {
                        System.out.println("Connection Successful!");
                    } else {
                        System.out.println("So sad.");
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }

                t1.setText("");
                t2.setText("");

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/student", "APP", " ");

                    String q = "delete from users where username='" + t3.getText() + "' and password= '" + t4.getText() + "' ";
                    Statement st = conn.createStatement();

                    int status = st.executeUpdate(q);

                    if (status == 1) {
                        JOptionPane.showMessageDialog(null, "User deleted succesfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "User deletion failed", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    if (conn != null) {
                        System.out.println("Connection Successful!");
                    } else {
                        System.out.println("So sad.");
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
                t3.setText("");
                t4.setText("");
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/student", "APP", " ");

                    Statement st = conn.createStatement();

                    String q = "update users set fname = '" + t6.getText() + "',lname = '" + t7.getText() + "', email= '" + t8.getText() + "', number= '" + t9.getText() + "' where username = '" + t5.getText() + "'";

                    int status = st.executeUpdate(q);

                    if (status == 1) {
                        JOptionPane.showMessageDialog(null, "User details added succesfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "Details could not be added", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    if (conn != null) {
                        System.out.println("Connection Successful!");
                    } else {
                        System.out.println("So sad.");
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }

                t5.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");
                t9.setText("");

            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/student", "APP", " ");

                    Statement st = conn.createStatement();

                    String q = "update users set fname = '" + t11.getText() + "',lname = '" + t12.getText() + "', email= '" + t13.getText() + "', number= '" + t14.getText() + "' where username = '" + t10.getText() + "'";

                    int status = st.executeUpdate(q);

                    if (status == 1) {
                        JOptionPane.showMessageDialog(null, "User details updated succesfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "Details could not be updated", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    if (conn != null) {
                        System.out.println("Connection Successful!");
                    } else {
                        System.out.println("So sad.");
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }

                t1.setText("");
                t2.setText("");

            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/student", "APP", " ");

                    Statement st = conn.createStatement();

                    String q = "select * from users";

                    ResultSet rs = st.executeQuery(q);

                    ResultSetMetaData rsmt = rs.getMetaData();
                    int c = rsmt.getColumnCount();
                    Vector column = new Vector(c);

                    for (int i = 1; i <= c; i++) {
                        column.add(rsmt.getColumnName(i));
                    }

                    Vector data = new Vector();
                    Vector row = new Vector();

                    while (rs.next()) {
                        row = new Vector(c);

                        for (int i = 1; i <= c; i++) {
                            row.add(rs.getString(i));
                        }

                        data.add(row);
                    }

                    JFrame displayFrame = new JFrame();
                    displayFrame.setSize(500, 200);
                    displayFrame.setLocationRelativeTo(null);
                    displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    JPanel dpanel = new JPanel();
                    JTable table = new JTable(data, column);
                    JScrollPane jsp = new JScrollPane(table);
                    dpanel.setLayout(new BorderLayout());
                    dpanel.add(jsp, BorderLayout.CENTER);
                    displayFrame.setContentPane(dpanel);
                    displayFrame.setVisible(true);

                    if (conn != null) {
                        System.out.println("Connection Successful!");
                    } else {
                        System.out.println("So sad.");
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }

                t1.setText("");
                t2.setText("");

            }
        });
    }

    public static void main(String args[]) {
//        new Home();
    }
}
