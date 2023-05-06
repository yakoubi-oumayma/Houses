package com.servlets;

import com.dp.HouseObserver;
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

import static com.dp.House.addObserver;
import static com.dp.House.showAllObservers;

@WebServlet("/register")

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uname = request.getParameter("username");
        String lname = request.getParameter("nom");
        String fname = request.getParameter("prenom");
        String uemail= request.getParameter("email");
        int umobile = Integer.parseInt(request.getParameter("tel"));
        String upass = request.getParameter("password");
        RequestDispatcher dispatcher =null ;
        Connection con = null;
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/house_location","root","");
            PreparedStatement pst = con.prepareStatement("insert into users (username, prenom, nom, email, tel,  password) values (?,?,?,?,?,?);");
            pst.setString(1,uname);
            pst.setString(2,fname);
            pst.setString(3,lname);
            pst.setString(4,uemail);
            pst.setInt(5,umobile);
            pst.setString(6,upass);
            int rowCount = pst.executeUpdate();
            dispatcher = request.getRequestDispatcher("login.jsp");
            if(rowCount>0){
                User user = new User(uname);
                addObserver(user);
                request.setAttribute("status","success");
            }
            else {
                request.setAttribute("status","failed");
            }
            dispatcher.forward(request, response);

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
