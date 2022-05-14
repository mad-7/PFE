package com.pfe.daricom.ui.adDetails;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.pfe.daricom.Database.Users;
import com.pfe.daricom.Model.AdModel;
import com.pfe.daricom.Model.UserModel;
import com.pfe.daricom.R;
import com.pfe.daricom.ui.SendRequest.SendRequestActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.Serializable;

public class AdDetailsActivity extends AppCompatActivity implements Serializable {

    private Users db = new Users();
    private AdModel ad = new AdModel();

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_details);

        //-------------------------------------------------
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);
        //----------------------------------------------------------------------
        ad = (AdModel) getIntent().getSerializableExtra("ad");
        db.setUsers();
        //----------------------------------------------------------------------
        ImageButton share = findViewById(R.id.share_btn);
        share.setOnClickListener(view -> sharedata());
        //-------------------- SET AD INFORMATION ------------------------------
        setAdInformation();
        //-------------------------- SET USER INFORMATION -----------------------------
        setUserInformation();
        //---------------------------------------------------
        Button sendRequest = findViewById(R.id.send_request);
        sendRequest.setOnClickListener(view-> startActivity(new Intent(this, SendRequestActivity.class)));
    }

    private void setUserInformation (){
        TextView username = findViewById(R.id.user_name_detaile);
        ImageView userImage = findViewById(R.id.user_photo);
        UserModel user = db.getUserById(ad.getUserId());
        if (!(user == null)){
            username.setText(user.getFirstName() +" "+ user.getLastName());
            userImage.setImageResource(user.getImage());}
        else
            Toast.makeText(this, "There is no User with this ID : " + ad.getUserId(), Toast.LENGTH_SHORT).show();
    }
    private void setAdInformation (){
        TextView title = findViewById(R.id.title_ad_detaile);
        TextView adress = findViewById(R.id.adress_ad_detaile);
        TextView price = findViewById(R.id.price_ad_detaile);
        ImageView image = findViewById(R.id.image_ad_detaile);
        title.setText(ad.getTitle());
        adress.setText(ad.getAdress());
        price.setText(String.valueOf(ad.getPrice()) + " / night ");
        image.setImageResource(ad.getImage());

    }
    void sharedata(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plian");
        intent.putExtra(Intent.EXTRA_TEXT, "Hotal Link");
        startActivity(Intent.createChooser(intent,"ShareVia"));
    }
}