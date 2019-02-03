/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exp2a_eventhandling;

/**
 *
 * @author sohel
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exp2a_EventHandling {

    private final JFrame mainFrame;
    private final JLabel headerLabel;
    private final JLabel statusLabel;
    private final JPanel controlPanel;

    JButton btnOne = new JButton("Click here");
    JButton btnTwo = new JButton("Not here");
    JButton btnThree = new JButton("Not here");
    JButton btnFour = new JButton("Not here");

    private int count = 0;

    public Exp2a_EventHandling() {
        mainFrame = new JFrame("Java Event Handling");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(3, 1));

        headerLabel = new JLabel("", JLabel.CENTER);
        headerLabel.setFont(new Font("Courier New", Font.BOLD, 16));
        headerLabel.setForeground(Color.red);

        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setFont(new Font("Courier New", Font.BOLD, 16));
        statusLabel.setSize(350, 100);

        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Exp2a_EventHandling eventHandlingDemo = new Exp2a_EventHandling();
        eventHandlingDemo.showEventDemo();
    }

    public void showEventDemo() {

        headerLabel.setText("Click on the button 10 times.");

        btnOne.setActionCommand("Click here");
        btnTwo.setActionCommand("Not here");
        btnThree.setActionCommand("Not here");
        btnFour.setActionCommand("Not here");

        btnOne.addActionListener(new ButtonClickListener());
        btnTwo.addActionListener(new ButtonClickListener());
        btnThree.addActionListener(new ButtonClickListener());
        btnFour.addActionListener(new ButtonClickListener());

        controlPanel.add(btnOne);
        controlPanel.add(btnTwo);
        controlPanel.add(btnThree);
        controlPanel.add(btnFour);

        mainFrame.setVisible(true);
    }

    public void randomActions() {

        int random = (int) (Math.random() * 4 + 1);
//       String lbl = statusLabel.getText() + Integer.toString(random);
//       statusLabel.setText(lbl);

        switch (random) {
            case 1:
                btnOne.setActionCommand("Click here");
                btnOne.setText("Click here");

                btnTwo.setActionCommand("Not here");
                btnTwo.setText("Not here");
                btnThree.setActionCommand("Not here");
                btnThree.setText("Not here");
                btnFour.setActionCommand("Not here");
                btnFour.setText("Not here");
                break;
            case 2:
                btnTwo.setActionCommand("Click here");
                btnTwo.setText("Click here");

                btnOne.setActionCommand("Not here");
                btnOne.setText("Not here");
                btnThree.setActionCommand("Not here");
                btnThree.setText("Not here");
                btnFour.setActionCommand("Not here");
                btnFour.setText("Not here");

                break;
            case 3:
                btnThree.setActionCommand("Click here");
                btnThree.setText("Click here");

                btnOne.setActionCommand("Not here");
                btnOne.setText("Not here");
                btnTwo.setActionCommand("Not here");
                btnTwo.setText("Not here");
                btnFour.setActionCommand("Not here");
                btnFour.setText("Not here");
                break;
            case 4:
                btnFour.setActionCommand("Click here");
                btnFour.setText("Click here");

                btnOne.setActionCommand("Not here");
                btnOne.setText("Not here");
                btnTwo.setActionCommand("Not here");
                btnTwo.setText("Not here");
                btnThree.setActionCommand("Not here");
                btnThree.setText("Not here");

                break;
        }

    }

    private class ButtonClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            headerLabel.setFont(new Font("Courier New", Font.BOLD, 24));

            if (command.equals("Click here")) {
                statusLabel.setForeground(new Color(0, 128, 0));
                statusLabel.setText("Good Job. Do it again.");
                count++;
                randomActions();
            } else if (command.equals("Not here")) {
                statusLabel.setForeground(Color.RED);
                statusLabel.setText("Wrong, try again!");
            } else {
                statusLabel.setText("Cancel Button clicked.");
            }

            headerLabel.setText(Integer.toString(count));

            if (count == 10) {
                mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
                // Alternative Solution
                // mainFrame.setVisible(false); //you can't see me!
                // mainFrame.dispose(); //Destroy the JFrame object
            }
        }
    }
}
