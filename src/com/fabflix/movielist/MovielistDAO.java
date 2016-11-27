package com.fabflix.movielist;

import com.fabflix.beans.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arifzaidi on 9/30/16.
 */
public class MovielistDAO {
    String username = null;
    String password = null;
    static final String DB_URL = "jdbc:mysql://ec2-54-71-246-24.us-west-2.compute.amazonaws.com:3306/moviedb";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "arif";
    Connection conn = null;

    public MovielistDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public List<Movie> executeSearchByGenre() {
        List<Movie> movies = new ArrayList<Movie>();

        try (
                PreparedStatement statement = conn.prepareStatement("SELECT * FROM movies");
                ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                Movie movie = new Movie(resultSet.getInt("id"), resultSet.getInt("year"), resultSet.getString("title"), resultSet.getString("director"), null, null);
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movies;

    }



}
