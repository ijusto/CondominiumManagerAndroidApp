package com.example.condominiummanager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactsTenant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_tenant);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final SharedPreferences prefs = this.getSharedPreferences("com.example.condominiummanager", MODE_PRIVATE);


        final ImageView go_back = findViewById(R.id.go_back_contacts_tenant);

        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final ImageView chat_manager = findViewById(R.id.chat_contact_manager);
        final ImageView chat_maintenance = findViewById(R.id.chat_contact_maintenance);
        chat_manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PrivateChat.class);
                startActivity(i);
            }
        });
        chat_maintenance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PrivateChat.class);
                startActivity(i);
            }
        });

        final TextView maintenancemobile = findViewById(R.id.contact_phone_maintenance);
        final TextView managermobile = findViewById(R.id.contact_phone_manager);

        maintenancemobile.setText(prefs.getString("maintenancemobile", "something wrong"));
        managermobile.setText(prefs.getString("managermobile", "something wrong"));

        final TextView maintenanceemail = findViewById(R.id.contact_email_maintenance);
        final TextView manageremail = findViewById(R.id.contact_email_manager);

        maintenanceemail.setText(prefs.getString("maintenanceemail", "something wrong"));
        manageremail.setText(prefs.getString("manageremail", "something wrong"));


        if (prefs.getString("maintenanceemailprivacy", "false").equals("false")) {
            maintenanceemail.setVisibility(View.INVISIBLE);
        }else if(prefs.getString("maintenanceemailprivacy", "false").equals("true")){
            maintenanceemail.setVisibility(View.VISIBLE);
        }

        if (prefs.getString("manageremailprivacy", "false").equals("false")) {
            manageremail.setVisibility(View.INVISIBLE);
        }else if(prefs.getString("manageremailprivacy", "false").equals("true")) {
            manageremail.setVisibility(View.VISIBLE);
        }

        if (prefs.getString("maintenancemobileprivacy", "false").equals("false")) {
            maintenancemobile.setVisibility(View.INVISIBLE);
        }else if(prefs.getString("maintenancemobileprivacy", "false").equals("true")){
            maintenancemobile.setVisibility(View.VISIBLE);
        }

        if (prefs.getString("managermobileprivacy", "false").equals("false")) {
            managermobile.setVisibility(View.INVISIBLE);
        }else if(prefs.getString("managermobileprivacy", "false").equals("true")) {
            managermobile.setVisibility(View.VISIBLE);
        }


    }

}
