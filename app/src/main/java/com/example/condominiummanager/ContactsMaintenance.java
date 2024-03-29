package com.example.condominiummanager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactsMaintenance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_maintenance);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final SharedPreferences prefs = this.getSharedPreferences("com.example.condominiummanager", MODE_PRIVATE);

        final ImageView go_back = findViewById(R.id.go_back_contacts_maintenance);

        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final ImageView chat_manager = findViewById(R.id.chat_contact_manager);
        final ImageView chat_tenant = findViewById(R.id.chat_contact_tenant);
        chat_manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs.edit().putString("chatname", "Joaquim Inácio").apply();
                prefs.edit().putString("chatto", "manager" ).apply();
                prefs.edit().putString("chathostid", "maintenance" ).apply();
                Intent i = new Intent(getApplicationContext(), PrivateChat.class);
                startActivity(i);
            }
        });
        chat_tenant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs.edit().putString("chatname", "Joana Castelo-Branco").apply();
                prefs.edit().putString("chatto", "tenant" ).apply();
                prefs.edit().putString("chathostid", "maintenance" ).apply();
                Intent i = new Intent(getApplicationContext(), PrivateChat.class);
                startActivity(i);
            }
        });

        final TextView tenantmobile = findViewById(R.id.contact_phone_tenant);
        final TextView managermobile = findViewById(R.id.contact_phone_manager);

        tenantmobile.setText(prefs.getString("tenantmobile", "something wrong"));
        managermobile.setText(prefs.getString("managermobile", "something wrong"));

        final TextView tenantemail = findViewById(R.id.contact_email_tenant);
        final TextView manageremail = findViewById(R.id.contact_email_manager);

        tenantemail.setText(prefs.getString("tenantemail", "something wrong"));
        manageremail.setText(prefs.getString("manageremail", "something wrong"));


        if (prefs.getString("tenantemailprivacy", "false").equals("false")) {
            tenantemail.setVisibility(View.INVISIBLE);
        }else if(prefs.getString("tenantemailprivacy", "false").equals("true")){
            tenantemail.setVisibility(View.VISIBLE);
        }

        if (prefs.getString("manageremailprivacy", "false").equals("false")) {
            manageremail.setVisibility(View.INVISIBLE);
        }else if(prefs.getString("manageremailprivacy", "false").equals("true")) {
            manageremail.setVisibility(View.VISIBLE);
        }

        if (prefs.getString("tenantmobileprivacy", "false").equals("false")) {
            tenantmobile.setVisibility(View.INVISIBLE);
        }else if(prefs.getString("tenantmobileprivacy", "false").equals("true")){
            tenantmobile.setVisibility(View.VISIBLE);
        }

        if (prefs.getString("managermobileprivacy", "false").equals("false")) {
            managermobile.setVisibility(View.INVISIBLE);
        }else if(prefs.getString("managermobileprivacy", "false").equals("true")) {
            managermobile.setVisibility(View.VISIBLE);
        }








    }

}
