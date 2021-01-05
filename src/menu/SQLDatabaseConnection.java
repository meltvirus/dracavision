package menu;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class SQLDatabaseConnection {
    // snippet MySQL - step 1: opening and closing connection to MySQL server
    public static String combinatie;
    public static boolean accountbestaat = false;
    //public static String sqlvariabele;
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
            myRs = myStmt.executeQuery("select email, wachtwoord from klant where email = \"" + sqlvariabele + "\"");

            // 4. Process the result set
            while (myRs.next()) {
                //System.out.println(myRs.getString("email") + ", " + myRs.getString("wachtwoord"));
                combinatie = /*myRs.getString("email") + ", " + */myRs.getString("wachtwoord");

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


}

