package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;


public class kluismenu {
    private JPanel kluispanel;
    private JLabel uwnummerlabel;
    public JLabel kluisnummer;
    private JButton openkluis;
    public JLabel kluisstatus;
    private JButton homebutton;
    public JLabel foutmelding;


    public kluismenu() {
        foutmelding.setText("");



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
                //System.out.println("Open kluis");
                //kluisstatus.setText("Kluis geopend!");
                try {
                    SQLDatabaseConnection.openkluis(SQLDatabaseConnection.klantnummer);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                foutmelding.setText(SQLDatabaseConnection.foutmeldingtekst);
                // HIER DE MICROBIT CODE (SWITCH STATEMENT LIJKT ME HANDIG)
                // (INT)
                //lm het werkt al soort van nu, alleen de window pop up van microbit is irritant

                if (!hoofdmenu.getal.equals("Nog niets")) {

                    try {
                        writenaarmicro();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                    try {
                        writelegenaarmicro();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                    foutmelding.setText("Bestelling is opgehaald in kluis "+hoofdmenu.getal+".");
                    hoofdmenu.getal = "Nog niets";
                    kluisnummer.setText(hoofdmenu.getal);
                } else {
                    /*try {
                        writelegenaarmicro();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }*/

                }


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



    public static void writenaarmicro() throws InterruptedException, IOException {
        File source = new File("resources/microbitkluis"+hoofdmenu.getal+".hex");
        File dest = new File("D:/microbit.hex");

        //copy file conventional way using Stream
        long start = System.nanoTime();
        copyFileUsingStream(source, dest);
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    public static void writelegenaarmicro() throws InterruptedException, IOException {
        File source = new File("resources/leeg.hex");
        File dest = new File("D:/microbit.hex");
        long start = System.nanoTime();
        copyFileUsingStream(source, dest);
    }


}
