package com.fabflix.login; /**
 * Created by arifzaidi on 9/26/16.
 */
// Import required java libraries

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = {"/fabflix"})
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();


        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginDAO dao = new LoginDAO(username,password);

        if (username!= null && password!=null && dao.doLogin()) {
            out.print("You are successfully logged in!");
            out.print("<br>Welcome, " + username);

            //Set session
            session = request.getSession();
            session.setAttribute("user", username);
            session.setMaxInactiveInterval(30 * 60); //setting session to expiry in 30 mins


            Cookie ck = new Cookie("fabflix", username);
            ck.setMaxAge(30 * 60);
            response.addCookie(ck);
            request.setAttribute("user", username);
            request.getRequestDispatcher("/index.jsp").forward(request, response);

        } else {
            out.print("sorry, username or password error!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

        out.close();
    }

}