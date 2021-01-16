package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ArrayList;

public class werknemermenu {
    private JPanel werknemerpanel;
    private JButton terugbutton1;
    private JButton pakketbutton;
    private JComboBox comboBox4;
    public JComboBox bestellingcombobox;
    private JButton laadbestellingen;
    private JLabel foutmelding;
    public Object kluisnummertje;
    public Object bestelnummer;
    public static String bestelnr;
    public static String kluisnr;
    public static int bestelint;
    public static int kluisnrint;
    public static String melding;



    public werknemermenu() {
        melding = "";
        foutmelding.setText(melding);

        if (instellingen.darkmode == true){
            werknemerpanel.setBackground(new Color(0x24242B));

        } else {
            werknemerpanel.setBackground(new Color(-1));
        }
        werknemerpanel.repaint();
        werknemerpanel.revalidate();

        comboBox4.addItem("");
        comboBox4.addItem("1");
        comboBox4.addItem("2");
        comboBox4.addItem("3");
        comboBox4.addItem("4");
        bestellingcombobox.addItem("");


        terugbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inlogmenu.naarhoofdmenu();
            }
        });
        pakketbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kluisnummertje = comboBox4.getSelectedItem();
                bestelnummer = "";
                if (bestelnummer != null) {
                    bestelnummer = bestellingcombobox.getSelectedItem();
                }

                    if (!kluisnummertje.equals("") && !bestelnummer.equals("")) {
                        if (!bestelnummer.equals("")) {
                            getKluisnummertje();
                            bestelnr = (String) bestelnummer;
                            kluisnrint = Integer.parseInt(kluisnr);
                            bestelint = Integer.parseInt(bestelnr);

                            try {
                                SQLDatabaseConnection.verstuurkluisnr(kluisnrint, bestelint);
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                            if (SQLDatabaseConnection.isalinkluis == false) {
                                inlogmenu.naarhoofdmenu();
                            }
                            melding ="";
                        } else {
                            //System.out.println("vul beiden in");
                            melding = "Vul beiden in.";

                        }
                    } else {
                        melding = "Vul beiden in.";

                    System.out.println("vul beiden in");
                }
                    foutmelding.setText(melding);

                    /*switch (kluisnrint){
                        case 1:
                            System.out.println("stuur hier kluis 1 naar klant");
                            try {
                                SQLDatabaseConnection.verstuurkluisnr(kluisnrint);
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                            break;
                        case 2:
                            System.out.println("stuur hier kluis 2");
                            break;
                        case 3:
                            System.out.println("stuur hier kluis 3");
                            break;
                        case 4:
                            System.out.println("stuur hier kluis 4");
                            break;
                        default:
                    }*/



            }
        });
        laadbestellingen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bestellingcombobox.removeAllItems();
                bestellingcombobox.addItem("");
                try {
                    SQLDatabaseConnection.bestellingconnectie();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                for( String oneItem : SQLDatabaseConnection.where ) {
                    bestellingcombobox.addItem(oneItem);
                }


            }
        });
    }

    public JPanel getWerknemerpanel(){
        return werknemerpanel;
    }

    public void getKluisnummertje(){
        kluisnr = (String) kluisnummertje;
    }


}


