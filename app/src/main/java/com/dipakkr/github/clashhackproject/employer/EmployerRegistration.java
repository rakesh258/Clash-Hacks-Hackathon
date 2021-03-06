package com.dipakkr.github.clashhackproject.employer;

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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by deepak on 25-03-2017.
 */

public class EmployerRegistration extends AppCompatActivity {

    EditText mEmail, mPass;
    Button mRegister;
    TextView mTxtLogin;

    private FirebaseAuth mAuth;
    ProgressDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_employee);

        mAuth = FirebaseAuth.getInstance();

        mEmail = (EditText)findViewById(R.id.emp_email);
        mPass = (EditText)findViewById(R.id.emp_pass);
        mRegister = (Button)findViewById(R.id.bt_register);
        mTxtLogin = (TextView)findViewById(R.id.txt_login);

        dialog = new ProgressDialog(this);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });
        mTxtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),EmployerLogin.class));
            }
        });
    }
    private void createUser(){

        String email = mEmail.getText().toString();
        String pass = mPass.getText().toString();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this, "Enter Pass", Toast.LENGTH_SHORT).show();
        }

        dialog.setMessage("Registering");
        dialog.show();

        mAuth.createUserWithEmailAndPassword(email,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            finish();
                            startActivity(new Intent(getApplicationContext(), EmployerPreProfileUpdate.class));
                        }else{
                            Toast.makeText(EmployerRegistration.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                });
    }
}
