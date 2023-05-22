package com.servlets;

import com.dp.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



@WebServlet("/register")

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String lname = request.getParameter("nom");
        String fname = request.getParameter("prenom");
        String uemail= request.getParameter("email");
        String upass = request.getParameter("password");
        RequestDispatcher dispatcher =null ;
        Connection con = null;
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/house_location","root","");
            PreparedStatement pst = con.prepareStatement("insert into users ( prenom, nom, email, password) values (?,?,?,?);");
            pst.setString(1,fname);
            pst.setString(2,lname);
            pst.setString(3,uemail);
            pst.setString(4,upass);
            int rowCount = pst.executeUpdate();
            if(rowCount>0){
                request.setAttribute("status","success");
                response.sendRedirect(request.getContextPath() + "/login.jsp");

            }
            else {
                request.setAttribute("status","failed");
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
