package com.pfe.daricom.ui.home;

import android.content.Context;
import android.os.Bundle;
import com.pfe.daricom.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Locale;

public class BottomSheetDialog extends BottomSheetDialogFragment {
    private BottomSheetListener mListener ;
    private String contry;
    private int adults_number = 0 ;
    private int children_number = 0 ;
    private int pets_number = 0 ;
    private TextView adults_TV ;
    private TextView children_TV ;
    private TextView pets_TV ;
    private ImageView adults_up;
    private ImageView adults_down;
    private ImageView children_up;
    private ImageView children_down;
    private ImageView pets_up;
    private ImageView pets_down;

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

View v = inflater.inflate(R.layout.bottom_sheet_layout,container,false);

        configeButtons(v);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.countries_array));
        Spinner contries = v.findViewById(R.id.contries);
        contries.setAdapter(adapter);
        Button letsGO = v.findViewById(R.id.letsgo_btn);
        letsGO.setOnClickListener(view -> {
                contry = contries.getSelectedItem().toString().toLowerCase();
                mListener.onButtonClicked(contry,adults_number,children_number,pets_number);
                 dismiss();
        });
        return  v;
    }

    public interface BottomSheetListener {
        void onButtonClicked(String contry,int adults,int children,int pets);
    }

    private void configeButtons (View v ){
        adults_TV = v.findViewById(R.id.ad_nm);
        children_TV = v.findViewById(R.id.ch_nm);
        pets_TV = v.findViewById(R.id.p_nm);

        adults_up = v.findViewById(R.id.set_u_ad);
        adults_up.setOnClickListener(view -> {
            adults_number++;
            if(adults_number > 0 )
                adults_down.setEnabled(true);
            adults_TV.setText(String.valueOf(adults_number));
        });
        adults_down = v.findViewById(R.id.set_d_ad);
        adults_down.setOnClickListener(view -> {
           if(!(adults_number <= 0) )
            adults_number--;
           else
               adults_down.setEnabled(false);

            adults_TV.setText(String.valueOf(adults_number));
        });
        children_up = v.findViewById(R.id.set_u_ch);
        children_up.setOnClickListener(view -> {
            children_number++;
            if(children_number > 0 )
                children_down.setEnabled(true);

            children_TV.setText(String.valueOf(children_number));
        });

        children_down = v.findViewById(R.id.set_d_ch);
        children_down.setOnClickListener(view -> {

            if(!(children_number <= 0) )
                children_number--;
            else
                children_down.setEnabled(false);


            children_TV.setText(String.valueOf(children_number));
        });
        pets_up = v.findViewById(R.id.set_u_p);
        pets_up.setOnClickListener(view -> {
            pets_number++;
            if(pets_number > 0 )
                pets_down.setEnabled(true);

            pets_TV.setText(String.valueOf(pets_number));
        });
        pets_down = v.findViewById(R.id.set_d_p);
        pets_down.setOnClickListener(view -> {

            if(!(pets_number <= 0) )
                pets_number--;
            else
                pets_down.setEnabled(false);

            pets_TV.setText(String.valueOf(pets_number));
        });

    }

    @Override
    public void onAttach (@NonNull Context context){
        super.onAttach(context);
        try{
            mListener = (BottomSheetListener) getParentFragment();}
        catch(ClassCastException c) {
            Toast.makeText(context, getParentFragment().toString() +" Cast Exeption", Toast.LENGTH_SHORT).show();
        }
    }
}
