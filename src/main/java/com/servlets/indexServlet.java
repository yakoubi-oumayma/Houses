package com.servlets;

import com.dp.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@WebServlet("/index")

public class indexServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        HouseIterator iterator = new ListIterator();
        List<Ad> adList = new ArrayList<Ad>();
        while (iterator.HasNext()) {
            Ad ad = iterator.next();

                adList.add(ad);

        }
        request.setAttribute("adList", adList);
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response) ;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String input = request.getParameter("chercher");
        SurfaceInterpreter surface = new SurfaceInterpreter(input);
        CityInterpreter city = new CityInterpreter(input);
        PriceInterpreter price = new PriceInterpreter(input);

        List<String> critarias = new ArrayList<>();
        critarias.add(city.interpret());
        critarias.add(surface.interpret());
        critarias.add(price.interpret());


        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT * FROM houses WHERE 1=1");
        for (String critaria : critarias) {
            String cr = critaria;
            if (cr != null) {
                queryBuilder.append(" AND ");
                queryBuilder.append(cr);
            }
        }
        System.out.println("hadi hya ma requete :"+queryBuilder);
        Statement stmt = null;
        ResultSet rs = null;
        try {
            ArrayList <Ad> matchedAds = new ArrayList<>();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/house_location", "root", "");

            stmt = con.createStatement();
            rs = stmt.executeQuery(String.valueOf(queryBuilder));
            while (rs.next()) {
                int house_id = rs.getInt("house_id");
                String ville = rs.getString("ville");
                int prix = rs.getInt("prix");
                int surf = rs.getInt("surface");


                House houseMatch = new House();
                houseMatch.setId(house_id);
                houseMatch.setCity(ville);
                houseMatch.setPrice(prix);
                houseMatch.setSurface(surf);
                PreparedStatement pst = con.prepareStatement("select * from annonces where  house_id= ?");
                pst.setInt(1, house_id);
                ResultSet result = pst.executeQuery();
                while (result.next()){
                    int ad_id = result.getInt("annonce_id");
                    String titre = result.getString("titre");
                    String description = result.getString("description");
                    Date date_d = result.getDate("date_debut_dispo");
                    Date date_f = result.getDate("date_fin_dispo");
                    String image = result.getString("imageFileName");
                    String etat_annonce = result.getString("etat_annonce");

                    Ad adMatch = new Ad();
                    adMatch.setAnnonce_id(ad_id);
                    adMatch.setHouse_id(house_id);
                    adMatch.setTitre(titre);
                    adMatch.setDescription(description);
                    adMatch.setDate_d(date_d);
                    adMatch.setDate_f(date_f);
                    adMatch.setHouse(houseMatch);
                    adMatch.setImgFileName(image);
                    adMatch.setEtat_annonce(etat_annonce);

                    matchedAds.add(adMatch);

                    request.setAttribute("matchedAds", matchedAds);
                }
            }
            for(Ad ad: matchedAds){
                System.out.println("Titre:" + ad.getTitre());
            }

            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response) ;




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

