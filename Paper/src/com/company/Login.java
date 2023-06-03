package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    //modify
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        // Buat instance JFrame
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        //CONTAINER
        JFrame form = new JFrame("Dunder-Mifflin Paper Co. Ordering App");
        form.setSize(600, 700);
        form.setLayout(null);
        form.setContentPane(new Login().panel2);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setResizable(false);
        form.pack();
        form.setLocationRelativeTo(null);
        ImageIcon image = new ImageIcon("icon.png");
        form.setIconImage(image.getImage());
        form.setVisible(true);
    }

    private JPasswordField passwordtxt;
    private JProgressBar loading;
    private JPanel panel2;
    private JButton Continue;
    private JTextField usernametxt;


    // EVENT HANDLER //==============================================
    //BUTTON
    public Login() {
        Continue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = "admin";
                String pass = "root";
                if (usernametxt.getText().equals(user) && passwordtxt.getText().equals(pass)){
                    loading.setVisible(true);
                    Continue.setEnabled(false);
                    dispose();

                    Thread loginThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            // Login Process and delay
                            for (int i = 0; i <= 100; i++) {
                                loading.setValue(i);
                                try {
                                    Thread.sleep(20);
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }
                            }
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    Tugas tugasPage = new Tugas();
                                    tugasPage.showTugasPage();
                                }
                            });
                        }
                    });
                    loginThread.start();
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Username or Password");
                }
            }
        });
    }
}
