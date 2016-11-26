package com.fabflix.search; /**
 * Created by arifzaidi on 9/26/16.
 */
// Import required java libraries

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        SearchDAO s = new SearchDAO();

        String title = request.getParameter("title");
        String year_str = request.getParameter("year");
        int year = 0;
        if(!year_str.isEmpty()){
            year = Integer.parseInt(request.getParameter("year"));
        }
        String director = request.getParameter("director");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");

        List movies = s.executeSearch(title, year, director, fname, lname);
        request.setAttribute("movies", movies);
        request.getRequestDispatcher("/searchResults.jsp").forward(request, response);

    }


}
