package com.example.condominiummanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class Manager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ImageView events = findViewById(R.id.events);
        final ImageView maintenance = findViewById(R.id.maintenance);
        final ImageView readings = findViewById(R.id.readings);
        final ImageView contacts = findViewById(R.id.contacts);
        final ImageView payments = findViewById(R.id.payments);

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
                Intent i = new Intent(getApplicationContext(), Maintenance.class);
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
        //TODO implement contacts
        /*contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Contacts.class);
                startActivity(i);
            }
        });*/


        //TODO implement payments
        /*payments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Payments.class);
                startActivity(i);
            }
        });*/

        //TODO implement invitation
        /*invitations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Invitations.class);
                startActivity(i);
            }
        });*/




    }

}
