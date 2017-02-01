package com.fabflix.checkout; /**
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "CheckoutServlet", urlPatterns = {"/api/checkout"})
public class CheckoutServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        CheckoutDAO c = new CheckoutDAO();
//        String movieId = request.getParameter("movieId");
        String movieId = "693007";
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String cc = request.getParameter("cc");
        String ids_raw = request.getParameter("ids");
        String exp_raw = request.getParameter("exp");
        String exp_arr[];
        exp_arr = exp_raw.split("T");
        String exp = exp_arr[0];

        ids_raw = ids_raw.replace("[", " ");
        ids_raw = ids_raw.replace("]", " ");
        String[] ids_str = ids_raw.split(",");
        List<String> ids_arr = Arrays.asList(ids_str);

        Boolean exist = c.verifyCustomerExists(fname, lname, cc, exp);
        ArrayList<Integer> salesId = null;
        if(exist) {
            salesId = c.createSale(movieId, fname, lname, ids_arr);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer s : salesId)
        {
            sb.append(s);
            sb.append(" ");
        }
        PrintWriter writer = response.getWriter();
        Gson gson = new Gson();
        String salesId_json = gson.toJson(sb);
        writer.print(salesId_json);

    }


}
