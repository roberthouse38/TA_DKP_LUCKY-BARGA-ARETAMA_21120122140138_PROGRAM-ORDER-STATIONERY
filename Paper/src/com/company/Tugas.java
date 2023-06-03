package com.company;
import com.company.Catalog;
import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Tugas extends JFrame{

    public static void main(String[] args) {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                         UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                    }
                }
        // Instance JFrame
                public void showTugasPage () {
                    javax.swing.SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            createAndShowGUI();
                        }
                    });
                }


    public JComboBox productlist;
    private JRadioButton subs1;
    private JRadioButton subs2;
    private JComboBox day;
    private JComboBox month;
    private JTextField year;
    private JTextField quantitytext;
    private JButton order;
    private JButton reset;
    private JTextArea textarea;
    private JTextField typetext;
    private JTextField pricetext;
    private JPanel panel;
    private JLabel product;
    private JLabel type;
    private JLabel title;
    private JLabel motto;
    private JLabel date;
    private JLabel membership;
    private JLabel quantity;
    private JLabel price;
    private JButton exit;
    private JButton catalogueButton;
    private JScrollPane scrollpane;

    public void showCatalogPage(){
        Catalog catalog = new Catalog();
        catalog.createAndShowGUI();
        dispose();
    }
    private static void createAndShowGUI(){
        //CONTAINER
                JFrame form = new JFrame("Dunder-Mifflin Paper Co. Ordering App");
                form.setPreferredSize(null);
                form.setLayout(null);
                form.setContentPane(new Tugas().panel);
                form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                form.setResizable(true);
                form.pack();
                form.setLocationRelativeTo(null);
                ImageIcon image = new ImageIcon("icon.png");
                form.setIconImage(image.getImage());
                form.setVisible(true);
            }


    // EVENT HANDLER //
        //BUTTON
    public Tugas(){

                catalogueButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showCatalogPage();
                    }
                });


    //order button
                order.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String quantityInput = quantitytext.getText();
                        if (quantityInput.isEmpty() || !quantityInput.matches("\\d++")){
                            JOptionPane.showMessageDialog(null,"Please enter a valid quantity.");
                            return;
                        }
                        int quantity = Integer.parseInt(quantityInput);

                        String selectedProduct = productlist.getSelectedItem().toString();
                        String dayinput = day.getSelectedItem().toString();
                        String monthinput = month.getSelectedItem().toString();
                        String yearinput = year.getText();

                        if (yearinput.isEmpty() || !yearinput.matches("\\d+")){
                            JOptionPane.showMessageDialog(null, "Please enter a valid year");
                            return;
                        }
                        int year = Integer.parseInt(yearinput);

                        String type = typetext.getText();
                        String price = pricetext.getText();

                        String selectedSubscriber = "";
                        double discount = 0.0;
                        if (subs1.isSelected()) {
                            selectedSubscriber = subs1.getText();
                            discount = 0.2;
                        } else if (subs2.isSelected()) {
                            selectedSubscriber = subs2.getText();
                            discount = 0.1;
                        }


                        // total price calculation
                                int itemPrice = Integer.parseInt(price);
                                int totalPrice = quantity * itemPrice;
                                double discountPrice = totalPrice - (totalPrice * discount);

                                textarea.append("\n Your Product is: " + selectedProduct +
                                        " and the type is: " + type +
                                        " and the price of 1 item will be: " + price +
                                        " \nTotal items to be purchased is: " + quantity +
                                        "\nHello " + selectedSubscriber +
                                        " \n\nYour total price of " + quantity + " " + selectedProduct + " Will be: " + discountPrice +
                                        "\n\nOrder Date will be : " +  dayinput + " " + monthinput + " " + yearinput
                                + "\n\n===============================================================================================");

                                JOptionPane.showMessageDialog(null, "" + " Press OK For The Checkout, Thank You! ");
                            }
                        });
                //reset button
                reset.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        quantitytext.setText("");
                        pricetext.setText("");
                        typetext.setText("");
                        textarea.setText("");
                        year.setText("");
                        productlist.setSelectedIndex(0);
                        day.setSelectedIndex(0);
                        month.setSelectedIndex(0);
                        subs1.setSelected(false);
                        subs2.setSelected(false);
                        JOptionPane.showMessageDialog(null, " Dunder-Mifflin Ready To Serve You! " );
                    }
                });



                    exit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                        }
                    });


        //ELEMENT MODIFY SECTION
        //Radio Button 1 option only
                    ButtonGroup groupmembership = new ButtonGroup();            //only 1 button choosed
                    groupmembership.add(subs1);
                    groupmembership.add(subs2);

                    String selectedSubscriber = "";

        //pricetext field
                    pricetext.setEnabled(false);

        //textarea field
                    textarea.setEnabled(false);


        //Type Text
                    typetext.addKeyListener(new KeyListener() {
                        @Override
                        public void keyTyped(KeyEvent e) {

                        }
                        @Override
                        public void keyPressed(KeyEvent e) {
                            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                String data[][] = {{"High-Grade Paper", "500",},
                                        {"Photo Paper", "2000", },
                                        {"Quarto Paper", "1000", ""},
                                        {"Inkjet Printer", "5000000"},
                                        {"Laser Printer", "16500000"},
                                        {"Paper Scanner", "3000000"},
                                        {"Cardboard Paper", "1000"},
                                        {"Newsprint", "200"},
                                        {"Book Paper", "300"},
                                        {"Manila Paper", "1000"},
                                        {"Gloss Paper", "2500"},
                                        {"Correction Tape", "8000"},
                                        {"Correction pen", "12000"},
                                        {"Ink Cartridge", "150000"},
                                        {"Toner Cartridge", "200000"},
                                        {"B Pencil", "2000"},
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
                                        {"Stapler", "7000"},
                                        {"Gun Stapler", "200000"},
                                        {"Sticky Notes", "7000"},
                                        {"Ballpoint Pen", "3000"},
                                        {"Drawing Pen", "10000"},
                                        {"Post-it", "15000"},
                                        {"Page Marker", "12000"},
                                        {"Rubber Eraser", "2500"},
                                        {"Plastic Eraser", "5000"},
                                        {"Gum Eraser", "9000"},
                                        {"Vinyl Eraser", "9000"},
                                        {"Pen Highlighter", "15000"},
                                        {"Erasable Highlighter", "18000"},
                                        {"Permanent Marker", "9000"},
                                        {"Permanent Marker", "9000"},
                                };
                                String found = "not";
                                for (int i = 0; i < data.length; i++) {
                                    if (typetext.getText().equals(data[i][0])) {
                                        pricetext.setText(data[i][1]);
                                        found = "yes";
                                        break;
                                    }
                                }
                                if (found.equals("not")) {
                                    JOptionPane.showMessageDialog(null, "No item found (Not In The Stock OR type the right item's type name)");
                                    typetext.setText("");
                                    pricetext.setText("");
                                }
            ;                }
                        }
                        @Override
                        public void keyReleased(KeyEvent e) {
                        }
                    });

        //membership
                    subs1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            textarea.setText("Hello Our beloved Dunder-Mifflin client, there will be 20% discount for you today! thank you " + subs1.getText());
                        }
                    });
                    subs2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            textarea.setText("Hello general member of Dunder-Mifflin, 10% discount available for all item today, thank you" + subs2.getText());
                        }
                    });
    }
}



