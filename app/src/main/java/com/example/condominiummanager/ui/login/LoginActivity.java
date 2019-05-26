package com.example.condominiummanager.ui.login;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.condominiummanager.Events;
import com.example.condominiummanager.MainActivity;
import com.example.condominiummanager.R;
import com.example.condominiummanager.Register;
import com.example.condominiummanager.Tenant;
import com.example.condominiummanager.ui.login.LoginViewModel;
import com.example.condominiummanager.ui.login.LoginViewModelFactory;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);
        final SharedPreferences prefs = this.getSharedPreferences("com.example.condominiummanager", Context.MODE_PRIVATE);
        final Context context = getApplicationContext();

        final String tenantuser = prefs.getString("tenantemail", "");
        final String tenantpassword = prefs.getString("tenantpassword", "");
        final String manageruser = prefs.getString("manageremail", "");
        final String managerpass = prefs.getString("managerpassword", "");
        final String maintenanceuser = prefs.getString("maintenanceemail", "");
        final String maintenancepass = prefs.getString("maintenancepassword", "");
        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);
        final Button registerbutton = findViewById(R.id.register);


        final TextView email_warning_login = findViewById(R.id.email_warning_login);
        final ImageView email_warning_login_icon = findViewById(R.id.email_warning_login_icon);
        final TextView password_warning_login = findViewById(R.id.password_warning_login);
        final ImageView password_warning_login_icon = findViewById(R.id.password_warning_login_icon);
        final ImageView showpassword = findViewById(R.id.showpassword);
        final ImageView hidepassword = findViewById(R.id.hidepassword);

        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                prefs.edit().putString("usernameregtext", username).apply();
                Intent i = new Intent(getApplicationContext(), Register.class);
                startActivity(i);
            }
        });

        showpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                showpassword.setVisibility(View.GONE);
                hidepassword.setVisibility(View.VISIBLE);
            }
        });

        hidepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                hidepassword.setVisibility(View.GONE);
                showpassword.setVisibility(View.VISIBLE);
            }
        });


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                CharSequence text = "Wrong password";
                CharSequence text2 = "Wrong username";
                int duration = Toast.LENGTH_SHORT;
                Toast passwordToast = Toast.makeText(context, text, duration);
                Toast usertoast = Toast.makeText(context, text2, duration);


                if(username.equals(tenantuser)){
                    if (password.equals(tenantpassword)){
                        prefs.edit().putString("usernametext", "tenant").apply();
                        startActivity(i);
                    }else{
                        passwordToast.show();
                    }
                }else if(username.equals(maintenanceuser)){
                    if (password.equals(maintenancepass)){
                        prefs.edit().putString("usernametext", "maintenance").apply();
                        startActivity(i);
                    }else{
                        passwordToast.show();
                    }
                }else if(username.equals(manageruser)){
                    if (password.equals(managerpass)) {
                        prefs.edit().putString("usernametext", "manager").apply();
                        startActivity(i);
                    } else {
                        passwordToast.show();
                    }
                }else{
                    usertoast.show();
                }



            }
        });



       /* loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null) {
                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) {
                    updateUiWithUser(loginResult.getSuccess());
                }
                setResult(Activity.RESULT_OK);

                //Complete and destroy login activity once successful
                finish();
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                loginViewModel.login(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        });
    }

    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }*/
    }
}
