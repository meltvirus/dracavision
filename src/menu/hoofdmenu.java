package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static menu.inlogmenu.*;

public class hoofdmenu {
    public static boolean ismaster;

    private JPanel hoofdmenupanel;
    private JLabel uwnummerlabel;
    private JButton productenbutton;
    private JButton uitlogbutton;
    public JButton mastermenubutton;
    private JButton instellingenbutton;
    private JButton kluisopenenbutton2;
    private JButton meldingenbutton;


    public hoofdmenu() {
        if (instellingen.darkmode){
            hoofdmenupanel.setBackground(new Color(0x24242B));

        } else {
            hoofdmenupanel.setBackground(new Color(-1));
        }
        hoofdmenupanel.repaint();
        hoofdmenupanel.revalidate();


        uitlogbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                naarinlogmenu();
            }
        });
        mastermenubutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                naarmasteraccount();

            }
        });

        if (ismaster == true){
            mastermenubutton.setVisible(true);



        } else {
            mastermenubutton.setVisible(false);
        }


        instellingenbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inlogmenu.naarinstellingen();
            }
        });
        kluisopenenbutton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kluismenuframe();
            }
        });
        meldingenbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inlogmenu.naarmeldingen();
            }
        });
        productenbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inlogmenu.naarbestellingmenu();
            }
        });
    }


    public JPanel getHoofdmenupanel() {
        return hoofdmenupanel;
    }

}
