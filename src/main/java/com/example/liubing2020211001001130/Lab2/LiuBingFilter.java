package com.example.liubing2020211001001130.Lab2;

import javax.servlet.*;
import java.io.IOException;

public class LiuBingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("LiuBingFilter-->before chain");
        chain.doFilter(req, resp);
        System.out.println("LiuBingFilter-->after chain");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("LiuBingFilter-->before chain");
        System.out.println("LoginFilter-->before chain");
        System.out.println("LoginFilter-->after chain");
        System.out.println("LiuBingFilter-->after chain");

    }

}