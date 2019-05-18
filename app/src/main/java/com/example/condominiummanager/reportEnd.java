package com.example.condominiummanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class reportEnd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_end);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final SharedPreferences prefs = this.getSharedPreferences("com.example.condominiummanager", Context.MODE_PRIVATE);

        final Button returnButton = findViewById(R.id.backtomenu);
        final String username = prefs.getString("usernametext", "tenant");

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert username != null;
                switch(username){
                    case "tenant":
                        Intent i = new Intent(getApplicationContext(), Tenant.class);
                        startActivity(i);
                        break;
                    case "maintenance":
                        Intent j = new Intent(getApplicationContext(), Maintenance.class);
                        startActivity(j);
                        break;
                    case "manager":
                        Intent k = new Intent(getApplicationContext(), Manager.class);
                        startActivity(k);
                        break;

                }
            }
        });


    }

}
