package com.example.condominiummanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.condominiummanager.ui.login.LoginActivity;

import org.w3c.dom.Text;

import java.util.Objects;

public class Events extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final SharedPreferences prefs = this.getSharedPreferences("com.example.condominiummanager", Context.MODE_PRIVATE);

        final ImageView addevent = findViewById(R.id.add_button);
        final ImageView checkevent = findViewById(R.id.check_event);

        CalendarView calendars = findViewById(R.id.calendarView);

        calendars.setFirstDayOfWeek(1);
        final ImageView go_back = findViewById(R.id.go_back_events);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final ImageView add_event_rect_info = findViewById(R.id.add_event_rect_info);
        final TextView day_info = findViewById(R.id.day_info);
        final TextView event_name = findViewById(R.id.event_name);
        final TextView event_hour = findViewById(R.id.event_hour);
        final TextView event_description = findViewById(R.id.event_description);
        final EditText event_desc_input = findViewById(R.id.event_desc_input);
        final EditText event_name_input = findViewById(R.id.event_name_input);
        final EditText event_hour_input = findViewById(R.id.event_hour_input);

        addevent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                add_event_rect_info.setVisibility(View.VISIBLE);
                day_info.setVisibility(View.VISIBLE);
                event_name.setVisibility(View.VISIBLE);
                event_hour.setVisibility(View.VISIBLE);
                event_description.setVisibility(View.VISIBLE);
                event_desc_input.setVisibility(View.VISIBLE);
                event_name_input.setVisibility(View.VISIBLE);
                event_hour_input.setVisibility(View.VISIBLE);
                addevent.setVisibility((View.INVISIBLE));
                checkevent.setVisibility((View.VISIBLE));
            }
        });

        checkevent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                add_event_rect_info.setVisibility(View.INVISIBLE);
                day_info.setVisibility(View.INVISIBLE);
                event_name.setVisibility(View.INVISIBLE);
                event_hour.setVisibility(View.INVISIBLE);
                event_description.setVisibility(View.INVISIBLE);
                event_desc_input.setVisibility(View.INVISIBLE);
                event_name_input.setVisibility(View.INVISIBLE);
                event_hour_input.setVisibility(View.INVISIBLE);
                checkevent.setVisibility((View.INVISIBLE));
                addevent.setVisibility((View.VISIBLE));
                prefs.edit().putString("done","true").apply();

                if(prefs.getString("done", "false").equals("true")){
                    final TextView whois = findViewById(R.id.whosgoing);
                    whois.setText(prefs.getString("whoistr", ""));

                    showevent();
                    CalendarView calendar = findViewById(R.id.calendarView);

                    calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                        @Override
                        public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                            TextView details = findViewById(R.id.detailstwenty);
                            CheckBox going = findViewById(R.id.goingevent);
                            TextView top = findViewById(R.id.whosgoing_lol);

                            if (year == 2019 && month == 4 && dayOfMonth == 22){
                                details.setVisibility(View.VISIBLE);
                                going.setVisibility(View.VISIBLE);
                                whois.setVisibility(View.VISIBLE);
                                top.setVisibility(View.VISIBLE);

                                String username = prefs.getString("usernametext", "tenant");
                                switch (username){
                                    case "tenant":
                                        if(prefs.getString("checkedtenant","false").equals("true")){
                                            going.setChecked(true);
                                        }break;
                                    case "maintenance":
                                        if(prefs.getString("checkedmaintenance","false").equals("true")){
                                            going.setChecked(true);
                                        }break;
                                    case "manager":
                                        if(prefs.getString("checkedmanager","false").equals("true")){
                                            going.setChecked(true);
                                        }break;

                                }

                            }else{
                                details.setVisibility(View.INVISIBLE);
                                going.setVisibility(View.INVISIBLE);
                                whois.setVisibility(View.INVISIBLE);
                                top.setVisibility(View.INVISIBLE);
                            }

                        }
                    });

                    final CheckBox going = findViewById(R.id.goingevent);
                    going.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            TextView whois = findViewById(R.id.whosgoing);
                            if (going.isChecked()){
                                String whoistr = "";
                                String username = prefs.getString("usernametext", "tenant");
                                switch (username) {
                                    case "tenant":
                                        prefs.edit().putString("checkedtenant", "true").apply();
                                        whoistr = prefs.getString("whoistr", "");
                                        prefs.edit().putString("whoistr", whoistr + "  Joana Castelo-Branco  ").apply();
                                        whois.setText(prefs.getString("whoistr", ""));
                                        break;
                                    case "manager":
                                        prefs.edit().putString("checkedmanager", "true").apply();
                                        whoistr = prefs.getString("whoistr", "");
                                        prefs.edit().putString("whoistr", whoistr + "  Joaquim Inácio  ").apply();
                                        whois.setText(prefs.getString("whoistr", ""));
                                        break;
                                    case "maintenance":
                                        prefs.edit().putString("checkedmaintenance", "true").apply();
                                        whoistr = prefs.getString("whoistr", "");
                                        prefs.edit().putString("whoistr", whoistr + "  Pedro Marques  ").apply();
                                        whois.setText(prefs.getString("whoistr", ""));
                                        break;
                                }
                            }else{
                                String whoistr = "";
                                String username = prefs.getString("usernametext", "tenant");

                                switch (username) {
                                    case "tenant":
                                        prefs.edit().putString("checkedtenant", "false").apply();
                                        whoistr = prefs.getString("whoistr", "");
                                        whoistr = whoistr.replace("  Joana Castelo-Branco  ", "");
                                        prefs.edit().putString("whoistr", whoistr).apply();
                                        whois.setText(prefs.getString("whoistr", ""));
                                        break;
                                    case "manager":
                                        prefs.edit().putString("checkedmanager", "false").apply();
                                        whoistr = prefs.getString("whoistr", "");
                                        whoistr = whoistr.replace("  Joaquim Inácio  ", "");
                                        prefs.edit().putString("whoistr", whoistr).apply();
                                        whois.setText(prefs.getString("whoistr", ""));
                                        break;
                                    case "maintenance":
                                        prefs.edit().putString("checkedmaintenance", "false").apply();
                                        whoistr = prefs.getString("whoistr", "");
                                        whoistr = whoistr.replace("  Pedro Marques  ", "");
                                        prefs.edit().putString("whoistr", whoistr).apply();
                                        whois.setText(prefs.getString("whoistr", ""));
                                        break;
                                }
                            }
                        }
                    });
                }
            }
        });







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
