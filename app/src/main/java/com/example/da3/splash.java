package com.example.da3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class splash extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        ImageView img1=(ImageView)findViewById(R.id.set1);
        ImageView img2=(ImageView)findViewById(R.id.set2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(splash.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },4000);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.mo_quay);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.mo);
        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.cl);

        img1.startAnimation(animation1);
        img2.startAnimation(animation2);
    }
}
