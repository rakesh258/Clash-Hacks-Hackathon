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

import org.w3c.dom.Text;

/**
 * Created by deepak on 25-03-2017.
 */

public class EmployeeRegistration extends AppCompatActivity {
    EditText mEmail, mPass;
    Button mRegister;
    TextView mLogin;

    private FirebaseUser mUser;
    private FirebaseAuth mAuth;
    ProgressDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_reg);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        mEmail = (EditText) findViewById(R.id.emp_email);
        mPass = (EditText) findViewById(R.id.emp_pass);
        mRegister = (Button) findViewById(R.id.bt_register);
        mLogin = (TextView)findViewById(R.id.txt_login);

        dialog = new ProgressDialog(this);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString();
                String pass = mPass.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(getApplicationContext(), "Enter Pass", Toast.LENGTH_SHORT).show();
                    return;
                }

                dialog.setMessage("Registering..");
                dialog.show();

                mAuth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    dialog.dismiss();
                                    startActivity(new Intent(getApplicationContext(), EmployeePreUpdateProfile.class));
                                } else {
                                    dialog.dismiss();
                                    Toast.makeText(EmployeeRegistration.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(getApplicationContext(),EmployeeLogin.class));
            }
        });
    }
}
