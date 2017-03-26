package com.dipakkr.github.clashhackproject.Employee;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dipakkr.github.clashhackproject.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

/**
 * Created by deepak on 25-03-2017.
 */

public class EmployeePreUpdateProfile extends AppCompatActivity{

    private FirebaseDatabase mdatabase;
    private FirebaseAuth mAuth;
    private DatabaseReference mRef;
    private FirebaseStorage mstorage;
    private StorageReference emp_image_reference;
    private static final int RC_PHOTO_PICKER = 1;

    ImageView emp_image;
    EditText emp_name, emp_age, emp_city, emp_mobile, emp_skill;
    Button emp_save;
    Spinner emp_gender;
    String emp_img_url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_pre_update);

        mdatabase = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        mRef = mdatabase.getReference().child("employer");
        mstorage = FirebaseStorage.getInstance();
        emp_image_reference = mstorage.getReference().child("user_image");

        emp_name = (EditText) findViewById(R.id.employee_name);
        emp_age = (EditText) findViewById(R.id.employee_age);
        emp_city = (EditText) findViewById(R.id.employee_city);
        emp_mobile = (EditText) findViewById(R.id.employee_mobile);
        emp_skill = (EditText) findViewById(R.id.employee_skill);
        emp_save = (Button) findViewById(R.id.bt_save);
        emp_gender = (Spinner) findViewById(R.id.spinnner_gender);

        //image picker to select user image
        emp_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.setType("image/jpeg");
                i.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
                startActivityForResult(Intent.createChooser(i, "Complete action using"), RC_PHOTO_PICKER);
            }
        });

        emp_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveProfile();
            }
        });

    }

    private void saveProfile() {
        String e_name = emp_name.getText().toString();
        String e_age = emp_age.getText().toString();
        String e_city = emp_age.getText().toString();
        String e_gender = "male";
        String e_mobile = emp_mobile.getText().toString();
        String e_skill = emp_skill.getText().toString();

        Employee employee = new Employee(e_name,e_age, e_gender, e_mobile, e_city,"12th", e_skill,
                "2year", "aadhar card", emp_img_url);
        mRef.push().setValue(employee);
        Toast.makeText(getApplicationContext(), "Database Updated", Toast.LENGTH_SHORT).show();
    }

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == RC_PHOTO_PICKER && resultCode == RESULT_OK) {
                Uri imageUri = data.getData();

                //get the reference to stored file at database
                StorageReference photoReference = emp_image_reference.child(imageUri.getLastPathSegment());

                //upload file to firebase
                photoReference.putFile(imageUri).addOnSuccessListener(this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Uri downloadUrl = taskSnapshot.getDownloadUrl();
                        assert downloadUrl != null;
                        emp_img_url = downloadUrl.toString();
                        Glide.with(emp_image.getContext())
                                .load(emp_img_url)
                                .into(emp_image);
                    }
                });
            }


    }*/


}
