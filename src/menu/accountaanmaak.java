package menu;

import menu.inlogmenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static menu.inlogmenu.naarinlogmenu;

public class accountaanmaak {
    private JPanel accountpanel;
    private JButton homebutton;
    private JButton accountaanmaak;
    private JLabel uwnummerlabel;
    private JTextField naamfield;
    private JTextField adresfield;
    private JTextField woonplaatsfield;
    private JTextField emailfield;
    private JTextField wachtwoordfield;
    private JTextField wachtwoordfield2;
    private JLabel foutmeldingaanmaak;
    private JButton noOpButton;

    private String naam =null;
    private String adres=null;
    private String woonplaats=null;
    private String email=null;
    private String wachtwoord=null;
    private String wachtwoord2=null;

    public accountaanmaak() {
        foutmeldingaanmaak.setText("");
        homebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inlogmenu.naarinlogmenu();
            }
        });
        accountaanmaak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                naam = naamfield.getText();
                adres = adresfield.getText();
                woonplaats = woonplaatsfield.getText();
                email = emailfield.getText();
                wachtwoord = wachtwoordfield.getText();
                wachtwoord2 = wachtwoordfield2.getText();
                if (naam.equals("") || adres.equals("") || woonplaats.equals("") || email.equals("") || wachtwoord.equals("") || wachtwoord2.equals("") || !wachtwoord.equals(wachtwoord2) || email.indexOf(' ')!=-1 || wachtwoord.indexOf(' ')!=-1 || email.indexOf('@')==-1){
                    foutmeldingaanmaak.setText("Er is iets fout gegaan! Vul alles in.");
                } else {
                    try {
                        SQLDatabaseConnection.accountaanmaakdb(naam, adres, woonplaats, email, wachtwoord);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    accountaanmakenlog();
                    if (SQLDatabaseConnection.accountbestaat == false) {
                        naam = null;
                        adres = null;
                        woonplaats = null;
                        email = null;
                        wachtwoord = null;
                        wachtwoord2 = null;
                        inlogmenu.naarinlogmenu();
                    } else {
                        foutmeldingaanmaak.setText("Account met deze e-mail bestaat al.");
                    }
                }
            }
        });


    }

    public JPanel getAccountpanel() {
        return accountpanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public void accountaanmakenlog(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime tijdnu = LocalDateTime.now();
        try(FileWriter fw = new FileWriter("resources/accountaanmaak.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.printf("["+dtf.format(tijdnu)+"]");
            out.println(String.format(" %s", email));

        } catch (java.io.IOException e){
            System.out.println(e);
        }
    }
}
