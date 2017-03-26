package com.dipakkr.github.clashhackproject.Employee;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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
 * Created by sagar on 25-03-2017.
 */

public class EmployeeLogin extends AppCompatActivity {


    private static final String TAG = "LoginActivity";

    private EditText mEmail;
    private EditText mPass;
    private Button bt_login;
    private TextView txt_register;

    private FirebaseAuth mAuth;
    ProgressDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        dialog = new ProgressDialog(this);

        mEmail = (EditText) findViewById(R.id.et_email);
        mPass = (EditText) findViewById(R.id.et_pass);
        bt_login = (Button) findViewById(R.id.btn_login);
        txt_register = (TextView) findViewById(R.id.txt_reg);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
        txt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), EmployeeRegistration.class));
            }
        });
    }
    private void loginUser(){
        String email = mEmail.getText().toString();
        String pass = mPass.getText().toString();

        dialog.setMessage("Logging In Please Wait..");
        dialog.show();

        mAuth.signInWithEmailAndPassword(email,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //Now open
                            dialog.dismiss();
                            startActivity(new Intent(getApplicationContext(),EmployeeProfile.class));
                        }
                        else {
                            dialog.dismiss();
                            Toast.makeText(EmployeeLogin.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}