package com.pfe.daricom.ui.connect;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.pfe.daricom.R;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
public class ConnectActivity extends AppCompatActivity {
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);

        TextView signup =findViewById(R.id.signup);
        signup.setOnClickListener(view -> startActivity(new Intent(this,SignUpActivity.class)));
     }
}