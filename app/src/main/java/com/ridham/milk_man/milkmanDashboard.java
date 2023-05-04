package com.ridham.milk_man;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class milkmanDashboard extends AppCompatActivity {
    ListView customerlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milkman_dashboard);
        customerlist = findViewById(R.id.customerList);
        List<String> name = new ArrayList<>();

        name.add("Rahim");
        name.add("Ram");
        name.add("Ali");

        customerAdapter adapter = new customerAdapter(this,name);
        customerlist.setAdapter(adapter);
    }
}