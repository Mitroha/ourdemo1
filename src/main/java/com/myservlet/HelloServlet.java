package com.myservlet;

import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * Created by alexey_mitrokhin on 09/07/17.
 */


@WebServlet(name = "HelloServlet", urlPatterns = {"/time"})
public class HelloServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date date = new Date();
        Date dateLondon = new Date();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println(date.toString());

        out.println(date.toGMTString());


        //TimeZone london = TimeZone.getTimeZone("Europe/London");


        out.close();
    }
}

