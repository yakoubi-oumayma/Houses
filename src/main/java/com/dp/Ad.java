package com.dp;

import java.util.Date;

public class Ad {
    protected  Integer user_id;
    protected Integer annonce_id;

    protected Integer house_id;
    protected String titre ;
    protected String description;
    protected Date date_d;
    protected String imgFileName;
    protected Date date_f;

    protected String etat_annonce;

    public String getEtat_annonce() {
        return etat_annonce;
    }

    public void setEtat_annonce(String etat_annonce) {
        this.etat_annonce = etat_annonce;
    }

    public String getImgFileName() {
        return imgFileName;
    }

    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }

    protected House house;

    public House getHouse() {
        return house;
    }

    public  void setHouse(House house) {
        this.house = house;
    }

    public Ad(Integer annonce_id, Integer house_id, String titre, String description, Date date_d, Date date_f, House house) {
        this.annonce_id = annonce_id;
        this.house_id = house_id;
        this.titre = titre;
        this.description = description;
        this.date_d = date_d;
        this.date_f = date_f;
    }

    public Ad() {

    }

    public void setAnnonce_id(Integer annonce_id) {
        this.annonce_id = annonce_id;
    }

    public void setHouse_id(Integer house_id) {
        this.house_id = house_id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate_d(Date date_d) {
        this.date_d = date_d;
    }

    public void setDate_f(Date date_f) {
        this.date_f = date_f;
    }

    public Integer getAnnonce_id() {
        return annonce_id;
    }

    public Integer getHouse_id() {
        return house_id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate_d() {
        return date_d;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    public Date getDate_f() {
        return date_f;
    }
}
