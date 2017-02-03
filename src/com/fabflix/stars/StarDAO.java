package com.fabflix.stars;

import com.fabflix.beans.Movie;
import com.fabflix.beans.Star;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by arifzaidi on 9/30/16.
 */
public class StarDAO {
    String username = null;
    String password = null;
    static final String DB_URL = "jdbc:mysql://ec2-54-71-246-24.us-west-2.compute.amazonaws.com:3306/moviedb";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "arif";
    Connection conn = null;

    public StarDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }



    public Star getStarInfo(int id) {
        Star star = null;
        try (
                PreparedStatement statement = conn.prepareStatement("select * from stars where id =" + id);
                ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                star = new Star(resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getInt("dob"), resultSet.getInt("id"), resultSet.getString("photo_url"), getMoviesOfStar(id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return star;
    }

    public ArrayList<Movie> getMoviesOfStar(int id){
        ArrayList<Movie> movies = new ArrayList<>();
        try (
                PreparedStatement statement = conn.prepareStatement("SELECT * from movies where id IN (SELECT movie_id FROM stars LEFT JOIN stars_in_movies ON stars.id = stars_in_movies.star_id where stars.id = "+id+");");
                ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                movies.add(new Movie(resultSet.getInt("id"), resultSet.getInt("year"), resultSet.getString("title"), resultSet.getString("director"), resultSet.getString("banner_url"), resultSet.getString("trailer_url"), null, null));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movies;
    }



}
