package com.example.condominiummanager;

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
import android.widget.ImageView;
import android.widget.TextView;

public class profile_maintenance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_maintenance);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final SharedPreferences prefs = this.getSharedPreferences("com.example.condominiummanager", MODE_PRIVATE);


        final ImageView go_back = findViewById(R.id.go_back_profile_maintenance);

        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final Button edit = findViewById(R.id.edit);


        TextView emailtext = findViewById(R.id.emailtext_maintenance);
        TextView mobiletext = findViewById(R.id.mobiletext_maintenance);

        emailtext.setText(prefs.getString("maintenanceemail", "pedromarques@sapo.pt"));
        mobiletext.setText(prefs.getString("maintenancemobile", "919994524"));


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit.getText().equals("Edit")){
                    EditText editmail = findViewById(R.id.editemail_maintenance);
                    TextView emailtext = findViewById(R.id.emailtext_maintenance);
                    EditText editmobile = findViewById(R.id.editmobile_maintenance);
                    TextView mobiletext = findViewById(R.id.mobiletext_maintenance);

                    String mobile = mobiletext.getText().toString();
                    String email = emailtext.getText().toString();
                    editmail.setText(email);
                    editmobile.setText(mobile);

                    emailtext.setVisibility(View.INVISIBLE);
                    editmail.setVisibility(View.VISIBLE);
                    mobiletext.setVisibility(View.INVISIBLE);
                    editmobile.setVisibility(View.VISIBLE);


                    edit.setText("Save");

                }else{
                    EditText editmail = findViewById(R.id.editemail_maintenance);
                    TextView emailtext = findViewById(R.id.emailtext_maintenance);
                    EditText editmobile = findViewById(R.id.editmobile_maintenance);
                    TextView mobiletext = findViewById(R.id.mobiletext_maintenance);


                    String email = editmail.getText().toString();
                    String mobile = editmobile.getText().toString();
                    emailtext.setText(email);
                    mobiletext.setText(mobile);
                    prefs.edit().putString("maintenanceemail",email).apply();
                    prefs.edit().putString("maitenancemobile",mobile).apply();
                    emailtext.setVisibility(View.VISIBLE);
                    editmail.setVisibility(View.INVISIBLE);
                    mobiletext.setVisibility(View.VISIBLE);
                    editmobile.setVisibility(View.INVISIBLE);


                    edit.setText("Edit");
                }
            }
        });
    }

}
