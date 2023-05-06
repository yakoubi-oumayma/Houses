package com.dp;

public class User implements HouseObserver{
    protected String username;
    protected String prenom;
    protected String nom;
    protected Integer tel;
    protected String email;
    protected String password;

    public User(String username, String prenom, String nom, Integer tel, String email, String password) {
        this.username = username;
        this.prenom = prenom;
        this.nom = nom;
        this.tel = tel;
        this.email = email;
        this.password = password;
    }

    public User(String uname) {
        this.username= uname;
    }

    @Override
    public void houseAvailabilityChanged(House house) {
        if (house.isAvailable()) {
            System.out.println("La maison est maintenant disponible !");
            // Faire quelque chose ici, comme envoyer une notification à l'utilisateur
        } else {
            System.out.println("La maison n'est plus disponible.");
        }
    }
}
