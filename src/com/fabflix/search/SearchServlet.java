package com.fabflix.search; /**
 * Created by arifzaidi on 9/26/16.
 */
// Import required java libraries

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SearchServlet", urlPatterns = {"/api/search"})
public class SearchServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        Gson gson = new Gson();
        SearchDAO s = new SearchDAO();
        String advSearch = request.getParameter("advSearch");
        List movies = null;

        if(advSearch.equals("true")){
            String title = request.getParameter("title");
            String year = request.getParameter("year");
            String director = request.getParameter("director");
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");

            movies= s.executeSearch(true,title, year, director, fname, lname);
        }else{
            String searchParam = request.getParameter("searchParams");
            movies= s.executeSearch(false,searchParam, searchParam, searchParam, searchParam, searchParam);
        }

        String movies_json = gson.toJson(movies);
        writer.print(movies_json);
    }


}
