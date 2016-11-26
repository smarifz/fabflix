package com.fabflix.search; /**
 * Created by arifzaidi on 9/26/16.
 */
// Import required java libraries

import com.fabflix.beans.Movie;
import com.fabflix.movielist.MovielistDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MovieListServlet", urlPatterns = {"/movielist"})
public class MovieListServlet extends HttpServlet {
    MovielistDAO ml;

    public void init() {
        ml = new MovielistDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Movie> movies = ml.executeSearchByGenre();
        request.setAttribute("movies", movies);
        request.getRequestDispatcher("/movielist.jsp").forward(request, response);

    }


}
