package com.example.da3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
        private CardView tvStudy,tvTest;
        TextView tv10,tv11,tv12,tv13,tv14,tv15,tv16,tv17,tv18;
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            tvStudy=(CardView) findViewById(R.id.tvStudy);
            tvTest=(CardView) findViewById(R.id.tvTest);

            tvStudy.setOnClickListener(this);
            tvTest.setOnClickListener(this);


            tv10=(TextView)findViewById(R.id.tv10);
            tv11=(TextView)findViewById(R.id.tv11);
            tv12=(TextView)findViewById(R.id.tv12);
            tv13=(TextView)findViewById(R.id.tv13);
            tv14=(TextView)findViewById(R.id.tv14);
            tv15=(TextView)findViewById(R.id.tv15);
            tv16=(TextView)findViewById(R.id.tv16);
            tv17=(TextView)findViewById(R.id.tv17);
            tv18=(TextView)findViewById(R.id.tv18);

            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.mo);

            tv10.setAnimation(animation);
            tv11.setAnimation(animation);
            tv12.setAnimation(animation);
            tv13.setAnimation(animation);
            tv14.setAnimation(animation);
            tv15.setAnimation(animation);
            tv16.setAnimation(animation);
            tv17.setAnimation(animation);
            tv18.setAnimation(animation);
        }

        @Override
        public void onClick(View view) {
            Intent i;
            switch (view.getId()){
                case R.id.tvStudy :
                    i=new Intent(this,MenuStudy.class);
                    startActivity(i);
                break;
                case R.id.tvTest :
                    i=new Intent(this,com.example.da3.test.test.class);
                    startActivity(i);
                    break;
            }
        }
    }
