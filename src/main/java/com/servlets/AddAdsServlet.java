package com.servlets;

import com.dp.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.*;

@MultipartConfig
@WebServlet("/addAds")
public class AddAdsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("email") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titre = request.getParameter("titre");
        String ville = request.getParameter("ville");
        String description = request.getParameter("description");
        HttpSession session = request.getSession(false);
        Object user_id = session.getAttribute("user_id");

        int prix = Integer.parseInt(request.getParameter("prix"));
        int surface = Integer.parseInt(request.getParameter("surface"));
        String date_d = request.getParameter("date_d");
        String date_f = request.getParameter("date_f");
        Part file = request.getPart("image"); // récupérer l'objet Part correspondant à l'image
        String imageFileName = file.getSubmittedFileName();
        String uploadPath= "C:/xampp/htdocs/imageAds/"+imageFileName;
        System.out.println("pathhhh" + uploadPath);


        RequestDispatcher dispatcher =null ;

        try{
            FileOutputStream fos = new FileOutputStream(uploadPath);
            InputStream is = file.getInputStream();
            byte[] data = new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();
            int id = -1;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/house_location", "root", "");
            PreparedStatement insertHouse = con.prepareStatement("INSERT INTO houses (ville, prix, surface) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            insertHouse.setString(1,ville);
            insertHouse.setInt(2,prix);
            insertHouse.setInt(3,surface);
            int rowsAffected = insertHouse.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("erreur!!!");
            } else {
                // Insertion a réussi
                ResultSet generatedKeys = insertHouse.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    PreparedStatement insertAd = con.prepareStatement("INSERT INTO annonces ( house_id, user_id, titre, description, date_debut_dispo, date_fin_dispo, imageFileName) values (?,?,?,?,?,?,?)");
                    insertAd.setInt(1,generatedId);
                    insertAd.setObject(2,user_id);
                    insertAd.setString(3,titre);
                    insertAd.setString(4,description);
                    insertAd.setString(5,date_d);
                    insertAd.setString(6,date_f);
                    insertAd.setString(7,imageFileName);
                    insertAd.executeUpdate();
                    response.sendRedirect(request.getContextPath() + "/listeAnnonces");

                }


            }

        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
