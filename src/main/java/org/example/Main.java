package org.example;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/payroll_service";
            String username = "root";
            String password = "vedant@603";
            con = DriverManager.getConnection(url, username, password);
            System.out.println("The Database Connected Successfully");
            Statement st = con.createStatement();
            st.executeUpdate("update employee_payroll set salary = 3000000.00 where name = 'vedant'");
            ResultSet rs = st.executeQuery("select * from employee_payroll");
            while(rs.next()){
                System.out.println("id : " +rs.getInt(1));
                System.out.println("name : " +rs.getString(2));
                System.out.println("Salary : " +rs.getDouble(3));
                System.out.println("start_date : " +rs.getDate(4));
                System.out.println("Gender : " +rs.getString(5));
                System.out.println("employee_phone : " +rs.getString(6));
                System.out.println("address : " +rs.getString(7));
                System.out.println("department : " +rs.getString(8));
                System.out.println("Basic_pay : " +rs.getInt(9));
                System.out.println("Deduction : " +rs.getInt(10));
                System.out.println("Taxable_Pay : " +rs.getInt(11));
                System.out.println("Income_Tax : " +rs.getInt(12));
                System.out.println("Net_Play : " +rs.getInt(13));
                System.out.println();
            }
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