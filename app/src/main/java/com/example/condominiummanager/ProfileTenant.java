package com.example.condominiummanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileTenant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_tenant);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button edit = findViewById(R.id.edit);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit.getText().equals("Edit")){
                    EditText editmail = findViewById(R.id.editemail);
                    TextView emailtext = findViewById(R.id.emailtext);
                    EditText editmobile = findViewById(R.id.editmobile);
                    TextView mobiletext = findViewById(R.id.mobiletext);

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
                    EditText editmail = findViewById(R.id.editemail);
                    TextView emailtext = findViewById(R.id.emailtext);

                    String email = editmail.getText().toString();
                    emailtext.setText(email);

                    emailtext.setVisibility(View.VISIBLE);
                    editmail.setVisibility(View.INVISIBLE);


                    edit.setText("Edit");
                }
            }
        });
    }

}