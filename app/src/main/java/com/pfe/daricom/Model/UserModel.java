package com.pfe.daricom.Model;

import java.io.Serializable;
import java.util.List;

public class UserModel implements Serializable {
    public UserModel (){
    }

    private int id;
    private String firstName;
    private String lastName;
    private String adress;
    private String email;
    private String phoneNumber;

    public void setAds (List<AdModel> ads){
        this.ads = ads;
    }

    private List<AdModel> ads;


    public int getImage (){
        return image;
    }
    private int image ;


    public UserModel (int id ,String firstName, String lastName, String email,int image){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.image = image;
    }

    public int getId (){
        return id;
    }

    public String getFirstName (){
        return firstName;
    }

    public String getLastName (){
        return lastName;
    }

    public String getAdress (){
        return adress;
    }

    public String getEmail (){
        return email;
    }

    public String getPhoneNumber (){
        return phoneNumber;
    }

    public List<AdModel> getAds (){
        return ads;
    }
}
