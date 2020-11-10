package com.example.toeic;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splash extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        ImageView img=(ImageView)findViewById(R.id.img);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(com.example.toeic.splash.this, com.example.toeic.MainActivity.class);
                startActivity(i);
                finish();
            }
        },3000);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.mo);
        img.startAnimation(animation);
    }
}
