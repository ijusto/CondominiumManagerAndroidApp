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
import android.widget.EditText;

public class Report extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final SharedPreferences prefs = this.getSharedPreferences("com.example.condominiummanager", Context.MODE_PRIVATE);

        //TODO 'Thank you for submitting a report' -> go back to main screen

        if(prefs.getString("fromReading", "false").equals("true")){
            EditText description = findViewById(R.id.description);
            String water = prefs.getString("water", "30 m^3");
            String light = prefs.getString("light", "123 kWh");
            String gas = prefs.getString("gas", "145 kWh");

            description.setText(String.format("Report generated from readings.\nWater: %s\nLight: %s\nGas: %s\n", water, light, gas));
        }

        final Button gotoThanks = findViewById(R.id.submit_problem);

        gotoThanks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText name = findViewById(R.id.report_title);
                String title = name.getText().toString();
                prefs.edit().putString("reporttitle", title).apply();
                Intent i = new Intent(getApplicationContext(), reportEnd.class);
                startActivity(i);
            }
        });

    }

}
