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

public class ChatMaintenance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_maintenance);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ImageView go_back = findViewById(R.id.go_back_chat_maintenance);
        final SharedPreferences prefs = this.getSharedPreferences("com.example.condominiummanager", MODE_PRIVATE);


        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        final ImageView manager_private_chat = findViewById(R.id.manager_private_chat);
        final ImageView tenant_private_chat = findViewById(R.id.tenant_private_chat);
        manager_private_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs.edit().putString("chatname", "Joaquim Inácio").apply();
                prefs.edit().putString("chatto", "manager" ).apply();
                prefs.edit().putString("chathostid", "maintenance" ).apply();
                Intent i = new Intent(getApplicationContext(), PrivateChat.class);
                startActivity(i);
            }
        });
        tenant_private_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs.edit().putString("chatname", "Joana Castelo-Branco").apply();
                prefs.edit().putString("chatto", "tenant" ).apply();
                prefs.edit().putString("chathostid", "maintenance" ).apply();
                Intent i = new Intent(getApplicationContext(), PrivateChat.class);
                startActivity(i);
            }
        });


    }

}
