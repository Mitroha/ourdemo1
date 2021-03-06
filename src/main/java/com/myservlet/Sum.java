package com.myservlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;


/**
 * Created by alexey_mitrokhin on 18/07/17.
 */
@WebServlet(name = "sumServlet", urlPatterns = {"/"})
public class Sum extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        Map<String, String[]> parMap = request.getParameterMap();
        int sumPar = 0;
        for (String key : parMap.keySet()) {
            String[] value = parMap.get(key);
            for (String curVal : value) {
                sumPar += Integer.parseInt(curVal);
            }
        }

        PrintWriter out = response.getWriter();
        out.println(sumPar);
        out.close();
    }
}
