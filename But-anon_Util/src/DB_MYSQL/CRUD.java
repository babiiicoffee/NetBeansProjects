/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_MYSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author but-anonju_sd2022
 */
public class CRUD {

    

    public Connection connectToDB() {
        try {
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://172.16.3.17/zjudilyn";
            Class.forName(myDriver);
            Connection connection = DriverManager.getConnection(myUrl, "root", "");
            return connection;
        } catch (Exception e) {
            System.err.println("An error occur!");
            System.err.println(e.getMessage());
            return null;
        }
    }

    public boolean addData(String sqlString) {
        System.out.println(sqlString);
        try {
            Connection connection = connectToDB();
            java.sql.Statement statement = connection.createStatement();
            statement.executeUpdate(sqlString);
            connection.close();
            return true;
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            return false;
        }
    }

    public ResultSet getData(String query) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = connectToDB();
            java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            con.close();
            return rs;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}