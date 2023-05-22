package com.dp;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//C'est ça l'objet observable
public class House extends Thread{
    protected Integer id;
    protected String city ;
    protected Integer price ;
    protected Integer surface ;
    protected boolean available;

    public boolean getAvailable() {
        return available;
    }

    public House(Integer id, String city, Integer price, Integer surface) {
        this.id = id;
        this.city = city;
        this.price = price;
        this.surface = surface;
    }


    public House() {
    }

    public long getId() {
        return id;
    }
    public String getCity() {
        return city;
    }
    public Integer getPrice() {
        return price;
    }
    public Integer getSurface() {
        return surface;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setSurface(Integer surface) {
        this.surface = surface;
    }
    //--------------observable
    public void setAvailable(boolean available) {
        this.available = available;

    }



    public void run() {
        while (true) {
            // Vérifier la disponibilité des maisons ici

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/house_location", "root", "");
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM reservations, annonces, houses WHERE reservations.annonce_id = annonces.annonce_id AND annonces.house_id= houses.house_id ");
                ResultSet rs = stmt.executeQuery();
                List<House> availablehousesList = new ArrayList<>();
                while (rs.next()) {
                    Date fin_reservation = rs.getDate("date_fin");
                    System.out.println("fin_reservation = "+ fin_reservation);

                    // Récupérer la date d'aujourd'hui
                    LocalDate today = LocalDate.now();
                    if (today.isAfter(fin_reservation.toLocalDate())) {
                        System.out.println("La date de fin de réservation est passée.");
                        House house = new House();
                        house.setId(rs.getInt("house_id"));
                        house.setCity(rs.getString("ville"));
                        house.setSurface(rs.getInt("surface"));
                        house.setPrice(rs.getInt("prix"));
                        house.setAvailable(true);
                        availablehousesList.add(house);
                        //hna ghancreer une house pour appeler la methode setavailable et notifier les utilisateur
                    }
                }
                for (House house : availablehousesList) {
                   //je vais update annonce_etat to disponible and reservation to finished
                    System.out.println("la maison dont l'id = " + house.getId() + "situé dans  la ville de " + house.getCity() + " est mantenant disponible ");
                    long house_id = house.getId();

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/house_location", "root", "");
                        PreparedStatement st1 = connexion.prepareStatement("UPDATE annonces SET etat_annonce='Disponible' WHERE  annonces.house_id=?");
                        st1.setLong(1,house_id);
                        st1.executeUpdate();

                        PreparedStatement st2 = connexion.prepareStatement("UPDATE reservations SET state='finished' WHERE annonce_id IN (SELECT annonce_id FROM annonces WHERE house_id = ?)");
                        st2.setLong(1,house_id);
                        st2.executeUpdate();


                    } catch (ClassNotFoundException | SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                Thread.sleep(24 * 60 * 1000); // Attendre 24 heures càd 1jr
            } catch (InterruptedException | SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }








}
