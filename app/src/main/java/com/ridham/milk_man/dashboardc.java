package com.ridham.milk_man;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class dashboardc extends AppCompatActivity {

    static final int PICK_CONTACT=1;
    String number = "";
    ListView listView;
    String name;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboardc);

        textView = findViewById(R.id.number);
        Button btn = findViewById(R.id.getnumber);

        //if(ContextCompat.checkSelfPermission(dashboardc.this,Manifest.permission.))

        //ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.},1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent, PICK_CONTACT);
                //textView.setText(number);
            }
        });


        listView = findViewById(R.id.listview);
        List<String> name = new ArrayList<>();

        name.add("Rahim");
        name.add("Ram");
        name.add("Ali");

        Myadapter myadapter = new Myadapter(this,name);
        listView.setAdapter(myadapter);







    }

    @SuppressLint("Range")
    @Override
    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);

        switch (reqCode) {
            case (PICK_CONTACT) :
                if (resultCode == Activity.RESULT_OK) {
                    Uri contactData = data.getData();
                    Cursor c =  managedQuery(contactData, null, null, null, null);
                    if (c.moveToFirst()) {

                        String id =c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts._ID));
                        @SuppressLint("Range") String hasPhone =c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));

                        if (hasPhone.equalsIgnoreCase("1")) {
                            Cursor phones = getContentResolver().query(
                                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,
                                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = "+ id,
                                    null, null);
                            phones.moveToFirst();

                            String cname = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                            String cNumber = phones.getString(phones.getColumnIndex("data1"));
                            number = cNumber;
                            name = cname;
                            textView.setText(cNumber);
                            System.out.println("number is:"+cNumber);
                        }


                    }
                }
                break;
        }
    }


}