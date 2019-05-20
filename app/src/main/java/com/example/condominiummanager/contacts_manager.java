package com.example.condominiummanager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class contacts_manager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_manager);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ImageView go_back = findViewById(R.id.go_back_contacts_manager);
        final SharedPreferences prefs = this.getSharedPreferences("com.example.condominiummanager", MODE_PRIVATE);


        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final ImageView chat_maintenance = findViewById(R.id.chat_contact_maintenance);
        final ImageView chat_tenant = findViewById(R.id.chat_contact_tenant);
        chat_maintenance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs.edit().putString("chatname", "Pedro Marques").apply();
                prefs.edit().putString("chatto", "maintenance" ).apply();
                Intent i = new Intent(getApplicationContext(), PrivateChat.class);
                startActivity(i);
            }
        });
        chat_tenant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs.edit().putString("chatname", "Joana Castelo-Branco").apply();
                prefs.edit().putString("chatto", "tenant" ).apply();
                Intent i = new Intent(getApplicationContext(), PrivateChat.class);
                startActivity(i);
            }
        });


        final TextView tenantmobile = findViewById(R.id.contact_phone_tenant);
        final TextView maintenancemobile = findViewById(R.id.contact_phone_maintenance);

        tenantmobile.setText(prefs.getString("tenantmobile", "something wrong"));
        maintenancemobile.setText(prefs.getString("maintenancemobile", "something wrong"));

        final TextView tenantemail = findViewById(R.id.contact_email_tenant);
        final TextView maintenanceemail = findViewById(R.id.contact_email_maintenance);

        tenantemail.setText(prefs.getString("tenantemail", "something wrong"));
        maintenanceemail.setText(prefs.getString("maintenanceemail", "something wrong"));


        if (prefs.getString("tenantemailprivacy", "false").equals("false")) {
            tenantemail.setVisibility(View.INVISIBLE);
        }else if(prefs.getString("tenantemailprivacy", "false").equals("true")){
            tenantemail.setVisibility(View.VISIBLE);
        }

        if (prefs.getString("maintenanceemailprivacy", "false").equals("false")) {
            maintenanceemail.setVisibility(View.INVISIBLE);
        }else if(prefs.getString("maintenanceemailprivacy", "false").equals("true")) {
            maintenanceemail.setVisibility(View.VISIBLE);
        }

        if (prefs.getString("tenantmobileprivacy", "false").equals("false")) {
            tenantmobile.setVisibility(View.INVISIBLE);
        }else if(prefs.getString("tenantmobileprivacy", "false").equals("true")){
            tenantmobile.setVisibility(View.VISIBLE);
        }

        if (prefs.getString("maintenancemobileprivacy", "false").equals("false")) {
            maintenancemobile.setVisibility(View.INVISIBLE);
        }else if(prefs.getString("maintenancemobileprivacy", "false").equals("true")) {
            maintenancemobile.setVisibility(View.VISIBLE);
        }



    }

}
