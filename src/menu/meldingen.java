package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class meldingen {
    private static JFrame frame = new JFrame("DRACA Vision");
    private JPanel meldingenpanel;
    private JButton teruggaan;


    public meldingen() {

        if (instellingen.darkmode == true){
            meldingenpanel.setBackground(new Color(0x24242B));

        } else {
            meldingenpanel.setBackground(new Color(-1));
        }
        meldingenpanel.repaint();
        meldingenpanel.revalidate();
        teruggaan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inlogmenu.naarhoofdmenu();
            }
        });
    }

    /*public static void main(String[] args) {

        frame.setContentPane(new meldingen().meldingenpanel);
        frame.setSize(504,896);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);



    }*/
    /*public static void naarhoofdmenu() {
        frame.getContentPane().removeAll();
        frame.setContentPane(new meldingen().meldingenpanel);
        frame.repaint();
        frame.revalidate();
    }*/

    public JPanel getMeldingenpanel(){
        return meldingenpanel;
    }
}


