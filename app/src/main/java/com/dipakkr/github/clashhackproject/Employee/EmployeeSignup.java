package com.dipakkr.github.clashhackproject.Employee;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dipakkr.github.clashhackproject.R;
import com.dipakkr.github.clashhackproject.employer.EmployerPreProfileUpdate;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by admin on 25-03-2017.
 */

public class EmployeeSignup extends AppCompatActivity {

    private static final String TAG = "SignupActivity";


    EditText emailAadharInput;
    EditText passwordInput;
    Button signupButton;
    TextView loginLink;

    private FirebaseUser mUser;
    private FirebaseAuth mAuth;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_employee);
        emailAadharInput = (EditText) findViewById(R.id.input_emailAadhar);

        passwordInput = (EditText) findViewById(R.id.input_password);

        signupButton = (Button) findViewById(R.id.btn_signup);

        loginLink = (TextView) findViewById(R.id.link_login);


        mAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this, R.style.AppTheme_Dark_Dialog);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // go back to login screen
                finish();
            }
        });
    }

    private void signup() {

        String emailAadhar = emailAadharInput.getText().toString();
        String password = passwordInput.getText().toString();

        if (TextUtils.isEmpty(emailAadhar)) {
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Enter Pass", Toast.LENGTH_SHORT).show();
        }

        progressDialog.setMessage("Registering...");

        mAuth.createUserWithEmailAndPassword(emailAadhar, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressDialog.dismiss();
                            finish();
                            startActivity(new Intent(getApplicationContext(), EmployerPreProfileUpdate.class));
                        }
                    }
                });


    }


}
