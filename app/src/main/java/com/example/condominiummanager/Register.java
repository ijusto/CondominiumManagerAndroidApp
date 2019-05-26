package com.example.condominiummanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
                finish();
            }
        });

        final Button register = findViewById(R.id.reg_button);
        TextView email = findViewById(R.id.email);
        email.setText(prefs.getString("usernameregtext", ""));

        final ImageView showpassword = findViewById(R.id.showpassword_register);
        final ImageView hidepassword = findViewById(R.id.hidepassword_register);
        final EditText  passwordtext = findViewById(R.id.password);


        showpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordtext.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                showpassword.setVisibility(View.GONE);
                hidepassword.setVisibility(View.VISIBLE);
            }
        });

        hidepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordtext.setTransformationMethod(PasswordTransformationMethod.getInstance());
                hidepassword.setVisibility(View.GONE);
                showpassword.setVisibility(View.VISIBLE);
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView name = findViewById(R.id.fullname);
                TextView addr = findViewById(R.id.addressreg);
                TextView email = findViewById(R.id.email);

                prefs.edit().putString("namereg", name.getText().toString()).apply();
                prefs.edit().putString("addrreg", addr.getText().toString()).apply();
                prefs.edit().putString("emailreg", email.getText().toString()).apply();
                prefs.edit().putString("regdone", "true").apply();

                startActivity(new Intent(getApplicationContext(), Thankyou.class));
            }
        });









    }

}
