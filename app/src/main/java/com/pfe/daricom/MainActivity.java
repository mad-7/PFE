package com.pfe.daricom;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.pfe.daricom.databinding.ActivityMainBinding;
import com.pfe.daricom.ui.AboutUs.AboutUsActivity;
import com.pfe.daricom.ui.dashboard.DashboardFragment;
import com.pfe.daricom.ui.home.HomeFragment;
import com.pfe.daricom.ui.notifications.NotificationsFragment;



public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private ActivityMainBinding binding;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);
       ImageButton aboutUs =  findViewById(R.id.about_us);
       aboutUs.setOnClickListener(view -> startActivity(new Intent(this, AboutUsActivity.class)));


        bottomNavigationView = binding.navView;
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

    }
    HomeFragment homeFragment = new HomeFragment();
    NotificationsFragment notificationsFragment = new NotificationsFragment();
    DashboardFragment dashboardFragment = new DashboardFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.navigation_home:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.container, homeFragment).
                        addToBackStack(null).commit();
                return true;

            case R.id.navigation_notifications:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, notificationsFragment).addToBackStack(null).commit();
                return true;

            case R.id.navigation_dashboard:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, dashboardFragment).addToBackStack(null).commit();
                return true;
        }
        return false;
    }

}