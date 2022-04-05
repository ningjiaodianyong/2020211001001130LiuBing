package com.example.liubing2020211001001130.week6.homework;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SearchServlet", value = "/SearchServlet")

public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String txt = request.getParameter("txt");
        String search = request.getParameter("search");

        if (txt == null){
            response.sendRedirect(request.getContextPath() + "/week2/index.jsp");
        }else {
            if ("baidu".equals(search)){
                response.sendRedirect("https://www.baidu.com/s?wd=" + txt);
            }else if ("bing".equals(search)){
                response.sendRedirect("https://cn.bing.com/search?q=" + txt);
            }else if ("google".equals(search)){
                response.sendRedirect("https://www.google.com/search?q=" + txt);
            }
        }
    }
}
