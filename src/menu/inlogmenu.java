package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static menu.SQLDatabaseConnection.*;

public class inlogmenu {
    public static JFrame frame = new JFrame("DRACA Vision");
    //private JPanel inlogmenu;
    //private JButton loginbutton;
    //private JTextField passwordField1; //JPasswordField
    public String wachtwoord;
    public String emailadres;
    private boolean inlogjuist = false;

    //public JPanel panel1test;

    public JPanel panel1;
    public JTextField eMailTextField;
    public JPasswordField a12345PasswordField;
    private JButton logInButton;
    private JLabel wachtwoordstatus;
    public String wachtwoord2;

    public inlogmenu() {
        instellingen.darkmode = false;

        panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(10, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBackground(new Color(-1));
        panel1.setEnabled(true);
        panel1.setForeground(new Color(-4473925));
        eMailTextField = new JTextField();
        eMailTextField.setBackground(new Color(-1644826));
        eMailTextField.setHorizontalAlignment(2);
        eMailTextField.setText("E-mail");
        eMailTextField.setToolTipText("");
        panel1.add(eMailTextField, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(390, 40), null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setBackground(new Color(-54151));
        Font label1Font = this.getFon("Dubai", Font.BOLD, 36, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-54151));
        label1.setText("Sign in");
        panel1.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("");
        panel1.add(label2, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 5, false));
        final JLabel label3 = new JLabel();
        label3.setText("");
        panel1.add(label3, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 5, false));
        final JLabel label4 = new JLabel();
        label4.setText("");
        panel1.add(label4, new com.intellij.uiDesigner.core.GridConstraints(8, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, new Dimension(-1, 40), new Dimension(-1, 400), null, 0, false));
        a12345PasswordField = new JPasswordField();
        a12345PasswordField.setBackground(new Color(-1644826));
        a12345PasswordField.setText("12345");
        panel1.add(a12345PasswordField, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(390, 40), new Dimension(-1, 40), 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("");
        panel1.add(label5, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, 1, new Dimension(-1, 46), new Dimension(-1, 46), new Dimension(-1, 46), 0, false));
        logInButton = new JButton();
        logInButton.setBackground(new Color(-54151));
        logInButton.setEnabled(true);
        Font logInButtonFont = this.getFon("Dubai", -1, 17, logInButton.getFont());
        if (logInButtonFont != null) logInButton.setFont(logInButtonFont);
        logInButton.setForeground(new Color(-1));
        logInButton.setHideActionText(false);
        logInButton.setText("Log in");
        panel1.add(logInButton, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 5), new Dimension(390, 40), new Dimension(-1, 100), 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("");
        panel1.add(label6, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 10), new Dimension(-1, 10), new Dimension(-1, 10), 0, false));
        final JButton button1 = new JButton();
        button1.setBackground(new Color(-1));
        button1.setEnabled(true);
        Font button1Font = this.getFon("Dubai", -1, 17, button1.getFont());
        if (button1Font != null) button1.setFont(button1Font);
        button1.setForeground(new Color(-54151));
        button1.setHideActionText(false);
        button1.setText("Need an account?");
        panel1.add(button1, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 5), new Dimension(390, 40), new Dimension(-1, 100), 0, false));
        final JLabel label7 = new JLabel();
        Font label7Font = this.getFon("Dubai", -1, 14, label7.getFont());
        if (label7Font != null) label7.setFont(label7Font);
        label7.setForeground(new Color(-7631989));
        label7.setText("Forgot password?");
        panel1.add(label7, new com.intellij.uiDesigner.core.GridConstraints(9, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(30, 15), null, 0, false));
        wachtwoordstatus = new JLabel();
        wachtwoordstatus.setBackground(new Color(-54151));
        Font wachtwoordstatusFont = this.getFon("Dubai", Font.BOLD, 22, wachtwoordstatus.getFont());
        if (wachtwoordstatusFont != null) wachtwoordstatus.setFont(wachtwoordstatusFont);
        wachtwoordstatus.setForeground(new Color(-5367996));
        wachtwoordstatus.setText("");
        panel1.add(wachtwoordstatus, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        panel1.setPreferredSize(new Dimension(504, 896));
        /*inlogmenu = new JPanel();
        loginbutton = new JButton("Log in");
        passwordField1 = new JPasswordField();
        passwordField1.setPreferredSize(new Dimension(300, 40));
        inlogmenu.setPreferredSize(new Dimension(500, 900));


        inlogmenu.add(loginbutton);
        inlogmenu.add(passwordField1);
        */

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                wachtwoord = a12345PasswordField.getText();
                wachtwoord2 = a12345PasswordField.getText();
                emailadres = eMailTextField.getText();

                try {
                    //new SQLDatabaseConnection();
                    SQLDatabaseConnection.dracadbinlog(eMailTextField.getText());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


                if (wachtwoord.equals(combinatie) && SQLDatabaseConnection.masteracc == false && SQLDatabaseConnection.werknemer == false) {
                    hoofdmenu.ismaster = false;
                    inlogjuist = true;
                    inlogpoingen();


                    hoofdmenu hoofdmenu = new hoofdmenu();
                    frame.setContentPane(hoofdmenu.getHoofdmenupanel());
                    frame.repaint();
                    frame.revalidate();

                    /*bestellingmenu bestellingmenu = new bestellingmenu();
                    frame.setContentPane(bestellingmenu.getBestellingpane());
                    frame.repaint();
                    frame.revalidate();*/


                } else {
                    if (wachtwoord.equals(combinatie) && masteracc==true) {
                        hoofdmenu.ismaster = true;
                        inlogjuist = true;
                        inlogpoingen();
                        hoofdmenu hoofdmenu = new hoofdmenu();
                        frame.setContentPane(hoofdmenu.getHoofdmenupanel());
                        frame.repaint();
                        frame.revalidate();





                    } else {
                        if (wachtwoord.equals(combinatie) && werknemer==true) {
                            hoofdmenu.iswerknemer = true;
                            inlogjuist = true;
                            inlogpoingen();
                            hoofdmenu hoofdmenu = new hoofdmenu();
                            frame.setContentPane(hoofdmenu.getHoofdmenupanel());
                            frame.repaint();
                            frame.revalidate();
                        } else {
                            hoofdmenu.ismaster = false;
                            hoofdmenu.iswerknemer = false;
                            inlogjuist = false;
                            inlogpoingen();
                        }





                        //System.out.println("Onjuiste inlogpoing");
                        wachtwoordstatus.setText("Incorrecte inloggegevens");
                    }
                }

            }
        });
        //account maken button
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    /*bestellingmenu bestellingmenu = new bestellingmenu();
                    frame.setContentPane(bestellingmenu.getBestellingpane());
                    frame.repaint();
                    frame.revalidate();*/


                /*frame.getContentPane().removeAll();
                guiform.accountaanmaak accountaanmaak = new guiform.accountaanmaak();
                frame.setContentPane(accountaanmaak.getAccountpanel());
                frame.repaint();
                frame.revalidate();
                */
                naaraccountaanmaak();



            }
        });
    }

    public static void main(String[] args) {

        //frame.setContentPane(new inlogmenu().inlogmenu);
        frame.setContentPane(new inlogmenu().panel1);
        frame.setSize(504, 896);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);



        /*
        JFrame frame = new JFrame("DRACA Vision");
        frame.setContentPane(new inlogmenu().inlogmenu);
        frame.setSize(200, 1000);
frame.setResizable(false);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        */



    }
    private Font getFon(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }
    public static void kluismenuframe(){
        frame.getContentPane().removeAll();
        kluismenu kluismenu = new kluismenu();
        frame.setContentPane(kluismenu.getKluismenu());
        frame.repaint();
        frame.revalidate();

    }

    public static void naarinlogmenu(){
        frame.getContentPane().removeAll();
        frame.setContentPane(new inlogmenu().panel1);
        frame.repaint();
        frame.revalidate();

    }

    public static void naarhoofdmenu(){
        frame.getContentPane().removeAll();
        frame.setContentPane(new hoofdmenu().getHoofdmenupanel());
        frame.repaint();
        frame.revalidate();

    }

    public static void naarmasteraccount(){
        frame.getContentPane().removeAll();
        frame.setContentPane(new masteraccount().getMasteraccountpanel());
        frame.repaint();
        frame.revalidate();

    }

    public static void naarinstellingen(){
        frame.getContentPane().removeAll();
        frame.setContentPane(new instellingen().getInstellingenpanel());
        frame.repaint();
        frame.revalidate();

    }

    public static void naarmeldingen(){
        frame.getContentPane().removeAll();
        frame.setContentPane(new meldingen().getMeldingenpanel());
        frame.repaint();
        frame.revalidate();

    }

    public static void naaraccountaanmaak(){
        frame.getContentPane().removeAll();
        frame.setContentPane(new menu.accountaanmaak().getAccountpanel());
        frame.repaint();
        frame.revalidate();

    }

    public static void naarbestellingmenu(){
        frame.getContentPane().removeAll();
        frame.setContentPane(new bestellingmenu().getBestellingpane());
        /*if (instellingen.darkmode == true){
            frame.setBackground(new Color(0x24242B));

        } else {
            frame.setBackground(new Color(-1));
        }*/

        frame.repaint();
        frame.revalidate();

    }

    public void inlogpoingen(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime tijdnu = LocalDateTime.now();
        try(FileWriter fw = new FileWriter("resources/inlogpogingen.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.printf("["+dtf.format(tijdnu)+"]");
            if (inlogjuist) {
                out.println(String.format(" %s , Succesful", emailadres));
            } else {
                out.println(String.format(" %s , Failed", emailadres));
            }

        } catch (java.io.IOException e){
            System.out.println(e);
        }
    }

    /*public boolean inlogtest(){
        if (combinatie.equals(emailadres+wachtwoord)){
            return true;
        } else {
            return false;
        }
    }

    public String inlogmail(){
        return eMailTextField.getText();
    }*/


        /*public static void dbconnection() {
            try
            {
                // Step 1: "Load" the JDBC driver
                Class.forName("com.imaginary.sql.msql.MsqlDriver");

                // Step 2: Establish the connection to the database
                String url = "jdbc:mysql://localhost:3306/?user=root";
                Connection conn = DriverManager.getConnection(url,"dracavision","DracaVision?Draca");
            }
            catch (Exception e)
            {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
            }
        }*/







}


/*
toevoegen functies inlogmenu:
forgot password
need an account
scroll wheel
email/password vak leeg

----
kluis open kunnen maken & kluisnummer kunnen zien
bestelling kunnen plaatsen
& winkelwagen

eventueel master account menu
eventueel maken van account
 */
