package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class meldingen {
    private static JFrame frame = new JFrame("DRACA Vision");
    private JPanel meldingenpanel;
    private JButton teruggaan;
    private JLabel bestelgegevens;
    private JLabel bestelgegevens2;
    private JLabel inkluismelding;
    public static boolean bestelnietinkluis;
    public static String inkluismeldingtekst;


    public meldingen() {
        inkluismeldingtekst = "";
        inkluismelding.setText(inkluismeldingtekst);




        try {
            SQLDatabaseConnection.checkbestelling(SQLDatabaseConnection.klantnummer);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            SQLDatabaseConnection.ispakketinkluis(SQLDatabaseConnection.bestelnummer2);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        if (SQLDatabaseConnection.bestelnummer2 != 0) {

                try {
                    SQLDatabaseConnection.meldingenmenu(SQLDatabaseConnection.bestelnummer2);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                if (SQLDatabaseConnection.aantalproduct1 != 0) {
                    bestelgegevens.setText("Er is " + SQLDatabaseConnection.aantalproduct1 + " aantal besteld van product 1.");
                } else {
                    bestelgegevens.setText("");
                }
                if (SQLDatabaseConnection.aantalproduct2 != 0){
                    bestelgegevens2.setText("Er is " + SQLDatabaseConnection.aantalproduct2 + " aantal besteld van product 2.");
                } else {
                    bestelgegevens2.setText("");
                }

            } else {
                bestelgegevens.setText("Er is geen bestelling.");
                bestelgegevens2.setText("");
            }
            inkluismelding.setText(inkluismeldingtekst);


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


