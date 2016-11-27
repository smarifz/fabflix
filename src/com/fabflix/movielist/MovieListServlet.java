package com.fabflix.movielist;

/**
 * Created by arifzaidi on 9/26/16.
 */
// Import required java libraries

import com.fabflix.beans.Movie;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "MovieListServlet", urlPatterns = {"/api/movies"})
public class MovieListServlet extends HttpServlet {
    MovielistDAO ml;

    public void init() {
        ml = new MovielistDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        List<Movie> movies = ml.executeSearchByGenre();
        Gson gson = new Gson();
        String movies_json = gson.toJson(movies);
        writer.print(movies_json);

    }


}
