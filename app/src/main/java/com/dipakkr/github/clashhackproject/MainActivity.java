package com.dipakkr.github.clashhackproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.dipakkr.github.clashhackproject.Employee.EmployeeLogin;
import com.dipakkr.github.clashhackproject.employer.EmployerRegistration;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button bt_empoloyer, bt_employee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bt_employee = (Button)findViewById(R.id.bt_employee);
        bt_empoloyer = (Button)findViewById(R.id.bt_employer);


        bt_employee.setOnClickListener(this);
        bt_empoloyer.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id){
            case R.id.bt_employee :
                startActivity(new Intent(getApplicationContext(), EmployeeLogin.class));
                break;

            case R.id.bt_employer :
                startActivity(new Intent(getApplicationContext(), EmployerRegistration.class));

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                // do what you want here
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
