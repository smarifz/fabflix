package com.fabflix.movielist;

/**
 * Created by arifzaidi on 9/26/16.
 */
// Import required java libraries

import com.fabflix.beans.Movie;
import com.fabflix.search.SearchDAO;
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
    SearchDAO s = null;

    public void init() {
        ml = new MovielistDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        PrintWriter writer = response.getWriter();
        Gson gson = new Gson();


        List<Movie> movies = null;

        if (type.equals("search")) {
            s = new SearchDAO();
            String attribute = request.getParameter("attribute");

//            if(attribute.equals("na"))
//                s.executeSearch("and");
//            else
//                s.executeSearch("or")

        } else if (type.equals("genre")) {
            String genre = request.getParameter("attribute");
            if (genre != null && !genre.isEmpty()) {
                movies = ml.executeSearchByGenre(genre);
            }
        } else if (type.equals("title")) {
            String name = request.getParameter("attribute");
            if (name != null && !name.isEmpty()) {
                movies = ml.executeSearchByTitle(name);
            }
        } else if (type.equals("single")) {
            int id = Integer.parseInt(request.getParameter("attribute"));
            if (id != 0) {
                Movie movie = ml.getMovie(id);
                String movie_json = gson.toJson(movie);
                writer.print(movie_json);

            }
        }


        String movies_json = gson.toJson(movies);
        writer.print(movies_json);

    }


}
