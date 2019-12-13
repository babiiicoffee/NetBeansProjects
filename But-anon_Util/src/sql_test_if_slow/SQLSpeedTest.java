/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql_test_if_slow;

//import bigdata.Activity_3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author but-anonju_sd2082
 */
public class SQLSpeedTest {

    /*
    
     */

 /*
    THIS IS THE ACTIVITY NUMBER TWO INSERT MYSQL WITHOUT CONNECTION
     */
 /*
    THIS IS ACTIVITY NUMBER 3 DELETE ONE-BY-ONE WITH CONNECTION
     */
 /*
    THIS IS ACTIVITY NUMBER 3 DELETE ONE-BY-ONE WITHOUT CONNECTION
     */
 /*
        THIS IS ACTIVITY NUMBER 6 RETRIECVE/GET GET AVERAGE PER COLUMN USING JAVA WITHOUT CONNECTION
     */
 /*
    THIS IS ACTIVITY NUMBER 6 RETRIECVE/GET GET AVERAGE PER COLUMN USING INTERNAL FUNCTION WITHOUT CONNECTION
     */
    public void Activity_1() {

        long start = new Date().getTime() / 1000;

        for (int i = 0; i < 1001; i++) {
            try {
                Statement stmt = null;
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/butanon", "root", "");
                stmt = (Statement) con.createStatement();
                String sql = "INSERT INTO `sqlSpeedTest`(`Column_1`, `Column_2`, `Column_3`, `Column_4`, `Column_5`)"
                        + " VALUES (" + i + "," + (i + 1) + "," + (i + 2) + "," + (i + 3) + "," + (i + 4) + ")";

                stmt.executeUpdate(sql);
                con.close();

            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        }

        long end = new Date().getTime() / 1000;

        long time = end - start;
        System.out.println("Time : " + time);
    }

    public void Activity_2() {
        try {

            Statement stmt = null;
            Class.forName("com.mysql.jdbc.Driver");
            long start = new Date().getTime() / 1000;
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/butanon", "root", "");
            stmt = (Statement) con.createStatement();

            for (int i = 0; i < 301; i++) {
                String sql = "INSERT INTO `sqlSpeedTest`( `Column_1`, `Column_2`, `Column_3`, `Column_4`, `Column_5`)"
                        + " VALUES (" + i + "," + (i + 1) + "," + (i + 2) + "," + (i + 3) + "," + (i + 4) + ")";
                stmt.executeUpdate(sql);
            }

            long end = new Date().getTime() / 1000;
            long time = end - start;
            System.out.println("Time :" + time);
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public void Activity_3() {
        try {
            long start = new Date().getTime() / 1000;
//            BUGO
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/butanon", "root", "");

            for (int i = 1000; i > 0; i--) {
                String delete = "DELETE FROM sqlSpeedTest WHERE Column_1 = ?";
                PreparedStatement stmt = con.prepareStatement(delete);
                stmt.setInt(1, i);

            }
            long end = new Date().getTime() / 1000;
            con.close();
            long time = end - start;
            System.out.println("Time : " + time);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void Activity_4() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            long start = new Date().getTime() / 1000;

            for (int i = 300; i > 0; i--) {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/butanon", "root", "");
                String delete = "DELETE FROM sqlSpeedTest WHERE Column_1 = ?";
                PreparedStatement ps = con.prepareStatement(delete);
                ps.setInt(1, i);

                con.close();
            }

            long end = new Date().getTime() / 1000;
            long time = end - start;
            System.out.println("Time : " + time);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLSpeedTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Activity_5() {
        try {
            long start = new Date().getTime();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/butanon", "root", "");
            String query = "SELECT * FROM sqlSpeedTest";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            int avgColumn_1 = 0;
            int avgColumn_2 = 0;
            int avgColumn_3 = 0;
            int avgColumn_4 = 0;
            int avgColumn_5 = 0;

            while (rs.next()) {
                avgColumn_1 += rs.getInt("Column_1");
                avgColumn_2 += rs.getInt("Column_2");
                avgColumn_3 += rs.getInt("Column_3");
                avgColumn_4 += rs.getInt("Column_4");
                avgColumn_5 += rs.getInt("Column_5");
            }

            System.out.println("Average of Column_1 : " + avgColumn_1 / 1000);
            System.out.println("Average of Column_2 : " + avgColumn_2 / 1000);
            System.out.println("Average of Column_3 : " + avgColumn_3 / 1000);
            System.out.println("Average of Column_4 : " + avgColumn_4 / 1000);
            System.out.println("Average of Column_5 : " + avgColumn_5 / 1000);

            long end = new Date().getTime();
            long time = end - start;
            System.out.println("Time : " + time);
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void Activity_6() {
        try {
            long start = new Date().getTime();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/butanon", "root", "");
            String query = "SELECT * FROM sqlSpeedTest AVG(`Column_1`) AS Column_1, AVG(`Column_2`) AS Column_2, AVG(`Column_3`) AS Column_3, AVG(`Column_4`) AS Column_4, AVG(`Column_5`) AS Column_5";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            int avgColumn_1 = 0;
            int avgColumn_2 = 0;
            int avgColumn_3 = 0;
            int avgColumn_4 = 0;
            int avgColumn_5 = 0;
            while (rs.next()) {
                avgColumn_1 += rs.getInt("Column_2");
                avgColumn_2 += rs.getInt("Column_4");
                avgColumn_3 += rs.getInt("Column_6");
                avgColumn_4 += rs.getInt("Column_8");
                avgColumn_5 += rs.getInt("Column_10");
            }
            System.out.println("Average of Column_1 : " + avgColumn_1 / 1000);
            System.out.println("Average of Column_2 : " + avgColumn_2 / 1000);
            System.out.println("Average of Column_3 : " + avgColumn_3 / 1000);
            System.out.println("Average of Column_4 : " + avgColumn_4 / 1000);
            System.out.println("Average of Column_5 : " + avgColumn_5 / 1000);

            long end = new Date().getTime();
            long time = end - start;
            System.out.println("Time : " + time);
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String args[]) {
        
        SQLSpeedTest act = new SQLSpeedTest();
        act.Activity_1(); // INSERT 1000
        act.Activity_3(); // DELETE 1000
        act.Activity_2(); // INSERT 300
        act.Activity_4(); // DELETE 300
//        act.Activity_5();
//        act.Activity_6();
    }
// IF IPA RUN ANG 5 UG 6, I COMMENT ANG 324 KASABOT KA? CAPSLOCK NA JUD NA HA? SHARUG BUGO PA JUD KA
}
