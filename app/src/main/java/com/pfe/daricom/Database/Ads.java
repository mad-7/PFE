package com.pfe.daricom.Database;

import com.pfe.daricom.Model.AdModel;
import com.pfe.daricom.R;

import java.util.ArrayList;
import java.util.List;

public class Ads {

    private  List<AdModel> ads = new ArrayList<>();
    public void setAds (){
        ads.add(new AdModel(1,"hotal dar el ziban", "Algeria", 345, R.drawable.download, 3.5,2,2,2,true));
        ads.add(new AdModel(2,"hotal dar el Diaf", "Tunisia", 425, R.drawable.download_1, 4.5,10,0,0,false));
        ads.add(new AdModel(3,"Dar el chuoukh ElDjelfa", "Algeria", 626, R.drawable.download_2, 5,4,6,0,false));
        ads.add(new AdModel(4,"Hotel 4", "Algeria", 658, R.drawable.download_3, 2,2,5,2,true));
        ads.add(new AdModel(5,"Hotel 5", "Tunisia", 199, R.drawable.download_4, 1.5,4,0,0,false));
        ads.add(new AdModel(6,"Hotel 6", "Algeria", 111, R.drawable.download_5, 2.5,2,5,2,true));
        ads.add(new AdModel(7,"Hotel 7", "Algeria", 148, R.drawable.download, 3,2,5,2,true));
        ads.add(new AdModel(3,"Hotel 8", "Morocco", 148, R.drawable.download_6, 5,3,2,0,true));
        ads.add(new AdModel(3,"Hotel 9", "Pelestine", 164, R.drawable.download_3, 5,2,0,2,false));
        ads.add(new AdModel(1,"Hotel 10", "Pelestine", 150, R.drawable.download_1, 2.5,5,5,0,true));
        ads.add(new AdModel(3,"Hotel 11", "Morocco", 458, R.drawable.download_6, 4,5,2,6,false));
        ads.add(new AdModel(4,"Hotel 12", "Iraq", 444, R.drawable.download_2, 3.4,3,3,0,true));
        ads.add(new AdModel(4,"Hotel 13", "Iraq", 652, R.drawable.download_6, 4,1,4,0,false));
        ads.add(new AdModel(2,"Hotel 14", "Iraq", 847, R.drawable.download_2, 1,2,2,3,true));
        ads.add(new AdModel(2,"Hotel 15", "Saudi Arabia", 150, R.drawable.download_5, 3,8,2,0,false));
        ads.add(new AdModel(2,"Hotel 16", "Algeria", 254, R.drawable.download_4, 3.5,3,2,3,true));
        ads.add(new AdModel(5,"Hotel 17", "Tunisia", 321, R.drawable.download_3, 4,6,2,1,false));
        ads.add(new AdModel(1,"Hotel 18", "Saudi Arabia", 123, R.drawable.download, 5,4,2,2,true));
        ads.add(new AdModel(1,"Hotel 19", "Tunisia", 123, R.drawable.download_6, 5,4,2,2,true));
        ads.add(new AdModel(5,"Hotel 20", "Saudi Arabia", 123, R.drawable.download, 5,4,2,2,true));
    }
    public List getAds (){
        return ads;
    }
}
