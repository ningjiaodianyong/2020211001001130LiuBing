package com.example.liubing2020211001001130.week5.homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;
    public void init() throws SecurityException, ServletException {
        super.init();

        //TODO 1: GET 4 CONTEXT PARAM - DRIVER , URL,USERNAME , PASSWORD
        /*ServletContext context = getServletContext();
        String driver = context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");*/


        //TODO 2: GET JDBC connection
        /*try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection --> in JDBCDemoServlet"+con);//just print for test
            //one connection -
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
        con = (Connection) getServletContext().getAttribute("con");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("login serlvet doGet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("login servlet dopost");
        //PrintWriter writer = response.getWriter();

        //TODO 3: GET REQUEST PARAMETER - USERNAME AND PASSEORD from login
        String username = request.getParameter("username");//name of input type
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);

        // TODO 4:VALIDATE USER - SELECT * FROM USERTABLE WHERE USERNAME='XXX' AND PASSWORD='YYY'
        try {
            String sql = "Select * from usertable where username=? and password=? ";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();

            //5
            if(resultSet.next()){
                //writer.println("<br/> <h1>Login Success!!!</h1><br/>");
                //writer.println("<h1> Welcome "+username+" </h1>");
                request.setAttribute("id",resultSet.getInt("id"));
                request.setAttribute("username",resultSet.getString("username"));
                request.setAttribute("password",resultSet.getString("password"));
                request.setAttribute("email",resultSet.getString("email"));
                request.setAttribute("gender",resultSet.getString("gender"));
                request.setAttribute("birth date",resultSet.getString("birthDate"));
                request.getRequestDispatcher("userList.jsp").forward(request,response);
            }else {
                //writer.println("<h1>Username or Password Error!!!</h1>");
                //writer.close();
                request.setAttribute("message","Username or Password Eorror!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } public void destroy(){
        super.destroy();
        //close connection here - when stop tomcat
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}