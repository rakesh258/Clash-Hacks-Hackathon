package com.dipakkr.github.clashhackproject.employer;

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
import com.dipakkr.github.clashhackproject.employer.model.Employer;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by deepak on 26-03-2017.
 */

public class EmployerLogin extends AppCompatActivity{

    EditText et_email, et_pass;
    Button bt_login;
    TextView txt_reg;
    ProgressDialog dialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_login);

        firebaseAuth = FirebaseAuth.getInstance();

        et_email = (EditText)findViewById(R.id.emp_email);
        et_pass = (EditText)findViewById(R.id.emp_pass);
        bt_login = (Button)findViewById(R.id.bt_login);
        txt_reg = (TextView)findViewById(R.id.txt_reg);

        dialog = new ProgressDialog(this);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

        txt_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Back to Registration
                finish();
            }
        });
    }
    private void signIn(){
        String email = et_email.getText().toString();
        String pass = et_pass.getText().toString();

        dialog.setMessage("Logging In Please Wait..");
        dialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(EmployerLogin.this, "Registration Succesfull", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), EmployerProfile.class));

                        }
                        else{
                            Toast.makeText(EmployerLogin.this, "Login Failed..", Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                });
    }
}
