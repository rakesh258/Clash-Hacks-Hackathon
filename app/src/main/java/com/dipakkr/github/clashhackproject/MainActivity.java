package com.dipakkr.github.clashhackproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.dipakkr.github.clashhackproject.Employee.EmployeeRegistration;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button bt_user, bt_admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_admin = (Button)findViewById(R.id.bt_admin);
        bt_user = (Button)findViewById(R.id.bt_user);

        bt_user.setOnClickListener(this);
        bt_admin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id){
            case R.id.bt_admin :
                startActivity(new Intent(getApplicationContext(), EmployeeRegistration.class));
                break;

            case R.id.bt_user :
                //break;

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
