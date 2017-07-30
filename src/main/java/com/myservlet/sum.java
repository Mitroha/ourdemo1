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
@WebServlet(name = "sumServlet", urlPatterns={"/"})
public class sum extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String urlString = new String(request.getRequestURL().toString());
        //String urlString=request.getRequestURL().toString();

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        //out.println(urlString);

        //String paramName = "one";
        //String paramValue = request.getParameter(paramName);

        java.util.Map<String, String[]> parMap= request.getParameterMap();

        java.util.Collection<String[]> parVal=parMap.values();

        //int numberofPar=parVal.size();

        int i=1;
        java.util.Iterator<String[]> iter =  parVal.iterator();

        String[] nextGroup;

        int nextPar;
        int sumPar=0;
        int groupSize;
        while (iter.hasNext()){
            nextGroup=iter.next();
            groupSize=nextGroup.length;
            for (i=0; i<groupSize; i++) {
                nextPar = Integer.parseInt(nextGroup[i]);
                sumPar = sumPar + nextPar;
            }
        }

        out.println(sumPar);


        //out.println(paramValue);

        out.flush();
    }
}
