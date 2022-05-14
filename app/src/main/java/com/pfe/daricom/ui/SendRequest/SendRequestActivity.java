package com.pfe.daricom.ui.SendRequest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.pfe.daricom.R;
import com.pfe.daricom.ui.AboutUs.AboutUsActivity;

public class SendRequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_request);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);

        ImageButton aboutUs =  findViewById(R.id.about_us);
        aboutUs.setOnClickListener(view -> startActivity(new Intent(this, AboutUsActivity.class)));



    }
}