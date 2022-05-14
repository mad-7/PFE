package com.pfe.daricom.Model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

public class AdModel implements Comparable<AdModel>, Serializable {
// ---- Constructeurs ---------
    public AdModel (){ }
    public AdModel (int userId,String title, String adress, double price, int image,double rate,int maxAdults,int maxChildren,int maxPets,boolean pets){
        this.userId = userId;
        this.title = title;
        this.adress = adress;
        this.price = price;
        this.image = image;
        this.rate = rate;
        this.maxAdults = maxAdults;
        this.maxChildren = maxChildren;
        this.pets = pets;
        this.maxPets = maxPets;
    }
    public AdModel (int adId,int userId,String title, String adress, double price, int image,double rate,int maxAdults,int maxChildren,int maxPets,boolean pets){
        this.adId = adId;
        this.userId = userId;
        this.title = title;
        this.adress = adress;
        this.price = price;
        this.image = image;
        this.rate = rate;
        this.maxAdults = maxAdults;
        this.maxChildren = maxChildren;
        this.pets = pets;
        this.maxPets = maxPets;
    }
    public AdModel (int userId,String title, String adress, double price, int image,int maxAdults,int maxChildren,int maxPets,boolean pets){
        this.userId = userId;
        this.title = title;
        this.adress = adress;
        this.price = price;
        this.image = image;
        this.maxAdults = maxAdults;
        this.maxChildren = maxChildren;
        this.pets = pets;
        this.maxPets = maxPets;
    }
// ------ Getters -------------------
    public int      getId (){ return adId; }
    public int      getUserId (){ return userId; }
    public String   getTitle (){ return title; }
    public String   getAdress (){ return adress; }
    public double   getPrice (){ return price; }
    public int      getImage (){ return image; }
    public String   getDescription (){ return description; }
    public List<String> getServices (){ return services; }
    public double   getRate (){ return rate; }
    public int      getMaxPets (){ return maxPets; }
    public int      getMaxChildren (){ return maxChildren; }
    public int      getMaxAdults (){ return maxAdults; }
    public boolean  isPets (){ return pets; }


    //------ Setters

    public void setServices (List<String> services){ this.services = services; }
    public void setDescription (String description){ this.description = description; }

    // ----------------  Attributes
    private int adId;
    private int userId;
    private  String title;
    private String adress;
    private double price;
    private int image;
    private int maxAdults;
    private int maxChildren;
    private int maxPets;
    private boolean pets;
    private double rate;
    private String description;
    private List<String> services;



    @Override
    public int compareTo (AdModel adModel){
        return (int) (this.price - adModel.getPrice());
    }
    public static Comparator<AdModel> byLowerPrice = (ad1, ad2) -> (int) (ad1.getPrice() - ad2.getPrice());
    public static Comparator<AdModel> byUpperPrice = (ad1, ad2) -> (int) (ad2.getPrice() - ad1.getPrice());
    public static Comparator<AdModel> byLowerRate = (ad1, ad2) -> (int) (ad1.getRate() - ad2.getRate());
    public static Comparator<AdModel> byUpperRate = (ad1 ,ad2) -> (int) (ad2.getRate() - ad1.getRate());}
