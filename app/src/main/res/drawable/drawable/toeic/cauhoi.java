package com.example.toeic;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.IOException;

public class cauhoi extends AppCompatActivity {
    com.example.toeic.DatabaseHandler db = new com.example.toeic.DatabaseHandler(this);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cauhoi);
        try {
            db.copyDB2SDCard();
            int sbg = db.GetCount("select * from cauhoi");
            Toast.makeText(this, "Số bản ghi: " + sbg, Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
