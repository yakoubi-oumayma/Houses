package com.servlets;

import com.dp.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/RequestHouse")
public class ReservationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("je suis dans dopost de la servlet reservation");

        HttpSession session = request.getSession(false);
        int user_id_int = -1;
        Integer user_id = (Integer) session.getAttribute("user_id");
        System.out.println("hello  user_id AVANT IIIIF "+user_id_int);
        if (user_id != null) {
            user_id_int = user_id.intValue();
            System.out.println("hello if user_id"+user_id_int);
        }

        Date date_deb = Date.valueOf(request.getParameter("date_deb"));
        Date date_fin = Date.valueOf(request.getParameter("date_fin"));
        int annonce_id = Integer.parseInt(request.getParameter("annonce_id"));

        AdReservationProxy adReservation = new AdReservationProxy();
        adReservation.setAdReservationImpl(new AdReservationImpl());
        if(adReservation.reserveAd(annonce_id,  user_id_int, date_deb, date_fin)){
            System.out.println("dkhallt l if dyal insert reservation");
            request.setAttribute("status","success");
            response.sendRedirect(request.getContextPath() + "/listeAnnonces");
        }
        else{
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }

    }
}
