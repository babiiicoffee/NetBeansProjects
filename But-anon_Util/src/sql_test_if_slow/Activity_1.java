/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql_test_if_slow;

//import bigdata.Activity_3;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author but-anonju_sd2082
 */
public class Activity_1 {

    public Activity_1() {

//        Date d = new java.util.Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("hh:MM:ss a");
//        System.out.println("Time start : " + sdf.format(d));

//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println("Time start : " + dtf.format(now));

        Date date = new Date();
        
        long start = date.getTime();

        for (int i = 0; i < 1001; i++) {
            try {

                Statement stmt = null;
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/butanon", "root", "");
                stmt = (Statement) con.createStatement();
                String sql = "INSERT INTO `withConnection`(`ID`, `Column_1`, `Column_2`, `Column_3`, `Column_4`, `Column_5`)"
                        + " VALUES (" + i + "," + i + "," + (i + 1) + "," + (i + 2) + "," + (i + 3) + "," + (i + 4) + ")";

                stmt.executeUpdate(sql);
                con.close();

            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
    
            }
        }
        
        long end = date.getTime();
        
        long time = start - end;
        System.out.println(time);
        
//        System.out.println("Time end : " + dtf.format(now));
//        System.out.println("Time end : " + sdf.format(d));
        
    }

    public static void main(String args[]) {
        Activity_1 withConnection = new Activity_1();
    }

}
