package com.dp;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User  {
    protected String username;
    protected String prenom;
    protected String nom;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
        this.username = uname;
    }

    public User() {

    }


}
