package com.dipakkr.github.clashhackproject.employer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dipakkr.github.clashhackproject.R;
import com.dipakkr.github.clashhackproject.employer.model.Employer;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by deepak on 25-03-2017.
 */

public class EmployerPreProfileUpdate extends AppCompatActivity {

    private FirebaseDatabase mdatabase;
    private FirebaseAuth mAuth;
    private DatabaseReference mRef;

    EditText et_name, et_intro, et_city, et_mobile, et_skill;
    Button bt_upload;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_pre_update);

        mdatabase = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        mRef = mdatabase.getReference().child("employer");

        et_name = (EditText)findViewById(R.id.employer_name);
        et_intro = (EditText)findViewById(R.id.employer_intro);
        et_city = (EditText)findViewById(R.id.employer_city);
        et_mobile = (EditText)findViewById(R.id.employer_mobile);
        et_skill = (EditText)findViewById(R.id.employer_skill);
        bt_upload = (Button)findViewById(R.id.bt_upload);

        bt_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateProfile();
            }
        });
    }
    private void updateProfile(){
        //TODO add update profile code after making model
        String employer_name = et_name.getText().toString();
        String employer_intro = et_intro.getText().toString();
        String employer_city = et_city.getText().toString();
        String employer_mobile = et_mobile.getText().toString();
        String employer_email = "";
        String employer_skill = et_skill.getText().toString();

        Employer employer = new Employer(employer_name,employer_intro,employer_city,employer_mobile,employer_email, employer_skill);
        mRef.push().setValue(employer);

        Toast.makeText(getApplicationContext(),"Database Updated", Toast.LENGTH_SHORT).show();

    }
}
