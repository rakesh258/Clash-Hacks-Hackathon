package com.dipakkr.github.clashhackproject.Employee;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dipakkr.github.clashhackproject.R;

/**
 * Created by admin on 25-03-2017.
 */

public class EmployeeLogin extends AppCompatActivity {


    private static final String TAG = "LoginActivity";

    private EditText emailAadharInput;
    private EditText passwordInput;
    private Button loginButton;
    private TextView signup;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailAadharInput = (EditText) findViewById(R.id.emailAadhar);
        passwordInput = (EditText) findViewById(R.id.input_password);
        loginButton = (Button) findViewById(R.id.btn_login);
        signup = (TextView) findViewById(R.id.link_signup);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupIntent = new Intent(getApplicationContext(), EmployeeSignup.class);
                startActivity(signupIntent);
            }
        });
    }

    private void login() {

        if(!validateLogin()) {
            loginFailed();
            return;
        }

        loginButton.setEnabled(true);
    }


    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    private void  loginSuccess() {
        loginButton.setEnabled(true);
        finish();
    }

    private void loginFailed() {
        Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
        loginButton.setEnabled(true);
    }

    private boolean validateLogin() {
        boolean valid = true;

        String email = emailAadharInput.getText().toString();
        String password = passwordInput.getText().toString();

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailAadharInput.setError("enter a valid email address");
            valid = false;
        } else {
            emailAadharInput.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            passwordInput.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            passwordInput.setError(null);
        }

        return valid;
    }
}
