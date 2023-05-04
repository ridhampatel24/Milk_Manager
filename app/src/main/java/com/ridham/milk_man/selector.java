package com.ridham.milk_man;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class selector extends AppCompatActivity {

    Button btnuser;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_selector);



        ImageView call = findViewById(R.id.image_call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(selector.this, "Call", Toast.LENGTH_SHORT).show();
                String number = getString(R.string.adminno);
                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });


        //Temp
         btnuser = findViewById(R.id.milkproviderpage);
        btnuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), milkmanDashboard.class);
                startActivity(intent);
            }
        });


        Button btnskip = findViewById(R.id.buttonskip);
        btnskip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),registeruser.class);
                startActivity(intent);
            }
        });





    }




}