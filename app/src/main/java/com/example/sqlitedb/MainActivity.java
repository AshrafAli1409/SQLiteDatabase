package com.example.sqlitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DbHandler handler=new DbHandler(this,"empdb",null,1);
        handler.addEmployee(new Employee(10,"Ashraf",33.8));
        handler.getEmployee(3);
        handler.close();
    }
}
