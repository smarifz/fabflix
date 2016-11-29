package com.fabflix.stars;

/**
 * Created by arifzaidi on 9/26/16.
 */
// Import required java libraries

import com.fabflix.beans.Star;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MovieListServlet", urlPatterns = {"/api/star"})
public class StarServlet extends HttpServlet {
    StarDAO s;

    public void init() {
        s = new StarDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        PrintWriter writer = response.getWriter();
        Gson gson = new Gson();

        Star star = null;

        if (type.equals("single")) {
            int id = Integer.parseInt(request.getParameter("attribute"));
            if (id != 0) {
                star = s.getStarInfo(id);
                String star_json = gson.toJson(star);
                writer.print(star_json);
            }
        }
    }




}
