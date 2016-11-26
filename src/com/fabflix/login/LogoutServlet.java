package com.fabflix.login; /**
 * Created by arifzaidi on 9/26/16.
 */
// Import required java libraries

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/logout", "/logout.jsp"})
public class LogoutServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();


        request.getRequestDispatcher("/login.jsp").include(request, response);

        Cookie ck=new Cookie("fabflix","");
        ck.setMaxAge(0);
        response.addCookie(ck);
        session.invalidate();

        out.print("you are successfully logged out!");
    }
}