package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class masteraccount {
    private JPanel masteraccountpanel;
    private JLabel uwnummerlabel;
    private JButton homebutton;
    private JButton openkluis;
    private JComboBox comboBox4;
    private JButton terugbutton1;
    private Object kluisnummertje;
    private static String kluisnr;
    private static int kluisnrint;


    //return getnaarhoofdmenu()

    public masteraccount() {
        comboBox4.addItem("");
        comboBox4.addItem("1");
        comboBox4.addItem("2");
        comboBox4.addItem("3");
        comboBox4.addItem("4");

        if (instellingen.darkmode == true){
            masteraccountpanel.setBackground(new Color(0x24242B));

        } else {
            masteraccountpanel.setBackground(new Color(-1));
        }
        masteraccountpanel.repaint();
        masteraccountpanel.revalidate();

        homebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inlogmenu.naarhoofdmenu();
            }
        });
        openkluis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kluisnummertje = comboBox4.getSelectedItem();

                kluisnr = (String) kluisnummertje;
                if (!kluisnummertje.equals("")) {
                    kluisnrint = Integer.parseInt(kluisnr);
                }

                switch (kluisnrint){
                    case 1:
                        System.out.println("open hier kluis 1 met microbit");
                        break;
                    case 2:
                        System.out.println("open hier kluis 2");
                        break;
                    case 3:
                        System.out.println("open hier kluis 3");
                        break;
                    case 4:
                        System.out.println("open hier kluis 4");
                        break;
                    default:
                }
            }
        });
    }

    public JPanel getMasteraccountpanel() {
        return masteraccountpanel;
    }
}
