package com.dipakkr.github.clashhackproject.employer.fragments;

import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.dipakkr.github.clashhackproject.R;
import com.dipakkr.github.clashhackproject.employer.model.Employer;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by deepak on 26-03-2017.
 */

public class EmployerSetting extends Fragment {

    private FirebaseAuth mAuth;
    private DatabaseReference mRef;
    private ValueEventListener mValueEventListener;
    private static String TAG = EmployerSetting.class.getSimpleName();

    TextView name, intro, city, mobile, email, interest;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.employer_setting,container,false);

        mAuth = FirebaseAuth.getInstance();
        mRef = FirebaseDatabase.getInstance().getReference("employee").getRef();

        name = (TextView)view.findViewById(R.id.emp_res_name);
        intro = (TextView)view.findViewById(R.id.emp_res_brief);
        city = (TextView)view.findViewById(R.id.emp_res_city);
        mobile = (TextView)view.findViewById(R.id.emp_result_mobile);
        interest = (TextView)view.findViewById(R.id.emp_result_skill);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Employer employer = dataSnapshot.getValue(Employer.class);
                name.setText(employer.org_name);
                intro.setText(employer.org_intro);
                city.setText(employer.org_city);
                mobile.setText(employer.org_mobile);
                interest .setText(employer.skills_required);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getActivity(), "Error in Retriving Data", Toast.LENGTH_SHORT).show();
            }
        };
        mRef.addValueEventListener(valueEventListener);
        mValueEventListener = valueEventListener;
    }

    @Override
    public void onStop() {
        super.onStop();
        if(mValueEventListener != null){
            mRef.addValueEventListener(mValueEventListener);

        }
    }
}
