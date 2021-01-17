package menu;
import javax.swing.*;
import java.io.FileInputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class SQLDatabaseConnection {

    // snippet MySQL - step 1: opening and closing connection to MySQL server
    public static String combinatie;
    public static boolean accountbestaat = false;
    //public static String sqlvariabele;
    public static boolean werknemer = false;
    public static boolean masteracc = false;
    public static int klantnummer;
    public static int openbestellingen;
    public static int bestelnr;
    public static boolean albestellingonderweg;
    public static String foutmeldingtekst;

    public static void dracadbinlog(String sqlvariabele) throws SQLException {
        klantnummer = 0;
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dracabase?allowPublicKeyRetrieval=true&useSSL=false", "dracavision", "dracavision");

            // 2. Create a statement
            myStmt = myConn.createStatement();

            // 3. Execute SQL query
            myRs = myStmt.executeQuery("select email, wachtwoord, masteracc, werknemer, klantcode from klant where email = \"" + sqlvariabele + "\"");

            // 4. Process the result set
            while (myRs.next()) {
                //System.out.println(myRs.getString("email") + ", " + myRs.getString("wachtwoord"));
                combinatie = /*myRs.getString("email") + ", " + */myRs.getString("wachtwoord");
                masteracc = myRs.getBoolean("masteracc");
                werknemer = myRs.getBoolean("werknemer");
                klantnummer = myRs.getInt("klantcode");



            }
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
    }

    //#
    //#
    public static void accountaanmaakdb(String naam, String adres, String woonplaats, String email, String wachtwoord) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dracabase?allowPublicKeyRetrieval=true&useSSL=false", "dracavision", "dracavision");

            myStmt = myConn.createStatement();

            //myStmt.executeUpdate("Insert into klant (naam, adres, woonplaats, loonstrook, email, wachtwoord) Values (\'"+naam+"\', \'"+adres+"\', \'"+woonplaats+"\', 0, \'"+email+"\', \'"+wachtwoord+"\');");

            /* test volgt*/
            myRs = myStmt.executeQuery("select email from klant where email = \"" + email + "\"");
            if (myRs.next() == true){

                accountbestaat = true;

            } else {
                accountbestaat = false;
                myStmt.executeUpdate("Insert into klant (naam, adres, woonplaats, loonstrook, email, wachtwoord) Values (\'"+naam+"\', \'"+adres+"\', \'"+woonplaats+"\', 0, \'"+email+"\', \'"+wachtwoord+"\');");
            }
            /*test einde*/


        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
    }

    public static List<String> where = new ArrayList<String>();


    public static void bestellingconnectie() throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            where.clear();
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dracabase?allowPublicKeyRetrieval=true&useSSL=false", "dracavision", "dracavision");

            // 2. Create a statement
            myStmt = myConn.createStatement();

            // 3. Execute SQL query
            /*myRs = myStmt.executeQuery("select count(bestelnummer) from bestelling where geleverd = 0");
            while (myRs.next()) {
                int[] arrayresult = new int[myRs.getInt("count(bestelnummer)")];
            }*/
            ArrayList<Integer> openbestellingenarr = new ArrayList<Integer>();

            myRs = myStmt.executeQuery("select bestelnummer from bestelling where geleverd = 0 && inkluis = 0");

            // 4. Process the result set
            while (myRs.next()) {

                //openbestellingen = myRs.getInt("bestelnummer");
                where.add(myRs.getString("bestelnummer"));


            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
    }

    public static boolean isalinkluis;

    public static void verstuurkluisnr(int nr, int bestelnr) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dracabase?allowPublicKeyRetrieval=true&useSSL=false", "dracavision", "dracavision");

            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery("select kluisnr from bestelling where inkluis = 1 && kluisnr = \'"+nr+"\'");

            if (myRs.next()){
                isalinkluis = true;
                System.out.println("ligt al iets in deze kluis, maak pop up");
            } else {
                isalinkluis = false;


                myStmt.executeUpdate("update bestelling set kluisnr = \'" + nr + "\', inkluis = 1 where bestelnummer = \"" + bestelnr + "\"");
            }
            /*while (myRs.next()) {

                where.add(myRs.getString("bestelnummer"));

            }*/
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }
            if (myStmt != null) {
                myStmt.close();
            }
            if (myConn != null) {
                myConn.close();
            }
        }
    }

    public static void plaatsbestelling(int klantnr, int product1, int product2) throws SQLException {
        /*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd"); //HH:mm:ss
        LocalDateTime tijdnu = LocalDateTime.now();*/

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dracabase?allowPublicKeyRetrieval=true&useSSL=false", "dracavision", "dracavision");

            myStmt = myConn.createStatement();

            //myRs = myStmt.executeQuery("select bestelnummer, geleverd, kluisnr from bestelling where bestelnummer = \"" + nr+"\"");

            myStmt.executeUpdate("insert into bestelling (klantcode) Values ('"+klantnr+"')");
//("Insert into klant (naam, adres, woonplaats, loonstrook, email, wachtwoord) Values (\'"+naam+"\', \'"+adres+"\', \'"+woonplaats+"\', 0, \'"+email+"\', \'"+wachtwoord+"\');");

            myRs = myStmt.executeQuery("select bestelnummer from bestelling where klantcode = \'" +klantnr +"\' order by bestelnummer asc");
            while (myRs.next()) {
                bestelnr = myRs.getInt("bestelnummer");
            }

            //myRs = null;

            myStmt.executeUpdate("insert into bestelregel (productcode, bestelnummer, aantal) values (1, \'"+bestelnr+"\', \'"+product1+"\')");
            myStmt.executeUpdate("insert into bestelregel (productcode, bestelnummer, aantal) values (2, \'"+bestelnr+"\', \'"+product2+"\')");

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }
            if (myStmt != null) {
                myStmt.close();
            }
            if (myConn != null) {
                myConn.close();
            }
        }
    }

    public static int bestelnummer2 = 0;


    public static void checkbestelling(int klantnr) throws SQLException {
        bestelnummer2 = 0;

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dracabase?allowPublicKeyRetrieval=true&useSSL=false", "dracavision", "dracavision");

            myStmt = myConn.createStatement();

            //myRs = myStmt.executeQuery("select bestelnummer, geleverd, kluisnr from bestelling where bestelnummer = \"" + nr+"\"");

            myRs = myStmt.executeQuery("select bestelnummer from bestelling where klantcode = \'" +klantnr +"\' && ( geleverd = 0)");
            if (myRs.next()) {
                albestellingonderweg = true;
                bestelnummer2 = myRs.getInt("bestelnummer");

            } else {
                bestelnummer2 = 0;
                albestellingonderweg = false;
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }
            if (myStmt != null) {
                myStmt.close();
            }
            if (myConn != null) {
                myConn.close();
            }
        }
    }


    public static void getkluisnummer(int klantnr) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dracabase?allowPublicKeyRetrieval=true&useSSL=false", "dracavision", "dracavision");

            myStmt = myConn.createStatement();

            //myRs = myStmt.executeQuery("select bestelnummer, geleverd, kluisnr from bestelling where bestelnummer = \"" + nr+"\"");

            myRs = myStmt.executeQuery("select bestelnummer, kluisnr from bestelling where klantcode = \'" +klantnr +"\' && geleverd = 0 && inkluis = 1");

            if (myRs.next()){

                //while (myRs.next()) {
                    //System.out.println(myRs.getString("email") + ", " + myRs.getString("wachtwoord"));
                    //combinatie = /*myRs.getString("email") + ", " + */myRs.getString("wachtwoord");
                    hoofdmenu.getal = myRs.getString("kluisnr");
                    bestelnr = myRs.getInt("bestelnummer");

                //}


            } else {
                hoofdmenu.getal = "Nog niets";
                //System.out.println("Er is nog geen bestelling gereed of geplaatst.");
            }


        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }
            if (myStmt != null) {
                myStmt.close();
            }
            if (myConn != null) {
                myConn.close();
            }
        }
    }

    public static void openkluis(int klantnr) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dracabase?allowPublicKeyRetrieval=true&useSSL=false", "dracavision", "dracavision");

            myStmt = myConn.createStatement();

            //myRs = myStmt.executeQuery("select bestelnummer, geleverd, kluisnr from bestelling where bestelnummer = \"" + nr+"\"");

            myRs = myStmt.executeQuery("select bestelnummer, kluisnr from bestelling where klantcode = \'" +klantnr +"\' && geleverd = 0 && inkluis = 1");

            if (myRs.next()){

                while (myRs.next()) {
                    //System.out.println(myRs.getString("email") + ", " + myRs.getString("wachtwoord"));
                    //combinatie = /*myRs.getString("email") + ", " + */myRs.getString("wachtwoord");
                    hoofdmenu.getal = myRs.getString("kluisnr");
                    bestelnr = myRs.getInt("bestelnummer");

                }

                myStmt.executeUpdate("update bestelling set geleverd = 1, inkluis = 0 where bestelnummer = \"" + bestelnr + "\"");

                foutmeldingtekst = "De kluis is geopend";


            } else {
                //System.out.println("Er is nog geen bestelling gereed of geplaatst.");
                foutmeldingtekst = "Er is nog geen bestelling gereed";
            }


        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }
            if (myStmt != null) {
                myStmt.close();
            }
            if (myConn != null) {
                myConn.close();
            }
        }
    }

    public static int aantalproduct1 = 0;
    public static int aantalproduct2 = 0;
    public static boolean isinkluis;


    public static void meldingenmenu(int bestelnummertje) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {

            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dracabase?allowPublicKeyRetrieval=true&useSSL=false", "dracavision", "dracavision");

            // 2. Create a statement
            myStmt = myConn.createStatement();

            // 3. Execute SQL query

            myRs = myStmt.executeQuery("SELECT bg.bestelnummer, bl.productcode, bl.aantal, bg.inkluis FROM bestelregel bl join bestelling bg on bg.bestelnummer = bl.bestelnummer where bl.productcode = 1 && bg.bestelnummer = "+bestelnummertje+";");

            // 4. Process the result set
            //if (myRs.getInt("inkluis") == 1){
            while (myRs.next()) {
                aantalproduct1 = myRs.getInt("aantal");

                //openbestellingen = myRs.getInt("bestelnummer");
            }
            //} else {
            //    meldingen.bestelnietinkluis = true;
            //}
            myRs = myStmt.executeQuery("SELECT bg.bestelnummer, bl.productcode, bl.aantal, bg.inkluis FROM bestelregel bl join bestelling bg on bg.bestelnummer = bl.bestelnummer where bl.productcode = 2 && bg.bestelnummer = "+bestelnummertje+";");

            // 4. Process the result set

            while (myRs.next()) {
                aantalproduct2 = myRs.getInt("aantal");

                //openbestellingen = myRs.getInt("bestelnummer");
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
    }
    public static void ispakketinkluis(int bestelnummertje) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {

            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dracabase?allowPublicKeyRetrieval=true&useSSL=false", "dracavision", "dracavision");

            // 2. Create a statement
            myStmt = myConn.createStatement();

            // 3. Execute SQL query

            myRs = myStmt.executeQuery("SELECT bestelnummer, inkluis from bestelling where bestelnummer = "+bestelnummertje+";");

            while (myRs.next()) {
            if (myRs.getInt("inkluis") ==1){
                meldingen.inkluismeldingtekst = "Het pakket is klaar in de kluis";
            } else {
                meldingen.inkluismeldingtekst = "";
            }

            }


        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
    }






}

