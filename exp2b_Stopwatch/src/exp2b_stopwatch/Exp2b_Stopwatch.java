/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exp2b_stopwatch;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author b201
 */
public class Exp2b_Stopwatch extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Exp2b_Stopwatch();
    }

    public Exp2b_Stopwatch() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Stopwatch");
                frame.setSize(500, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new StopWatchPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class StopWatchPane extends JPanel {

        private JLabel label;
        private long lastTickTime;
        private Timer timer;
        long hours;
        long minutes;
        long millis;
        long seconds;

        public StopWatchPane() {
            setLayout(new GridBagLayout());

            label = new JLabel(String.format("%04d:%02d:%02d.%03d", 0, 0, 0, 0));
            label.setFont(new Font("Courier New", Font.BOLD, 24));
            label.setForeground(Color.red);

            timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    long runningTime = System.currentTimeMillis() - lastTickTime;
                    Duration duration = Duration.ofMillis(runningTime);
                    hours = duration.toHours();
                    duration = duration.minusHours(hours);
                    minutes = duration.toMinutes();
                    duration = duration.minusMinutes(minutes);
                    millis = duration.toMillis();
                    seconds = millis / 1000;
                    millis -= (seconds * 1000);
                    label.setText(String.format("%04d:%02d:%02d.%03d", hours, minutes, seconds, millis));
                }
            });

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.insets = new Insets(4, 4, 4, 4);
            add(label, gbc);

            JButton start = new JButton("Start");
            start.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!timer.isRunning()) {
                        lastTickTime = System.currentTimeMillis();
                        timer.start();
                    }
                }
            });

            JButton stop = new JButton("Stop");
            stop.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    timer.stop();
                }
            });

            JButton reset = new JButton("Reset");
            reset.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    hours = 0;
                    minutes = 0;
                    millis = 0;
                    seconds = 0;
                    label.setText(String.format("%04d:%02d:%02d.%03d", hours, minutes, seconds, millis));
                    timer.stop();
                }
            });

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.weightx = 0;
            gbc.gridwidth = 1;
            add(start, gbc);
            gbc.gridx++;
            add(stop, gbc);
            gbc.gridx++;
            add(reset, gbc);
        }
    }
}
