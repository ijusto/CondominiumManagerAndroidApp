package com.example.condominiummanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileTenant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_tenant);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final SharedPreferences prefs = this.getSharedPreferences("com.example.condominiummanager", Context.MODE_PRIVATE);

        final ImageView go_back = findViewById(R.id.go_back_profile_tenant);

        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final Button edit = findViewById(R.id.edit);



        TextView emailtext = findViewById(R.id.emailtext);
        TextView mobiletext = findViewById(R.id.mobiletext);

        emailtext.setText(prefs.getString("tenantemail", "jcb@sapo.pt"));
        mobiletext.setText(prefs.getString("tenantmobile", "919999999"));

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

                }else{                    EditText editmail = findViewById(R.id.editemail);
                    TextView emailtext = findViewById(R.id.emailtext);
                    EditText editmobile = findViewById(R.id.editmobile);
                    TextView mobiletext = findViewById(R.id.mobiletext);


                    String email = editmail.getText().toString();
                    String mobile = editmobile.getText().toString();
                    prefs.edit().putString("tenantemail",email).apply();
                    prefs.edit().putString("tenantmobile",mobile).apply();
                    emailtext.setText(email);
                    mobiletext.setText(mobile);
                    emailtext.setVisibility(View.VISIBLE);
                    editmail.setVisibility(View.INVISIBLE);
                    mobiletext.setVisibility(View.VISIBLE);
                    editmobile.setVisibility(View.INVISIBLE);

                    Toast toast = Toast.makeText(getApplicationContext(), "Saved successfully", Toast.LENGTH_SHORT);
                    toast.show();

                    edit.setText("Edit");
                }
            }
        });
    }

}
