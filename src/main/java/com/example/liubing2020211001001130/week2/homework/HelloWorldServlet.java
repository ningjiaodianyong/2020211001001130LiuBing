package com.example.liubing2020211001001130.week2.homework;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
public class HelloWorldServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("Name:LiuBing");
        writer.println("ID:2020211001001130");
        Date date=new Date();
        writer.println("Date and Time"+date.toString());
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}