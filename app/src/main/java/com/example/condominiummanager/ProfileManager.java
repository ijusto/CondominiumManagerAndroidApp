package com.example.condominiummanager;

import android.content.Intent;
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

public class ProfileManager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_manager);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ImageView go_back = findViewById(R.id.go_back_profile_manager);

        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        final Button edit = findViewById(R.id.edit);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit.getText().equals("Edit")){
                    EditText editmail = findViewById(R.id.editemail_manager);
                    TextView emailtext = findViewById(R.id.emailtext_manager);
                    EditText editmobile = findViewById(R.id.editmobile_manager);
                    TextView mobiletext = findViewById(R.id.mobiletext_manager);

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
                    EditText editmail = findViewById(R.id.editemail_manager);
                    TextView emailtext = findViewById(R.id.emailtext_manager);
                    EditText editmobile = findViewById(R.id.editmobile_manager);
                    TextView mobiletext = findViewById(R.id.mobiletext_manager);


                    String email = editmail.getText().toString();
                    String mobile = editmobile.getText().toString();
                    emailtext.setText(email);
                    mobiletext.setText(mobile);
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
