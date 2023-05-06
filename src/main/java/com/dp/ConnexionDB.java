package com.dp;

import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

public class ConnexionDB {
    private static Connection conn;
    private static final String url = "jdbc:mysql://localhost:3306/house_location";
    private static final String user = "root";
    private static final String password = "";

    public static Connection getConnexion() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                System.out.println("Erreur : impossible de charger le driver JDBC MySQL.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Erreur : impossible de se connecter à la base de données MySQL.");
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static void fermerConnexion() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Erreur : impossible de fermer la connexion à la base de données MySQL.");
                e.printStackTrace();
            }
        }
    }
}

