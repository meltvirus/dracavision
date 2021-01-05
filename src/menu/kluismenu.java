package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class kluismenu {
    private JPanel kluispanel;
    private JLabel uwnummerlabel;
    private JLabel kluisnummer;
    private JButton openkluis;
    private JLabel kluisstatus;
    private JButton homebutton;
    String getal = "11";

    public kluismenu() {

        if (instellingen.darkmode == true){
            kluispanel.setBackground(new Color(0x24242B));

        } else {
            kluispanel.setBackground(new Color(-1));
        }
        kluispanel.repaint();
        kluispanel.revalidate();

        kluisnummer.setText(getal);
        openkluis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open kluis");
                kluisstatus.setText("Kluis geopend!");

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
