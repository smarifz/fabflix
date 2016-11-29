package com.fabflix.movielist;

import com.fabflix.beans.Genre;
import com.fabflix.beans.Movie;
import com.fabflix.beans.Star;

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


    public List<Genre> getGenresList() {
        List<Genre> genres = new ArrayList<Genre>();

        try (
                PreparedStatement statement = conn.prepareStatement("select * from genres");
                ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                Genre genre = new Genre(resultSet.getInt("id"), resultSet.getString("name"));
                genres.add(genre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return genres;
    }

    public List<Movie> executeSearchByGenre(String genre) {
        List<Movie> movies = new ArrayList<Movie>();

        try (
                PreparedStatement statement = conn.prepareStatement("select * from movies where id IN ( select movie_id from genres_in_movies where genre_id IN (select id from genres where ID = " + genre + ")) ");
                ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                Movie movie = new Movie(resultSet.getInt("id"), resultSet.getInt("year"), resultSet.getString("title"), resultSet.getString("director"), resultSet.getString("banner_url"), resultSet.getString("trailer_url"), getStars(resultSet.getInt("id")), getGenres(resultSet.getInt("id")));
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movies;

    }

    public List<Movie> executeSearchByTitle(String title) {
        List<Movie> movies = new ArrayList<Movie>();

        try (
                PreparedStatement statement = conn.prepareStatement("select * from movies where title like  \'%" + title + "%\'");
                ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                Movie movie = new Movie(resultSet.getInt("id"), resultSet.getInt("year"), resultSet.getString("title"), resultSet.getString("director"), resultSet.getString("banner_url"), resultSet.getString("trailer_url"), getStars(resultSet.getInt("id")), getGenres(resultSet.getInt("id")));
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movies;

    }


    public Movie getMovie(int id) {
        Movie movie = null;
        try (
                PreparedStatement statement = conn.prepareStatement("select * from movies where id =" + id);
                ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                movie = new Movie(resultSet.getInt("id"), resultSet.getInt("year"), resultSet.getString("title"), resultSet.getString("director"), resultSet.getString("banner_url"), resultSet.getString("trailer_url"), getStars(id), getGenres(id));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movie;

    }

    public List<Star> getStars(int movieId) {
        List<Star> stars = new ArrayList<Star>();
        try (
                PreparedStatement statement = conn.prepareStatement("select * from stars where id IN (select star_id from stars_in_movies where movie_id =" + movieId + ")");
                ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                stars.add(new Star(resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getInt("dob"), resultSet.getInt("id"), resultSet.getString("photo_url")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stars;
    }

    public List<Genre> getGenres(int movieId) {
        List<Genre> genres = new ArrayList<Genre>();
        try (
                PreparedStatement statement = conn.prepareStatement("select * from genres where id IN(select genre_id from genres_in_movies where movie_id="+movieId+")");
                ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                genres.add(new Genre(resultSet.getInt("id"), resultSet.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return genres;
    }


}
