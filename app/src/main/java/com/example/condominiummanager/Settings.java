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
        final SharedPreferences prefs = this.getSharedPreferences("com.example.condominiummanager", Context.MODE_PRIVATE);


        final ImageView go_back = findViewById(R.id.go_back_settings);

        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final Switch email_privacy = findViewById((R.id.email_privacy));
        final Switch mobile_privacy = findViewById((R.id.mobile_privacy));

        final ImageView public_email = findViewById((R.id.public_email));
        final ImageView privacy_email = findViewById((R.id.private_email));
        final ImageView public_mobile = findViewById((R.id.public_mobile));
        final ImageView privacy_mobile = findViewById((R.id.private_mobile));


        String username = prefs.getString("usernametext","tenant");

        switch (username){
            case "tenant":
                if(prefs.getString("tenantmobileprivacy","false").equals("false")){
                    public_mobile.setImageResource(R.mipmap.public_disable_icon);
                    privacy_mobile.setImageResource(R.mipmap.private_enable_icon);
                    mobile_privacy.setChecked(false);
                }else if(prefs.getString("tenantmobileprivacy","false").equals("true")){
                    public_mobile.setImageResource(R.mipmap.public_enable_icon);
                    privacy_mobile.setImageResource(R.mipmap.private_disable_icon);
                    mobile_privacy.setChecked(true);
                }
                if(prefs.getString("tenantemailprivacy","false").equals("false")){
                    public_email.setImageResource(R.mipmap.public_disable_icon);
                    privacy_email.setImageResource(R.mipmap.private_enable_icon);
                    email_privacy.setChecked(false);
                }else if(prefs.getString("tenantemailprivacy","false").equals("true")){
                    public_email.setImageResource(R.mipmap.public_enable_icon);
                    privacy_email.setImageResource(R.mipmap.private_disable_icon);
                    email_privacy.setChecked(true);
                }
                break;

            case "manager":
                if(prefs.getString("managermobileprivacy","false").equals("false")){
                    public_mobile.setImageResource(R.mipmap.public_disable_icon);
                    privacy_mobile.setImageResource(R.mipmap.private_enable_icon);
                    mobile_privacy.setChecked(false);
                }else if(prefs.getString("managermobileprivacy","false").equals("true")){
                    public_mobile.setImageResource(R.mipmap.public_enable_icon);
                    privacy_mobile.setImageResource(R.mipmap.private_disable_icon);
                    mobile_privacy.setChecked(true);
                }
                if(prefs.getString("manageremailprivacy","false").equals("false")){
                    public_email.setImageResource(R.mipmap.public_disable_icon);
                    privacy_email.setImageResource(R.mipmap.private_enable_icon);
                    email_privacy.setChecked(false);
                }else if(prefs.getString("manageremailprivacy","false").equals("true")){
                    public_email.setImageResource(R.mipmap.public_enable_icon);
                    privacy_email.setImageResource(R.mipmap.private_disable_icon);
                    email_privacy.setChecked(true);
                }
                break;

            case "maintenance":

                if(prefs.getString("maintenancemobileprivacy","false").equals("false")){
                    public_mobile.setImageResource(R.mipmap.public_disable_icon);
                    privacy_mobile.setImageResource(R.mipmap.private_enable_icon);
                    mobile_privacy.setChecked(false);
                }else if(prefs.getString("maintenancemobileprivacy","false").equals("true")){
                    public_mobile.setImageResource(R.mipmap.public_enable_icon);
                    privacy_mobile.setImageResource(R.mipmap.private_disable_icon);
                    mobile_privacy.setChecked(true);
                }
                if(prefs.getString("maintenanceemailprivacy","false").equals("false")){
                    public_email.setImageResource(R.mipmap.public_disable_icon);
                    privacy_email.setImageResource(R.mipmap.private_enable_icon);
                    email_privacy.setChecked(false);
                }else if(prefs.getString("maintenanceemailprivacy","false").equals("true")){
                    public_email.setImageResource(R.mipmap.public_enable_icon);
                    privacy_email.setImageResource(R.mipmap.private_disable_icon);
                    email_privacy.setChecked(true);
                }
                break;
        }


        email_privacy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(email_privacy.isChecked()){
                    String username = prefs.getString("usernametext", "tenant");
                    switch (username) {
                        case "tenant":
                            prefs.edit().putString("tenantemailprivacy", "true").apply();
                            break;
                        case "manager":
                            prefs.edit().putString("manageremailprivacy", "true").apply();
                            break;
                        case "maintenance":
                            prefs.edit().putString("maintenanceemailprivacy", "true").apply();
                            break;
                    }
                    public_email.setImageResource(R.mipmap.public_enable_icon);
                    privacy_email.setImageResource(R.mipmap.private_disable_icon);
                }else{
                    String username = prefs.getString("usernametext", "tenant");
                    switch (username) {
                        case "tenant":
                            prefs.edit().putString("tenantemailprivacy", "false").apply();
                            break;
                        case "manager":
                            prefs.edit().putString("manageremailprivacy", "false").apply();
                            break;
                        case "maintenance":
                            prefs.edit().putString("maintenanceemailprivacy", "false").apply();
                            break;
                    }
                    public_email.setImageResource(R.mipmap.public_disable_icon);
                    privacy_email.setImageResource(R.mipmap.private_enable_icon);
                }
            }
        });

        mobile_privacy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(mobile_privacy.isChecked()){
                    String username = prefs.getString("usernametext", "tenant");
                    switch (username) {
                        case "tenant":
                            prefs.edit().putString("tenantmobileprivacy", "true").apply();
                            break;
                        case "manager":
                            prefs.edit().putString("managermobileprivacy", "true").apply();
                            break;
                        case "maintenance":
                            prefs.edit().putString("maintenancemobileprivacy", "true").apply();
                            break;
                    }
                    public_mobile.setImageResource(R.mipmap.public_enable_icon);
                    privacy_mobile.setImageResource(R.mipmap.private_disable_icon);
                }else{
                    String username = prefs.getString("usernametext", "tenant");
                    switch (username) {
                        case "tenant":
                            prefs.edit().putString("tenantmobileprivacy", "false").apply();
                            break;
                        case "manager":
                            prefs.edit().putString("managermobileprivacy", "false").apply();
                            break;
                        case "maintenance":
                            prefs.edit().putString("maintenancemobileprivacy", "false").apply();
                            break;
                    }

                    public_mobile.setImageResource(R.mipmap.public_disable_icon);
                    privacy_mobile.setImageResource(R.mipmap.private_enable_icon);
                }
            }
        });

        final CheckBox first_delete_checkbox = findViewById((R.id.delete_account_checkBox));
        final CheckBox second_delete_checkbox = findViewById(R.id.delete_account_confirm_checkBox);
        final ImageView delete_account_rect = findViewById(R.id.delete_account_confirm_rectang);
        final TextView delete_account_text = findViewById(R.id.delete_account_forsure);

        first_delete_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if(isChecked) {
                    second_delete_checkbox.setVisibility(View.VISIBLE);
                    delete_account_rect.setVisibility(View.VISIBLE);
                    delete_account_text.setVisibility(View.VISIBLE);
                } else {
                    second_delete_checkbox.setVisibility(View.INVISIBLE);
                    delete_account_rect.setVisibility(View.INVISIBLE);
                    delete_account_text.setVisibility(View.INVISIBLE);
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

    }
}
