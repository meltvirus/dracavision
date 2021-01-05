package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class masteraccount {
    private JPanel masteraccountpanel;
    private JTextField openKluisTextField;
    private JTextField testbestellingtextField2;
    private JLabel masterLabel;
    private JButton terugbutton1;


    //return getnaarhoofdmenu()

    public masteraccount() {

        if (instellingen.darkmode == true){
            masteraccountpanel.setBackground(new Color(0x24242B));

        } else {
            masteraccountpanel.setBackground(new Color(-1));
        }
        masteraccountpanel.repaint();
        masteraccountpanel.revalidate();

        terugbutton1.addActionListener(new ActionListener() {
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
