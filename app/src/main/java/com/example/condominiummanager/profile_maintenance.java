package com.example.condominiummanager;

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

import com.example.condominiummanager.ui.login.LoginActivity;

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
        TextView password = findViewById(R.id.passwordtext_maintenance);

        emailtext.setText(prefs.getString("maintenanceemail", "pedromarques@sapo.pt"));
        mobiletext.setText(prefs.getString("maintenancemobile", "919994524"));
        password.setText(new String(new char[prefs.getString("maintenancepassword", "").length()]).replace("\0", "*"));



        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit.getText().equals("Edit Personal Info")){
                    EditText editmail = findViewById(R.id.editemail_maintenance);
                    TextView emailtext = findViewById(R.id.emailtext_maintenance);
                    EditText editmobile = findViewById(R.id.editmobile_maintenance);
                    TextView mobiletext = findViewById(R.id.mobiletext_maintenance);
                    TextView password = findViewById(R.id.passwordtext_maintenance);
                    EditText editpassword =  findViewById(R.id.editpassword_maintenance);

                    String mobile = mobiletext.getText().toString();
                    String email = emailtext.getText().toString();
                    String passwordstr = password.getText().toString();
                    editmail.setText(email);
                    editmobile.setText(mobile);
                    editpassword.setHint(passwordstr);


                    emailtext.setVisibility(View.INVISIBLE);
                    editmail.setVisibility(View.VISIBLE);
                    mobiletext.setVisibility(View.INVISIBLE);
                    editmobile.setVisibility(View.VISIBLE);
                    editpassword.setVisibility(View.VISIBLE);
                    password.setVisibility(View.INVISIBLE);


                    edit.setText("Save");
                }else{
                    EditText editmail = findViewById(R.id.editemail_maintenance);
                    TextView emailtext = findViewById(R.id.emailtext_maintenance);
                    EditText editmobile = findViewById(R.id.editmobile_maintenance);
                    TextView mobiletext = findViewById(R.id.mobiletext_maintenance);
                    TextView password = findViewById(R.id.passwordtext_maintenance);
                    EditText editpassword =  findViewById(R.id.editpassword_maintenance);


                    String email = editmail.getText().toString();
                    String mobile = editmobile.getText().toString();
                    String passwordstr = editpassword.getText().toString();
                    prefs.edit().putString("maintenanceemail",email).apply();
                    prefs.edit().putString("maintenancemobile",mobile).apply();
                    prefs.edit().putString("maintenancepassword", passwordstr).apply();
                    emailtext.setText(email);
                    mobiletext.setText(mobile);
                    password.setText(new String(new char[passwordstr.length()]).replace("\0", "*"));
                    emailtext.setVisibility(View.VISIBLE);
                    editmail.setVisibility(View.INVISIBLE);
                    mobiletext.setVisibility(View.VISIBLE);
                    editmobile.setVisibility(View.INVISIBLE);
                    password.setVisibility(View.VISIBLE);
                    editpassword.setVisibility(View.INVISIBLE);

                    Toast toast = Toast.makeText(getApplicationContext(), "Saved successfully", Toast.LENGTH_SHORT);
                    toast.show();

                    edit.setText("Edit Personal Info");
                }
            }
        });

        final Button logOutBtn = findViewById(R.id.logout_profile_maintenance);
        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });
        final Button settings = findViewById(R.id.settings_profile_maintenance);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Settings.class);
                startActivity(i);
            }
        });

    }

}
