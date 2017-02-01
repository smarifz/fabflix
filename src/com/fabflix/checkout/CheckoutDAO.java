package com.fabflix.checkout;

import com.fabflix.beans.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arifzaidi on 9/30/16.
 */
public class CheckoutDAO {
    String username = null;
    String password = null;
    static final String DB_URL = "jdbc:mysql://ec2-54-71-246-24.us-west-2.compute.amazonaws.com:3306/moviedb";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "arif";
    Connection conn = null;

    public CheckoutDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Boolean verifyCustomerExists(String fname, String lname, String cc, String exp) {
        List<Movie> movies = new ArrayList<Movie>();
        String query = "select * from creditcards where first_name='" + fname + "' and last_name='" + lname + "' and id='" + cc + "' and expiration='" + exp + "';";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<Integer> createSale(String movie_id, String fname, String lname, List<String> ids) {
        String query_customerId = "select * from customers where first_name='" + fname + "' and last_name='" + lname + "';";
        ArrayList<Integer> saleIds = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement(query_customerId);
            ResultSet resultSet = statement.executeQuery();
            int customerId = 0;
            if (resultSet.next())
               customerId= resultSet.getInt("id");

            for(int i =0; i<ids.size(); i++) {
                String query_sales = "insert into sales (id, customer_id, movie_id, sale_date) values (0,'" + customerId + "','" + ids.get(i) + "',CURDATE());";
                PreparedStatement statement2 = conn.prepareStatement(query_customerId);
                statement2.executeUpdate(query_sales, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = statement2.getGeneratedKeys();
                if (rs.next()) {
                    saleIds.add(rs.getInt(1));
                }
            }

            return saleIds;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


}
