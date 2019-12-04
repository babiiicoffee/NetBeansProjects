/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql_test_if_slow;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author but-anonju_sd2082
 */
public class Activity_2 {
/*
    THIS IS THE ACTIVITY NUMBER TWO INSERT MYSQL WITHOUT CONNECTION
    */
    public Activity_2() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        System.out.println(
                "Time start : " + dtf.format(now));

        try {

            Statement stmt = null;
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/butanon", "root", "");
            stmt = (Statement) con.createStatement();
            
            for (int i = 0; i < 1001; i++) {
                String sql = "INSERT INTO `withOutConnection`(`ID`, `Column_1`, `Column_2`, `Column_3`, `Column_4`, `Column_5`)"
                        + " VALUES (" + i + "," + i + "," + (i + 1) + "," + (i + 2) + "," + (i + 3) + "," + (i + 4) + ")";
                stmt.executeUpdate(sql);
            }

            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());

        }

        System.out.println(
                "Time end : " + dtf.format(now));
//        System.out.println("Time end : " + sdf.format(d));

    }

    public static void main(String args[]) {
        Activity_2 withOutConnection = new Activity_2();
    }
}
