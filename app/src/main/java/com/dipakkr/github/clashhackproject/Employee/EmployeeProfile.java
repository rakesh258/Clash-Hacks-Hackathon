package com.dipakkr.github.clashhackproject.Employee;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.dipakkr.github.clashhackproject.Employee.adapter.ViewPagerAdapter;
import com.dipakkr.github.clashhackproject.R;
import com.dipakkr.github.clashhackproject.employer.EmployerRegistration;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.dipakkr.github.clashhackproject.R.id.logout;

/**
 * Created by deepak on 26-03-2017.
 */

public class EmployeeProfile extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseUser mUser;
    private boolean backPressedOnce = false;

    ViewPager viewPager;
    TabLayout tabLayout;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_profile);
        Toolbar toolbar  =(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseAuth = FirebaseAuth.getInstance();
        mUser = firebaseAuth.getCurrentUser();

        if(mUser == null){
            startActivity(new Intent(this, EmployerRegistration.class));
        }

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        viewPagerAdapter = new ViewPagerAdapter(getApplicationContext(),getSupportFragmentManager());
        tabLayout = (TabLayout)findViewById(R.id.tabs);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case logout:
                firebaseAuth.signOut();
                finish();
                Toast.makeText(getApplicationContext(), "You have successfully logged out :)", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), EmployeeLogin.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onBackPressed() {
        if(backPressedOnce ){

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }else if(!backPressedOnce){
            Toast.makeText(this,"Press again to exit",Toast.LENGTH_SHORT).show();
            backPressedOnce = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    backPressedOnce = false;
                }
            },2000);
        }
    }


}
