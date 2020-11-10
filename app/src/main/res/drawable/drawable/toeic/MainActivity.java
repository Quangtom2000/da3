package com.example.toeic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DatabaseHandler db = new DatabaseHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      final CardView cardView1=(CardView)findViewById(R.id.tb1);
        final CardView cardView2=(CardView)findViewById(R.id.tb2);
        final CardView cardView3=(CardView)findViewById(R.id.tb3);
        final CardView cardView4=(CardView)findViewById(R.id.tb4);
        final CardView cardView5=(CardView)findViewById(R.id.tb5);

       cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);
        cardView4.setOnClickListener(this);
        cardView5.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.tb1:
                i=new Intent(this,cauhoi.class);
                startActivity(i);
                break;
            case R.id.tb2:
                i=new Intent(this,cauhoi.class);
                startActivity(i);
                break;
            case R.id.tb3:
                i=new Intent(this,cauhoi.class);
                startActivity(i);
                break;
            case R.id.tb4:
                i=new Intent(this,cauhoi.class);
                startActivity(i);
                break;
            case R.id.tb5:
                i=new Intent(this,cauhoi.class);
                startActivity(i);
                break;
        }

    }
}
