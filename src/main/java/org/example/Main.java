package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/payroll_service";
            String username = "root";
            String password = "vedant@603";
            con = DriverManager.getConnection(url, username, password);
            System.out.println("The Database Connected Successfully");

        } catch (SQLException e) {
            System.out.println("Error Connecting the database : " +e.getMessage());
        }
        finally {
            try {
                if (con != null) {
                    con.close();
                }
            }
            catch (SQLException e){
                System.out.println("Error while closing the database : " +e.getMessage());
            }
        }
    }
}