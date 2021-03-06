package com.dipakkr.github.clashhackproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.dipakkr.github.clashhackproject.Employee.EmployeeLogin;
import com.dipakkr.github.clashhackproject.Employee.EmployeeRegistration;
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
                startActivity(new Intent(getApplicationContext(), EmployeeRegistration.class));
                break;

            case R.id.bt_employer :
                startActivity(new Intent(getApplicationContext(), EmployerRegistration.class));
                break;
        }
    }

}
