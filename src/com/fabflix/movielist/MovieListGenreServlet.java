package com.fabflix.movielist;

/**
 * Created by arifzaidi on 9/26/16.
 */
// Import required java libraries

import com.fabflix.beans.Genre;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "MovieListServlet", urlPatterns = {"/api/movies/genres"})
public class MovieListGenreServlet extends HttpServlet {
    MovielistDAO ml;

    public void init() {
        ml = new MovielistDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        List<Genre> genres = null;
        genres = ml.getGenres();
        Gson gson = new Gson();
        String genre_json = gson.toJson(genres);
        writer.print(genre_json);
    }


}
