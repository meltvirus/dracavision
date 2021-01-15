package menu;
import javax.swing.*;
import java.io.FileInputStream;
import java.sql.*;
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
    public static int openbestellingen;
    public static void dracadbinlog(String sqlvariabele) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dracabase?allowPublicKeyRetrieval=true&useSSL=false", "dracavision", "dracavision");

            // 2. Create a statement
            myStmt = myConn.createStatement();

            // 3. Execute SQL query
            myRs = myStmt.executeQuery("select email, wachtwoord, masteracc, werknemer from klant where email = \"" + sqlvariabele + "\"");

            // 4. Process the result set
            while (myRs.next()) {
                //System.out.println(myRs.getString("email") + ", " + myRs.getString("wachtwoord"));
                combinatie = /*myRs.getString("email") + ", " + */myRs.getString("wachtwoord");
                masteracc = myRs.getBoolean("masteracc");
                werknemer = myRs.getBoolean("werknemer");



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

            myRs = myStmt.executeQuery("select bestelnummer from bestelling where geleverd = 0");

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

    public static void verstuurkluisnr(int nr, int bestelnr) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dracabase?allowPublicKeyRetrieval=true&useSSL=false", "dracavision", "dracavision");

            myStmt = myConn.createStatement();

            //myRs = myStmt.executeQuery("select bestelnummer, geleverd, kluisnr from bestelling where bestelnummer = \"" + nr+"\"");

            myStmt.executeUpdate("update bestelling set geleverd = 1,kluisnr = \'"+nr+ "\' where bestelnummer = \""+bestelnr+"\"");

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

}

