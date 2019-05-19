package com.example.condominiummanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.condominiummanager.ui.login.LoginActivity;

public class Tenant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ImageView events = findViewById(R.id.events);
        final ImageView maintenance = findViewById(R.id.maintenance);
        final ImageView readings = findViewById(R.id.readings);
        final ImageView contacts = findViewById(R.id.contacts);
        final ImageView payments = findViewById(R.id.payments);
        final ImageView profile = findViewById(R.id.profiletenant);
        final ImageView settings = findViewById(R.id.settings_tenant);


        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Events.class);
                startActivity(i);
            }
        });

        maintenance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), TaskTenant.class);
                startActivity(i);
            }
        });

        readings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Readings.class);
                startActivity(i);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ProfileTenant.class);
                startActivity(i);
            }
        });

        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ContactsTenant.class);
                startActivity(i);
            }
        });

        payments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PaymentsTenant.class);
                startActivity(i);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Settings.class);
                startActivity(i);
            }
        });




    }
    @Override
    public void onBackPressed(){
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
    }

}
