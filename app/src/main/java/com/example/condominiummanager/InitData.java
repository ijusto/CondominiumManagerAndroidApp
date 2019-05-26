package com.example.condominiummanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.condominiummanager.ui.login.LoginActivity;

public class InitData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final SharedPreferences prefs = this.getSharedPreferences("com.example.condominiummanager", Context.MODE_PRIVATE);

        prefs.edit().putString("manageremail","joaquim_inac@sapo.pt").apply();
        prefs.edit().putString("managermobile", "919999123").apply();
        prefs.edit().putString("tenantemail", "jcb@sapo.pt").apply();
        prefs.edit().putString("tenantmobile", "919999999").apply();
        prefs.edit().putString("maintenanceemail", "pedromarques@sapo.pt").apply();
        prefs.edit().putString("maintenancemobile", "919994524").apply();
        prefs.edit().putString("tenantemailprivacy", "false").apply();
        prefs.edit().putString("manageremailprivacy", "false").apply();
        prefs.edit().putString("maintenanceemailprivacy", "false").apply();
        prefs.edit().putString("tenantmobileprivacy", "false").apply();
        prefs.edit().putString("managermobileprivacy", "false").apply();
        prefs.edit().putString("maintenancemobileprivacy", "false").apply();





        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }
}
