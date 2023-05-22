package com.dp;

import jakarta.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ListIterator implements HouseIterator{

    private List<Ad> adList;
    private int currentIndex = 0;



    public ListIterator() {
        adList = new ArrayList<Ad>();
        // Code to populate bookList from database goes here
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/house_location", "root", "");
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM houses , annonces WHERE   houses.house_id=annonces.house_id");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                House house = new House();
                house.setId(rs.getInt("house_id"));
                house.setPrice(rs.getInt("prix"));
                house.setSurface(rs.getInt("surface"));
                house.setCity(rs.getString("ville"));
                // Ad----------------------------------
                Ad ad = new Ad();
                ad.setHouse(house);
                ad.setUser_id(rs.getInt("user_id"));
                ad.setAnnonce_id(rs.getInt("annonce_id"));
                ad.setTitre(rs.getString("titre"));
                ad.setDescription(rs.getString("description"));
                ad.setDate_d(rs.getDate("date_debut_dispo"));
                ad.setDate_f(rs.getDate("date_fin_dispo"));
                ad.setImgFileName(rs.getString("imageFileName"));
                ad.setEtat_annonce(rs.getString("etat_annonce"));


                adList.add(ad);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public boolean HasNext() {
        return currentIndex < adList.size();
    }

    @Override
    public Ad next() {
        return adList.get(currentIndex++);
    }
}
