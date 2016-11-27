package com.fabflix.login; /**
 * Created by arifzaidi on 9/26/16.
 */
// Import required java libraries


import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "LoginServlet", urlPatterns = {"/api/login"})
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
        String str = null;
        String username = null;
        String password = null;
        JSONObject jObj = null;

        while ((str = br.readLine()) != null) {
            sb.append(str);
        }

        try {
            jObj = new JSONObject(sb.toString());
            username = jObj.getString("username");
            password = jObj.getString("password");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        LoginDAO dao = new LoginDAO(username,password);

        if (username!= null && password!=null && dao.doLogin()) {
//            out.print("You are successfully logged in!");
//            out.print("<br>Welcome, " + username);

            //Set session
//            session = request.getSession();
//            session.setAttribute("user", username);
//            session.setMaxInactiveInterval(30 * 60); //setting session to expiry in 30 mins
//
//
//            Cookie ck = new Cookie("fabflix", username);
//            ck.setMaxAge(30 * 60);
//            response.addCookie(ck);
//            request.setAttribute("user", username);
//            request.getRequestDispatcher("/index.jsp").forward(request, response);
//            String json = new Gson().toJson(ck);

            String ck = username;
            try {
                String json = new Gson().toJson(ck);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }catch(Exception e){
                System.out.println(e);
            }


        } else {
            out.print("sorry, username or password error!");
            response.setStatus(403);
//            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

        out.close();
    }

}