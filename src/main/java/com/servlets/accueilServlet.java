package com.servlets;

import com.dp.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import static com.dp.ConnexionDB.getConnexion;

public class accueilServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            System.out.println("heeeeey j'essaie deGet");
            PreparedStatement pst = getConnexion().prepareStatement("select * from annonces, houses WHERE annonces.house_id=houses.house_id");
            ResultSet res = pst.executeQuery();
            while(res.next()){
                System.out.println("kayn resuultat d la requete");
                int house_id = res.getInt("house_id");
                String ville = res.getString("ville");
                int prix = res.getInt("prix");
                int surface = res.getInt("surface");
                House house = new House();
                house.setId(house_id);
                house.setCity(ville);
                house.setPrice(prix);
                house.setSurface(surface);
                int ad_id = res.getInt("annonce_id");
                String titre = res.getString("titre");
                String description = res.getString("description");
                Date date_d = res.getDate("date_debut_dispo");
                Date date_f = res.getDate("date_fin_dispo");
                Ad ad = new Ad();
                ad.setAnnonce_id(ad_id);
                ad.setHouse_id(house_id);
                ad.setTitre(titre);
                ad.setDescription(description);
                ad.setDate_d(date_d);
                ad.setDate_f(date_f);
                ad.setHouse(house);
                ArrayList<Ad> TotalAds = new ArrayList<>();
                TotalAds.add(ad);
                System.out.println("hnaa kan afficher f doGet: " + ad.getTitre());
                request.setAttribute("TotalAds", TotalAds);


            }
            request.getRequestDispatcher("ads.jsp").forward(request, response);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
