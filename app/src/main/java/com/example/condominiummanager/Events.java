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
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.condominiummanager.ui.login.LoginActivity;

import java.util.Objects;

public class Events extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final SharedPreferences prefs = this.getSharedPreferences("com.example.condominiummanager", Context.MODE_PRIVATE);

        FloatingActionButton addevent = findViewById(R.id.addEvent);

        addevent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AddEvent.class);
                startActivity(i);
            }
        });

        if(prefs.getString("done", "false").equals("true")){

            showevent();
            CalendarView calendar = findViewById(R.id.calendarView);

            calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                @Override
                public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                    TextView details = findViewById(R.id.detailstwenty);
                    CheckBox going = findViewById(R.id.goingevent);
                    if (year == 2019 && month == 4 && dayOfMonth == 22){
                        details.setVisibility(View.VISIBLE);
                        going.setVisibility(View.VISIBLE);
                        if(prefs.getString("checked","false").equals("true")){
                            going.setChecked(true);
                        }
                    }else{
                        details.setVisibility(View.INVISIBLE);
                        going.setVisibility(View.INVISIBLE);
                    }

                }
            });

            final CheckBox going = findViewById(R.id.goingevent);
            going.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if (going.isChecked()){
                        prefs.edit().putString("checked","true").apply();
                    }else{
                        prefs.edit().putString("checked","false").apply();
                    }
                }
            });

            final ImageView go_back = findViewById(R.id.go_back_events);

            go_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                }
            });

        }



    }

    private void showevent() {
        final Button event = findViewById(R.id.eventbutton);
        event.setVisibility(View.VISIBLE);

    }


    @Override
    public void onBackPressed(){
        final SharedPreferences prefs = this.getSharedPreferences("com.example.condominiummanager", Context.MODE_PRIVATE);

        switch (Objects.requireNonNull(prefs.getString("usernametext", "login"))){
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
            default:
                Intent l = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(l);
        }
    }

}
