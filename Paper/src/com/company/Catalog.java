package com.company;
import com.company.Tugas;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;



public class Catalog {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
        // Buat instance JFrame
        public void showcatalogpage () {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
        }

    public static void createAndShowGUI() {
        //CONTAINER
        JFrame form = new JFrame("Dunder-Mifflin Paper Co. Ordering App");
        form.setSize(600, 900);
        form.setLayout(null);
        form.setContentPane(new Catalog().panel3);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setResizable(false);
        form.pack();
        form.setLocationRelativeTo(null);
        ImageIcon image = new ImageIcon("icon.png");
        form.setIconImage(image.getImage());
        form.setVisible(true);
    }

    private JComboBox productbox;
    private JLabel pic1;
    private JLabel catalogue;
    private JLabel motto;
    private JLabel dunderMifflinLabel;
    private JPanel panel3;
    private JTextArea textArea1;
    private JButton backButton;
    private Tugas tugaspage;
    private String selectedProduct;
    public Catalog() {
        tugaspage = new Tugas();

        String Paper[][] = {
                {"High-Grade Paper", "500",},
                {"Photo Paper", "2000",},
                {"Quarto Paper", "1000", ""},
                {"Cardboard Paper", "1000"},
                {"Newsprint", "200"},
                {"Book Paper", "300"},
                {"Manila Paper", "1000"},
                {"Gloss Paper", "2500"},
        };
        String Pencil[][] = {{"B Pencil", "2000"},
                {"2B Pencil", "2500"},
                {"3B Pencil", "3000"},
                {"4B Pencil", "3200"},
                {"5B Pencil", "3700"},
                {"6B Pencil", "4000"},
                {"7B Pencil", "4800"},
                {"8B Pencil", "5000"},
                {"HB Pencil", "3500"},
                {"F Pencil", "2000"},
                {"2F Pencil", "2500"},
                {"3F Pencil", "3000"},
                {"4F Pencil", "4000"},
        };
        String Printer[][] = {{"Inkjet Printer", "5000000"}, {"Laser Printer", "16500000"},
        };
        String Stapler[][] = {{"Stapler", "7000"}, {"Gun Stapler", "200000"},
        };
        String Marker[][] = {{"Permanent Marker", "9000"},
        };
        String Pen[][] = {{"Ballpoint Pen", "3000"}, {"Drawing Pen", "10000"},
        };
        String Cartridge[][] = {{"Ink Cartridge", "150000"}, {"Toner Cartridge", "200000"},
        };
        String Correction[][] = {{"Correction Tape", "8000"}, {"Correction pen", "12000"},
        };
        String Highlighter[][] = { {"Pen Highlighter", "15000"}, {"Erasable Highlighter", "18000"},
        };
        String Eraser[][] = {   {"Rubber Eraser", "2500"}, {"Plastic Eraser", "5000"}, {"Gum Eraser", "9000"}, {"Vinyl Eraser", "9000"},
        };
        String Scanner[][] = {{"Paper Scanner", "3000000"},
        };
        String stickynotes[][] = {{"Sticky Notes", "7000"},{"Post-it", "15000"}, {"Page Marker", "12000"},
        };

        productbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedProduct = (String) productbox.getSelectedItem();

                    String[][] selectedArray = null;

                    switch (selectedProduct) {
                        case "Paper":
                            selectedArray = Paper;
                            break;
                        case "Pencil":
                            selectedArray = Pencil;
                            break;
                        case "Printer":
                            selectedArray = Printer;
                            break;
                        case "Stapler":
                            selectedArray = Stapler;
                            break;
                        case "Marker":
                            selectedArray = Marker;
                            break;
                        case "Pen":
                            selectedArray = Pen;
                            break;
                        case "Cartridge":
                            selectedArray = Cartridge;
                            break;
                        case "Correction":
                            selectedArray = Correction;
                            break;
                        case "Eraser":
                            selectedArray = Eraser;
                            break;
                        case "Sticky-Notes":
                            selectedArray = stickynotes;
                            break;
                        case "Highlighter":
                            selectedArray = Highlighter;
                            break;
                        case "Scanner":
                            selectedArray = Scanner;
                            break;
                    }
                    if (selectedArray != null) {
                        StringBuilder sb = new StringBuilder();
                        for (String[] item : selectedArray) {
                            sb.append(item[0]).append(" - Rp ").append(item[1]).append("\n");
                        }
                        textArea1.setText(sb.toString());
                    }
                }
            }
        });
    }
}
