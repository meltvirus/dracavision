package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class instellingen {
    private JPanel instellingenpanel;
    private JButton darkmodebutton;
    private JLabel uwnummerlabel;
    private JButton homebutton;
    public static boolean darkmode = false;

    public instellingen() {
        if (instellingen.darkmode == true){
            instellingenpanel.setBackground(new Color(0x24242B));
            darkmodebutton.setText("Light mode");

        } else {
            instellingenpanel.setBackground(new Color(-1));
            darkmodebutton.setText("Dark mode");
        }
        instellingenpanel.repaint();
        instellingenpanel.revalidate();


        homebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inlogmenu.naarhoofdmenu();
            }
        });

        /*darkmodebox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
                    //do something...
                    darkmode = true;
                    //inlogmenu.frame.getContentPane().removeAll();

                    //inlogmenu.frame.setContentPane(new instellingen().getInstellingenpanel());
                    instellingenpanel.setBackground(new Color(0x24242B));
                    inlogmenu.frame.repaint();
                    inlogmenu.frame.revalidate();




                } else {
                    darkmode = false;

                    inlogmenu.frame.repaint();
                    inlogmenu.frame.revalidate();
                    instellingenpanel.setBackground(new Color(-1));

                    //checkbox has been deselected
                }



            }
        });*/

        /*if (darkmode){
            //instellingenpanel.setBackground(new Color(0x24242B));
            inlogmenu.frame.getContentPane().removeAll();
            inlogmenu.frame.setContentPane(new instellingen().getInstellingenpanel());
            inlogmenu.frame.repaint();
            inlogmenu.frame.revalidate();
            instellingenpanel.setBackground(new Color(0x24242B));
        } else {
            //instellingenpanel.setBackground(new Color(-1));
            inlogmenu.frame.getContentPane().removeAll();
            inlogmenu.frame.setContentPane(new instellingen().getInstellingenpanel());
            inlogmenu.frame.repaint();
            inlogmenu.frame.revalidate();
            instellingenpanel.setBackground(new Color(-1));


        }*/
        darkmodebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!darkmode){
                    darkmode = true;
                    instellingenpanel.setBackground(new Color(0x24242B));
                    darkmodebutton.setText("Light mode");
                    inlogmenu.frame.repaint();
                    inlogmenu.frame.revalidate();

                } else {
                    darkmode = false;
                    instellingenpanel.setBackground(new Color(-1));
                    darkmodebutton.setText("Dark mode");
                    inlogmenu.frame.repaint();
                    inlogmenu.frame.revalidate();


                }
            }
        });
    }

    public JPanel getInstellingenpanel() {
        return instellingenpanel;
    }
}
