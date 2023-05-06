package com.dp;

import java.util.ArrayList;
import java.util.List;

//C'est ça l'objet observable
public class House {
    protected Integer id;
    protected String city ;
    protected Integer price ;
    protected Integer surface ;
    protected  static List<HouseObserver> observers = new ArrayList<>();
    protected boolean available;

    public House(Integer id, String city, Integer price, Integer surface) {
        this.id = id;
        this.city = city;
        this.price = price;
        this.surface = surface;
    }


    public House() {
    }

    public Integer getId() {
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
        notifyObservers();
    }
    public static void addObserver(HouseObserver observer) {
        observers.add(observer);
    }

    public static void removeObserver(HouseObserver user) {
        observers.remove(user);
    }

    private void notifyObservers() {
        for (HouseObserver observer : observers) {
            observer.houseAvailabilityChanged(this);
        }
    }


    public static void showAllObservers(){
        for (int i = 0; i < observers.size(); i++) {
            System.out.println(observers.get(i));
        }
    }
}
