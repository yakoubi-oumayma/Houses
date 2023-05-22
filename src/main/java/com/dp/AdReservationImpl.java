package com.dp;

import java.sql.*;
import java.time.LocalDate;
import java.util.Date;

public class AdReservationImpl implements AdReservation {



    @Override
    public Boolean reserveAd(Integer annonce_id, int user_id, Date startDate, Date endDate) {
        Boolean inserted=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/house_location","root","");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM annonces WHERE annonce_id=?;");
            pst.setInt(1, annonce_id);
            ResultSet resultSet= pst.executeQuery();
            while (resultSet.next()) {
                Date date_debut_dispo = resultSet.getDate("date_debut_dispo");
                Date date_fin_dispo = resultSet.getDate("date_fin_dispo");
                if (date_debut_dispo.compareTo(startDate) <= 0 && date_fin_dispo.compareTo(endDate) >= 0) {
                    System.out.println(" La maison est disponible entre les dates startDate et endDate");
                    PreparedStatement pst1 = con.prepareStatement("insert into reservations (client_id, date_deb, date_fin, annonce_id) values (?,?,?,?);");
                    pst1.setObject(1,user_id);
                    pst1.setDate(2, (java.sql.Date) startDate);
                    pst1.setDate(3, (java.sql.Date) endDate);
                    pst1.setInt(4,annonce_id);
                    pst1.executeUpdate();

                    PreparedStatement pst2 = con.prepareStatement("update annonces set etat_annonce='Non disponible' WHERE annonce_id= ?;");
                    pst2.setInt(1,annonce_id);
                    pst2.executeUpdate();

                     inserted=true;

                } else {
                    System.out.println("La maison n'est pas disponible entre les dates d1 et d2");
                     inserted=false;
                }
            }


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return inserted;
    }
}
