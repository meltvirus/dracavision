package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class kluismenu {
    private JPanel kluispanel;
    private JLabel uwnummerlabel;
    public JLabel kluisnummer;
    private JButton openkluis;
    public JLabel kluisstatus;
    private JButton homebutton;


    public kluismenu() {



        if (instellingen.darkmode == true){
            kluispanel.setBackground(new Color(0x24242B));

        } else {
            kluispanel.setBackground(new Color(-1));
        }
        kluispanel.repaint();
        kluispanel.revalidate();



        kluisnummer.setText(hoofdmenu.getal);
        openkluis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open kluis");
                //kluisstatus.setText("Kluis geopend!");
                try {
                    SQLDatabaseConnection.openkluis(SQLDatabaseConnection.klantnummer);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                // HIER DE MICROBIT CODE (SWITCH STATEMENT LIJKT ME HANDIG)
                // (INT)


            }
        });
        homebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inlogmenu.naarhoofdmenu();
            }
        });
    }

    public JPanel getKluismenu(){
        return kluispanel;
    }
    //nummer.setText(getal);
}
