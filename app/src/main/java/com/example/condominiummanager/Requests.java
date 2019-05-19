package com.example.condominiummanager;

import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Requests extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final SharedPreferences prefs = this.getSharedPreferences("com.example.condominiummanager", MODE_PRIVATE);
        final TextView name = findViewById(R.id.namerequest);
        final TextView email = findViewById(R.id.emailrequest);
        final TextView addr = findViewById(R.id.addressrequest);

        final ImageView ok = findViewById(R.id.acceptrequest);
        final ImageView oknt = findViewById(R.id.denyrequest);

        if (prefs.getString("regdone", "false").equals("true")){

            name.setText(prefs.getString("namereg", "something wrong"));
            email.setText(prefs.getString("emailreg", "something wrong"));
            addr.setText(prefs.getString("addrreg", "something wrong"));

            name.setVisibility(View.VISIBLE);
            email.setVisibility(View.VISIBLE);
            addr.setVisibility((View.VISIBLE));


        }
    }

}
