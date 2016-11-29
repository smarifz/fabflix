package com.fabflix.search;

import com.fabflix.beans.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arifzaidi on 9/30/16.
 */
public class SearchDAO {
    String username = null;
    String password = null;
    static final String DB_URL = "jdbc:mysql://ec2-54-71-246-24.us-west-2.compute.amazonaws.com:3306/moviedb";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "arif";
    Connection conn = null;

    public SearchDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public List executeSearch(String title, int year, String director, String fname, String lname) {
        List<Movie> movies = new ArrayList<Movie>();
        String query = formatQueryString(title, year, director, fname, lname);

        try {
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Movie movie = new Movie(rs.getInt("id"), rs.getInt("year"), rs.getString("title"), rs.getString("director"), rs.getString("banner_url"), rs.getString("trailer_url"), null, null);
                movies.add(movie);
            }

        } catch (Exception e) {
            System.out.println("Something went wrong !! Please try again");
            e.printStackTrace();
        }

        return movies;
    }

    public String formatQueryString(String title, int year, String director, String first_name, String last_name) {

        String query = "SELECT * FROM movies LEFT JOIN stars_in_movies ON movies.id = stars_in_movies.movie_id LEFT JOIN stars ON stars_in_movies.star_id = stars.id WHERE true=true ";

        if (!title.isEmpty()) {
            query = query.concat("AND movies.title LIKE \"%" + title + "%\"");
        }

        if (year > 0) {
            query = query.concat("AND movies.year LIKE \"%" + year + "%\"");
        }

        if (!director.isEmpty()) {
            query = query.concat("AND movies.director LIKE \"%" + director+ "%\"");
        }

        if (!first_name.isEmpty()) {
            query = query.concat("AND stars.first_name LIKE \"%" + first_name+ "%\"");
        }

        if (!last_name.isEmpty()) {
            query = query.concat("AND stars.last_name LIKE \"%" + last_name+ "%\"");
        }

        return query;
    }


}
