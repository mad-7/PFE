package com.pfe.daricom.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.pfe.daricom.Adapter.AdsListAdapter;
import com.pfe.daricom.Database.Ads;
import com.pfe.daricom.Database.Users;
import com.pfe.daricom.Model.AdModel;
import com.pfe.daricom.R;
import com.pfe.daricom.databinding.FragmentHomeBinding;
import java.util.ArrayList;
import java.util.Collections;

public class HomeFragment extends Fragment  implements AdapterView.OnItemSelectedListener , BottomSheetDialog.BottomSheetListener {
    private FragmentHomeBinding binding;
    private Ads db = new Ads();
    private Users dbu = new Users();
    private Spinner filter ;
    private AdsListAdapter adsListAdapter = new AdsListAdapter();
    private  ArrayList<AdModel> data = new ArrayList<>();

    public View onCreateView (@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState){

        binding = FragmentHomeBinding.inflate(inflater, container, false);

        View root = binding.getRoot();

        TextView searchfield = binding.searchFieled;

        searchfield.setOnClickListener(view-> {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog();
                bottomSheetDialog.show(getChildFragmentManager(),"Whate Are you Lookin for"); });

            db.setAds();
            dbu.setUsers();

            data = (ArrayList<AdModel>) db.getAds();
            binding.homerecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

            ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.categorie));
            filter = binding.filterSpinner;
            filter.setAdapter(adapter);
            filter.setOnItemSelectedListener(this);
        return root;
    }
    @Override
    public void onDestroyView (){
        super.onDestroyView();
        binding = null;
    }
    @Override
    public void onItemSelected (AdapterView<?> adapterView, View view, int i, long l){
        switch (filter.getSelectedItem().toString()) {
            case"All" :
                break;
            case"Lower Rate" :
                Collections.sort(data,AdModel.byLowerRate);
                break;
                case"Lower Price" :
                Collections.sort(data,AdModel.byLowerPrice);
                break;
                case"Upper Price" :
                Collections.sort(data,AdModel.byUpperPrice);
                break;
                case"Upper Rate" :
                Collections.sort(data,AdModel.byUpperRate);
                break;
            case"Other" :
                Toast.makeText(getActivity(), "Not Programmin yet", Toast.LENGTH_SHORT).show();
                break;
        }
        adsListAdapter.setlist(data);
        binding.homerecycler.setAdapter(adsListAdapter);
    }
    @Override
    public void onNothingSelected (AdapterView<?> adapterView){

    }
    @Override
    public void onButtonClicked (String contry, int adults, int children, int pets){
        search(contry,adults,children,pets);
    }


    private void search (String contry, int adults, int children,int pets){
        ArrayList<AdModel> filtredAds = new ArrayList<>();
        if(!contry.isEmpty()) {
            for (AdModel ad : data) {
                if (
                        ad.getAdress().toLowerCase().contains(contry) &&
                                ad.getMaxAdults() >= adults &&
                                (ad.isPets() && ad.getMaxPets() >= pets) &&
                                ad.getMaxChildren() >= children) {
                                filtredAds.add(ad); }
            }
            if (filtredAds.isEmpty())
                Toast.makeText(getActivity(), "Opps We dont Found Ads for You", Toast.LENGTH_SHORT).show();
            else data = filtredAds;
        }else
            Toast.makeText(getActivity(), "Opps You Dont Search", Toast.LENGTH_SHORT).show();

        adsListAdapter.setlist(data);
        binding.homerecycler.setAdapter(adsListAdapter);
    }
}
