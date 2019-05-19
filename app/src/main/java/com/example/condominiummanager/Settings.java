package com.example.condominiummanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.condominiummanager.ui.login.LoginActivity;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ImageView go_back = findViewById(R.id.go_back_settings);

        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        final Switch email_privacy = findViewById((R.id.email_privacy));
        final Switch mobile_privacy = findViewById((R.id.mobile_privacy));

        final ImageView public_email = findViewById((R.id.public_email));
        final ImageView privacy_email = findViewById((R.id.private_email));
        final ImageView public_mobile = findViewById((R.id.public_mobile));
        final ImageView privacy_mobile = findViewById((R.id.private_mobile));

        email_privacy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(email_privacy.isChecked()){
                    public_email.setImageResource(R.mipmap.public_enable_icon);
                    privacy_email.setImageResource(R.mipmap.private_disable_icon);
                }else{
                    public_email.setImageResource(R.mipmap.public_disable_icon);
                    privacy_email.setImageResource(R.mipmap.private_enable_icon);
                }
            }
        });

        mobile_privacy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(mobile_privacy.isChecked()){
                    public_mobile.setImageResource(R.mipmap.public_enable_icon);
                    privacy_mobile.setImageResource(R.mipmap.private_disable_icon);
                }else{
                    public_mobile.setImageResource(R.mipmap.public_disable_icon);
                    privacy_mobile.setImageResource(R.mipmap.private_enable_icon);
                }
            }
        });

        final CheckBox first_delete_checkbox = findViewById((R.id.delete_account_checkBox));
        final CheckBox second_delete_checkbox = findViewById(R.id.delete_account_confirm_checkBox);
        final ImageView delete_account_rect = findViewById(R.id.delete_account_confirm_rectang);
        final TextView delete_account_text = findViewById(R.id.delete_account_forsure);
        final Button logOutBtn = findViewById(R.id.logOutButton);
        first_delete_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if(isChecked) {
                    second_delete_checkbox.setVisibility(View.VISIBLE);
                    delete_account_rect.setVisibility(View.VISIBLE);
                    delete_account_text.setVisibility(View.VISIBLE);
                    ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) logOutBtn.getLayoutParams();
                    params.verticalBias = 0.76f; // here is one modification for example. modify anything else you want :)
                    logOutBtn.setLayoutParams(params); // request the view to use the new modified params
                } else {
                    second_delete_checkbox.setVisibility(View.INVISIBLE);
                    delete_account_rect.setVisibility(View.INVISIBLE);
                    delete_account_text.setVisibility(View.INVISIBLE);
                    ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) logOutBtn.getLayoutParams();
                    params.verticalBias = 0.13f; // here is one modification for example. modify anything else you want :)
                    logOutBtn.setLayoutParams(params); // request the view to use the new modified params
                }
           }
        });


        final Button delete_account_button = findViewById(R.id.delete_account_confirm);
        second_delete_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if(isChecked) {
                    delete_account_button.setVisibility(View.VISIBLE);
                } else {
                    delete_account_button.setVisibility(View.INVISIBLE);
                }
            }
        });
        delete_account_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });
        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
