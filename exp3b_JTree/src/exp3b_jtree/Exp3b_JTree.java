/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exp3b_jtree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author sohel
 */
public class Exp3b_JTree {

    private Connection conn = null;
//    private Statement statement = null;
    private ResultSet resultSet = null;

    JFrame mainFrame;

    public Exp3b_JTree() throws SQLException {
        mainFrame = new JFrame("JTree Demo");
        DefaultMutableTreeNode semester = new DefaultMutableTreeNode("Semester 6");
        DefaultMutableTreeNode elective1 = new DefaultMutableTreeNode("Elective 1");
        DefaultMutableTreeNode elective2 = new DefaultMutableTreeNode("Elective 2");
        DefaultMutableTreeNode elective3 = new DefaultMutableTreeNode("Elective 3");

        semester.add(elective1);
        semester.add(elective2);
        semester.add(elective3);

        //        subjects for elctive1
        DefaultMutableTreeNode java = new DefaultMutableTreeNode("Java Technologies");
        DefaultMutableTreeNode mad = new DefaultMutableTreeNode("Mobile Application Development");
        DefaultMutableTreeNode lamp = new DefaultMutableTreeNode("LAMP Technologies");

        elective1.add(java);
        elective1.add(mad);
        elective1.add(lamp);

        //        subjects for elective2
        DefaultMutableTreeNode cloud = new DefaultMutableTreeNode("Cloud Technologies");
        DefaultMutableTreeNode bao = new DefaultMutableTreeNode("Business Analysis and Optimization");
        DefaultMutableTreeNode nse = new DefaultMutableTreeNode("Network Security and Encryption");

        elective2.add(cloud);
        elective2.add(bao);
        elective2.add(nse);

        //        subjects for elective3
        DefaultMutableTreeNode ml = new DefaultMutableTreeNode("Machine Learning");
        DefaultMutableTreeNode dm = new DefaultMutableTreeNode("Data Mining");
        DefaultMutableTreeNode ads = new DefaultMutableTreeNode("Advanced Data Structures");

        elective3.add(ml);
        elective3.add(dm);
        elective3.add(ads);

        JTree jt = new JTree(semester);
        //System.out.println("Connection Successful!");
        mainFrame.add(jt);
        mainFrame.setSize(500, 500);
        mainFrame.setVisible(true);

        try {

            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/student", "APP", " ");
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM STUDENT");

            resultSet = statement.executeQuery();

            if (conn != null) {
                System.out.println("Connection Successful!");
            } else {
                System.out.println("So sad.");
            }

            while (resultSet.next()) {
                String user = resultSet.getString("roll");
                String name = resultSet.getString("name");
                String elective = resultSet.getString("elective");

                if (elective.equals("JT")) {
                    DefaultMutableTreeNode r = new DefaultMutableTreeNode(user + " " + name);
                    java.add(r);
                } else if (elective.equals("LAMP")) {
                    DefaultMutableTreeNode r = new DefaultMutableTreeNode(user + " " + name);
                    lamp.add(r);
                }
                else if (elective.equals("MAD")) {
                    DefaultMutableTreeNode r = new DefaultMutableTreeNode(user + " " + name);
                    mad.add(r);
                }
                else if (elective.equals("CC")) {
                    DefaultMutableTreeNode r = new DefaultMutableTreeNode(user + " " + name);
                    cloud.add(r);
                }
                else if (elective.equals("BAO")) {
                    DefaultMutableTreeNode r = new DefaultMutableTreeNode(user + " " + name);
                    bao.add(r);
                }
                else if (elective.equals("ML")) {
                    DefaultMutableTreeNode r = new DefaultMutableTreeNode(user + " " + name);
                    ml.add(r);
                }
                else if (elective.equals("DM")) {
                    DefaultMutableTreeNode r = new DefaultMutableTreeNode(user + " " + name);
                    dm.add(r);
                }
                else if (elective.equals("ADS")) {
                    DefaultMutableTreeNode r = new DefaultMutableTreeNode(user + " " + name);
                    ads.add(r);
                }

                System.out.println("User: " + user);
                System.out.println("ID: " + name);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Exp3b_JTree exp3b_JTree = new Exp3b_JTree();
    }

}
