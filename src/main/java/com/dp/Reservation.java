
package com.dp;

import java.util.Date;

public class Reservation {
    protected Integer reservation_id;
    protected Integer client_id;
    protected Date date_deb;
    protected Date date_fin;
    protected String state;
    protected Integer annonce_id;
    protected Ad ad;

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }


    public Reservation(Integer reservation_id, Integer client_id, Date date_deb, Date date_fin, String state, Integer annonce_id) {
        this.reservation_id = reservation_id;
        this.client_id = client_id;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
        this.state = state;
        this.annonce_id = annonce_id;
    }

    public Reservation() {

    }

    public void setReservation_id(Integer reservation_id) {
        this.reservation_id = reservation_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public void setDate_deb(Date date_deb) {
        this.date_deb = date_deb;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setAnnonce_id(Integer annonce_id) {
        this.annonce_id = annonce_id;
    }

    public Integer getReservation_id() {
        return reservation_id;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public Date getDate_deb() {
        return date_deb;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public String getState() {
        return state;
    }

    public Integer getAnnonce_id() {
        return annonce_id;
    }
}
