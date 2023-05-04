package com.ridham.milk_man;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class registeruser extends AppCompatActivity {

//    EditText editText = findViewById(R.id.full_name);
//    EditText areaText = findViewById(R.id.area);
//    EditText addressText = findViewById(R.id.address);
    Boolean registeredUser = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_registeruser);

        TextInputEditText editText = findViewById(R.id.full_name);
        TextInputEditText areaText = findViewById(R.id.area);
        TextInputEditText addressText = findViewById(R.id.address);


        Button btn = findViewById(R.id.btnregister);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registeredUser = true;
                SharedPreferences shrd = getSharedPreferences("user",MODE_PRIVATE);
                SharedPreferences.Editor editor = shrd.edit();
                editor.putBoolean("registeredUser",registeredUser);
                editor.apply();
                Intent intent = new Intent(getApplicationContext(), dashboardc.class);
                startActivity(intent);
            }
        });

        String name = editText.getText().toString().trim();
        String area = areaText.getText().toString().trim();
        String address = addressText.getText().toString().trim();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!name.isEmpty() && !area.isEmpty() && !address.isEmpty() ){

                    Intent intent = new Intent(getApplicationContext(),hello.class);
                    startActivity(intent);
                } else{
                    Toast.makeText(registeruser.this, "Enter all Details", Toast.LENGTH_SHORT).show();
                }

                if(name.isEmpty()){
                    if(area.isEmpty()){
                        if(address.isEmpty()){
                            Intent intent = new Intent(getApplicationContext(),hello.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(registeruser.this, "Enter Address", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(registeruser.this, "Enter Area", Toast.LENGTH_SHORT).show();
                    }
                } else{
                    Toast.makeText(registeruser.this, "Enter Name", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}