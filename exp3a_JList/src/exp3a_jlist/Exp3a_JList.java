/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exp3a_jlist;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author sohel
 */
public class Exp3a_JList {

    JFrame mainFrame;
    JLabel headerLabel;
    JLabel statusLabel;
    JPanel controlPanel;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Exp3a_JList exp3a_JList = new Exp3a_JList();
        exp3a_JList.showListDemo();
    }

    public Exp3a_JList() {
        prepareGUI();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("JList Demo");
        mainFrame.setSize(600, 600);
        mainFrame.setLayout(new GridLayout(3, 1));

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);

        mainFrame.setVisible(true);

    }

    private void showListDemo() {
        headerLabel.setText("Select items from the list:");
        headerLabel.setFont(new Font("Courier New", Font.BOLD, 24));
        statusLabel.setFont(new Font("Courier New", Font.BOLD, 24));
        headerLabel.setForeground(Color.red);

        final DefaultListModel languages = new DefaultListModel();

        languages.addElement("Python");
        languages.addElement("Java");
        languages.addElement("C++");
        languages.addElement("Python");
        languages.addElement("C#");
        languages.addElement("JavaScript");
        languages.addElement("Python");
        languages.addElement("Java");
        languages.addElement("C++");

        final JList languagesList = new JList(languages);
        languagesList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        languagesList.setSelectedIndex(0);
        languagesList.setVisibleRowCount(10);

        JScrollPane languageListScrollPane = new JScrollPane(languagesList);

        JButton showButton = new JButton("Show");

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data;
                if (languagesList.getSelectedIndex() != -1) {

                    boolean flag = true;
                    int[] t = languagesList.getSelectedIndices();
                    for (int i = 0; i < t.length; i++) {
                        for (int j = 0; j < t.length; j++) {
                            if (languages.getElementAt(t[i]) != languages.getElementAt(t[j])) {
                                flag = false;
                            }
                        }

                    }
                    if (flag) {
                        data = "All strings are equal!";
                    } else {
                        data = "They are not all equal!";
                    }
                    statusLabel.setText(data);
                }
            }
        });
        controlPanel.add(languageListScrollPane);
        controlPanel.add(showButton);

        mainFrame.setVisible(true);
    }
}
