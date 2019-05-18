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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ImageView;

import com.example.condominiummanager.ui.login.LoginActivity;

import org.w3c.dom.Text;

public class Readings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final SharedPreferences prefs = this.getSharedPreferences("com.example.condominiummanager", Context.MODE_PRIVATE);

        final ImageView go_back = findViewById(R.id.go_back_readings);

        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        prefs.edit().putString("generated", "false").apply();

        if (prefs.getString("usernametext","tenant").equals("tenant") &&
                prefs.getString("generated","true").equals("false")){
                findViewById(R.id.floortext).setVisibility(View.VISIBLE);
                generatereadings();
                prefs.edit().putString("generated", "true").apply();

        }else if(prefs.getString("usernametext","tenant").equals("maintenance") &&
                prefs.getString("generated","true").equals("false")) {
                findViewById(R.id.floorchooser).setVisibility(View.VISIBLE);
                generatereadings();
                prefs.edit().putString("generated", "true").apply();

        }else if(prefs.getString("usernametext","tenant").equals("manager") &&
                prefs.getString("generated","true").equals("false")) {
                findViewById(R.id.floorchooser).setVisibility(View.VISIBLE);
                generatereadings();
                prefs.edit().putString("generated", "true").apply();
        }



        final Spinner chooser = findViewById(R.id.floorchooser);

        chooser.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                generatereadings();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final Button report = findViewById(R.id.reportbutton);

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView water = findViewById(R.id.waterreadings);
                final TextView light = findViewById(R.id.lightreading);
                final TextView gas = findViewById(R.id.gasreading);

                prefs.edit().putString("water", water.getText().toString()).apply();
                prefs.edit().putString("light", light.getText().toString()).apply();
                prefs.edit().putString("gas", gas.getText().toString()).apply();
                prefs.edit().putString("fromReading", "true").apply();

                Intent i = new Intent(getApplicationContext(), Report.class);
                startActivity(i);
            }

        });

    }

    private void generatereadings(){

        final TextView water = findViewById(R.id.waterreadings);
        final TextView light = findViewById(R.id.lightreading);
        final TextView gas = findViewById(R.id.gasreading);

        double waternumber = (Math.random() * 25) + 5;
        double lightnumber = (Math.random() * 70) + 25;
        double gasnumber = (Math.random() * 300) + 50;
        waternumber = Math.floor(waternumber * 100) / 100;
        lightnumber = Math.floor(lightnumber * 100) / 100;
        gasnumber = Math.floor(gasnumber * 100) / 100;


        water.setText(waternumber + " m^3");
        light.setText(lightnumber+" kWh" );
        gas.setText(gasnumber + " kWh");


    }
}
