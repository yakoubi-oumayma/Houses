package com.servlets;

import com.dp.Ad;
import com.dp.HouseIterator;
import com.dp.ListIterator;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("email") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        HouseIterator iterator = new ListIterator();
        List<Ad> adList = new ArrayList<Ad>();
        while (iterator.HasNext()) {
            Ad ad = iterator.next();
            int userIdFromAd = ad.getUser_id();
            int userIdFromSession = Integer.parseInt(session.getAttribute("user_id").toString());

            if(userIdFromAd == userIdFromSession){
                System.out.println("c'est ça propre annonce !!!!");
                adList.add(ad);
            }

        }
        request.setAttribute("adList", adList);
        this.getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response) ;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
