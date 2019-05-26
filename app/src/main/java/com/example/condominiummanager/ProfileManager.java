package com.example.condominiummanager;

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
import android.widget.Toast;

import com.example.condominiummanager.ui.login.LoginActivity;

public class ProfileManager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_manager);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final SharedPreferences prefs = this.getSharedPreferences("com.example.condominiummanager", MODE_PRIVATE);

        final ImageView go_back = findViewById(R.id.go_back_profile_manager);

        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final Button edit = findViewById(R.id.edit);
        final ImageView showpass = findViewById(R.id.showpass_manager);
        final ImageView hidepass = findViewById(R.id.hidepass_manager);

        TextView emailtext = findViewById(R.id.emailtext_manager);
        TextView mobiletext = findViewById(R.id.mobiletext_manager);
        TextView password = findViewById(R.id.passwordtext_manager);



        emailtext.setText(prefs.getString("manageremail", "joaquim_inac@sapo.pt"));
        mobiletext.setText(prefs.getString("managermobile", "919999123"));
        password.setText(new String(new char[prefs.getString("managerpassword", "").length()]).replace("\0", "*"));


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit.getText().equals("Edit Personal Info")){
                    EditText editmail = findViewById(R.id.editemail_manager);
                    TextView emailtext = findViewById(R.id.emailtext_manager);
                    EditText editmobile = findViewById(R.id.editmobile_manager);
                    TextView mobiletext = findViewById(R.id.mobiletext_manager);
                    TextView password = findViewById(R.id.passwordtext_manager);
                    final EditText editpassword =  findViewById(R.id.editpassword_manager);

                    String mobile = mobiletext.getText().toString();
                    String email = emailtext.getText().toString();
                    String passwordstr = prefs.getString("managerpassword", "");
                    editmail.setText(email);
                    editmobile.setText(mobile);
                    editpassword.setText(passwordstr);


                    emailtext.setVisibility(View.INVISIBLE);
                    editmail.setVisibility(View.VISIBLE);
                    mobiletext.setVisibility(View.INVISIBLE);
                    editmobile.setVisibility(View.VISIBLE);
                    editpassword.setVisibility(View.VISIBLE);
                    password.setVisibility(View.INVISIBLE);
                    showpass.setVisibility(View.VISIBLE);



                    showpass.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            editpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            showpass.setVisibility(View.GONE);
                            hidepass.setVisibility(View.VISIBLE);
                        }
                    });

                    hidepass.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            editpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            hidepass.setVisibility(View.GONE);
                            showpass.setVisibility(View.VISIBLE);
                        }
                    });


                    edit.setText("Save");

                }else{
                    EditText editmail = findViewById(R.id.editemail_manager);
                    TextView emailtext = findViewById(R.id.emailtext_manager);
                    EditText editmobile = findViewById(R.id.editmobile_manager);
                    TextView mobiletext = findViewById(R.id.mobiletext_manager);
                    TextView password = findViewById(R.id.passwordtext_manager);
                    EditText editpassword =  findViewById(R.id.editpassword_manager);


                    String email = editmail.getText().toString();
                    String mobile = editmobile.getText().toString();
                    String passwordstr = editpassword.getText().toString();
                    prefs.edit().putString("manageremail",email).apply();
                    prefs.edit().putString("managermobile",mobile).apply();
                    prefs.edit().putString("managerpassword", passwordstr).apply();
                    emailtext.setText(email);
                    mobiletext.setText(mobile);
                    password.setText(new String(new char[passwordstr.length()]).replace("\0", "*"));
                    emailtext.setVisibility(View.VISIBLE);
                    editmail.setVisibility(View.INVISIBLE);
                    mobiletext.setVisibility(View.VISIBLE);
                    editmobile.setVisibility(View.INVISIBLE);
                    password.setVisibility(View.VISIBLE);
                    editpassword.setVisibility(View.INVISIBLE);
                    hidepass.setVisibility(View.GONE);
                    showpass.setVisibility(View.GONE);

                    Toast toast = Toast.makeText(getApplicationContext(), "Saved successfully", Toast.LENGTH_SHORT);
                    toast.show();

                    edit.setText("Edit Personal Info");
                }
            }
        });
        final Button logOutBtn = findViewById(R.id.logout_profile_manager);
        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });
        final Button settings = findViewById(R.id.settings_profile_manager);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Settings.class);
                startActivity(i);
            }
        });
    }

}
