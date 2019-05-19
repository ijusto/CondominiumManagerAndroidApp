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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.condominiummanager.ui.login.LoginActivity;

import org.w3c.dom.Text;

import java.util.HashSet;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final SharedPreferences prefs = this.getSharedPreferences("com.example.condominiummanager", Context.MODE_PRIVATE);


        final ImageView go_back = findViewById(R.id.go_back_register);

        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });

        final Button register = findViewById(R.id.reg_button);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Thankyou.class));
            }
        });



        TextView name = findViewById(R.id.fullname);
        TextView addr = findViewById(R.id.addressreg);
        TextView email = findViewById(R.id.email);

        prefs.edit().putString("name", name.getText().toString()).apply();
        prefs.edit().putString("addr", addr.getText().toString()).apply();
        prefs.edit().putString("email", email.getText().toString()).apply();





    }

}
