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
    }

    public JPanel getMasteraccountpanel() {
        return masteraccountpanel;
    }
}
