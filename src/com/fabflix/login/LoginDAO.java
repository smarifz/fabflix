package com.fabflix.login;

import java.sql.*;

/**
 * Created by arifzaidi on 9/30/16.
 */
public class LoginDAO {
    String username = null;
    String password = null;
    static final String DB_URL = "jdbc:mysql://ec2-54-71-246-24.us-west-2.compute.amazonaws.com:3306/moviedb";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "arif";
    Connection conn = null;

    public LoginDAO(String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.username = username;
        this.password = password;

    }

    public boolean doLogin(){
        try{
            PreparedStatement pst = conn.prepareStatement("Select id from customers where email=? and password=?");
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                return true;
            else
                return false;
        }
        catch(Exception e){
            System.out.println("Something went wrong !! Please try again");
            e.printStackTrace();
        }

        return false;
    }
}
