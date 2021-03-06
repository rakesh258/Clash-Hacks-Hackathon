package com.dipakkr.github.clashhackproject.employer;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.dipakkr.github.clashhackproject.Employee.adapter.ViewPagerAdapter;
import com.dipakkr.github.clashhackproject.R;
import com.dipakkr.github.clashhackproject.employer.adapter.MyPagerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by deepak on 26-03-2017.
 */

public class EmployerProfile extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseUser mUser;
    private boolean backPressedOnce = false;

    ViewPager viewPager;
    MyPagerAdapter adapter;
    TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_profile);
        Toolbar toolbar  =(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        adapter = new MyPagerAdapter(this,getSupportFragmentManager());
        tabLayout = (TabLayout)findViewById(R.id.tabs);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        firebaseAuth = FirebaseAuth.getInstance();
        mUser = firebaseAuth.getCurrentUser();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_profile,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.logout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(getApplicationContext(),EmployerRegistration.class));
        }
        return super.onOptionsItemSelected(item);
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
