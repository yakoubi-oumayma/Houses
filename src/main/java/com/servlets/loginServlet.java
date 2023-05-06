package com.servlets;

import com.dp.Ad;
import com.dp.House;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import static com.dp.ConnexionDB.getConnexion;

@WebServlet("/login")
public class loginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String uemail= request.getParameter("email");
    String upwd = request.getParameter("password");
    HttpSession session = request.getSession();
    RequestDispatcher dispatcher =null;

    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/house_location","root","");
        PreparedStatement pst = con.prepareStatement("select * from users where email= ? and password =?");
        pst.setString(1, uemail);
        pst.setString(2, upwd);
       ResultSet rs = pst.executeQuery();
       if(rs.next()){
          session.setAttribute("name",rs.getString("email"));
            dispatcher = request.getRequestDispatcher("ads.jsp");
       }
       else {
           request.setAttribute("status","failed");
           dispatcher = request.getRequestDispatcher("login.jsp");
       }
       dispatcher.forward(request, response);

    }catch (Exception e){
        e.printStackTrace();
    }



    }
}
