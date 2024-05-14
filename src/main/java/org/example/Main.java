package org.example;

import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/payroll_service";
            String username = "root";
            String password = "vedant@603";
            con = DriverManager.getConnection(url, username, password);
            System.out.println("The Database Connected Successfully");

            String []arr1 = {"Sum_salary","Average_salary","min_salary","Max_salary","count_by_gender"};

            ArrayList<String> arr = new ArrayList<>();
            arr.add("select gender,sum(salary) as Total from employee_payroll where gender = 'male' group by gender ");
            arr.add("select gender,AVG(salary) as Average from employee_payroll where gender = 'male' group by gender");
            arr.add("select name,min(salary) as salary from employee_payroll where salary = (select min(salary) from employee_payroll) group by name");
            arr.add("select name,max(salary) as salary from employee_payroll where salary = (select max(salary) from employee_payroll) group by name");
            arr.add("select gender,count(gender) as count from employee_payroll where gender = 'female' group by gender");


            for (int i = 0; i < arr.size(); i++) {
                PreparedStatement stmt = con.prepareStatement(arr.get(i));
                ResultSet rs = stmt.executeQuery();
                System.out.println("\n_________________________________________________________________________");
                System.out.println("\n\t\tThe Data for " +arr1[i]+ " Statement  ");
                System.out.println("\n_________________________________________________________________________\n");
                while (rs.next()) {
                    if(i == 0 || i == 1 || i == 4){
                        System.out.println("\t\tgender : " + rs.getString(1));
                        System.out.println( "\t\t"+arr1[i]+ " : " + rs.getDouble(2));
                    }
                    else{
                        System.out.println("\t\tname : " + rs.getString(1));
                        System.out.println( "\t\t"+arr1[i]+ " : " + rs.getDouble(2));
                    }


//                    System.out.println("Salary : " + rs.getDouble(3));
//                    System.out.println("start_date : " + rs.getDate(4));
//                    System.out.println("Gender : " + rs.getString(5));
//                    System.out.println("employee_phone : " + rs.getString(6));
//                    System.out.println("address : " + rs.getString(7));
//                    System.out.println("department : " + rs.getString(8));
//                    System.out.println("Basic_pay : " + rs.getInt(9));
//                    System.out.println("Deduction : " + rs.getInt(10));
//                    System.out.println("Taxable_Pay : " + rs.getInt(11));
//                    System.out.println("Income_Tax : " + rs.getInt(12));
//                    System.out.println("Net_Play : " + rs.getInt(13));
                    System.out.println();
                }
            }
        }
        catch(SQLException e){
                System.out.println("Error Connecting the database : " + e.getMessage());
            }
        finally{
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    System.out.println("Error while closing the database : " + e.getMessage());
                }
            }

    }
}