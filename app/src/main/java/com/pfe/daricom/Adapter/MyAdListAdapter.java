package com.pfe.daricom.Adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pfe.daricom.Model.AdModel;
import com.pfe.daricom.R;

import java.util.ArrayList;

public class MyAdListAdapter extends RecyclerView.Adapter<MyAdListAdapter.MyAdsViewHolder> {
    private ArrayList<AdModel> myadslist = new ArrayList<>();

    public void setlist(ArrayList myadslist){
        this.myadslist = myadslist;
    }
    @NonNull
    @Override
    public MyAdsViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
        return new MyAdListAdapter.MyAdsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.my_ad_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder (@NonNull MyAdsViewHolder holder, int position){
    }

    @Override
    public int getItemCount (){
        return myadslist.size();
    }

    public class MyAdsViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView adress;
        ImageView image;
        public MyAdsViewHolder (@NonNull View itemView){
            super(itemView);


        }
    }
}
