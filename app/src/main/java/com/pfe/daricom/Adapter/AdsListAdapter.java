package com.pfe.daricom.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.pfe.daricom.Model.AdModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.function.ToIntBiFunction;

import com.pfe.daricom.Model.UserModel;
import com.pfe.daricom.R;
import com.pfe.daricom.ui.adDetails.AdDetailsActivity;

public class AdsListAdapter extends RecyclerView.Adapter<AdsListAdapter.AdsViewHolder>  {
    private ArrayList<AdModel> adslist = new ArrayList<>();

    @NonNull
    @Override
    public AdsViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
        return new AdsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.ad_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder (@NonNull AdsViewHolder holder, int position){
        holder.title.setText(adslist.get(position).getTitle());
        holder.adress.setText(adslist.get(position).getAdress());
        holder.price.setText(String.valueOf(adslist.get(position).getPrice())+ "/ night ");
        holder.rate.setText(String.valueOf(adslist.get(position).getRate()));
        holder.image.setImageResource(adslist.get(position).getImage());
    }
    @Override
    public int getItemCount (){
        return adslist.size();
    }



    public void setlist(ArrayList<AdModel> adslist){
        this.adslist = adslist;
        notifyDataSetChanged();

    }

    public class AdsViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView adress;
        TextView price;
        TextView rate;
        ImageView image ;
        public AdsViewHolder (@NonNull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.title_ad);
            adress = itemView.findViewById(R.id.adress_ad);
            price = itemView.findViewById(R.id.price_ad);
            rate = itemView.findViewById(R.id.rate_ad);
            image = itemView.findViewById(R.id.image_ad);
            itemView.setOnClickListener(view -> {
              Intent intent = new  Intent(view.getContext(), AdDetailsActivity.class);
              intent.putExtra("ad", adslist.get(getAbsoluteAdapterPosition()));
              view.getContext().startActivity(intent);
            });

        }
    }

}