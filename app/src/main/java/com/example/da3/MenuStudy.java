package com.example.da3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.example.da3.chude.chude;
import com.example.da3.study.grammar;
import com.example.da3.study.incomplete;
import com.example.da3.study.textcompletion;

public class MenuStudy extends AppCompatActivity implements View.OnClickListener {
    DatabaseHandler db = new DatabaseHandler(this);
    private TextView tv1,tv2,tv3,tv4,tv5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        final CardView cardView1=(CardView)findViewById(R.id.tb1);
        final CardView cardView2=(CardView)findViewById(R.id.tb2);
        final CardView cardView3=(CardView)findViewById(R.id.tb3);
        final CardView cardView4=(CardView)findViewById(R.id.tb4);
        TextView tv1=(TextView)findViewById(R.id.tv1);
        TextView tv2=(TextView)findViewById(R.id.tv2);
        TextView tv3=(TextView)findViewById(R.id.tv3);
        TextView tv4=(TextView)findViewById(R.id.tv4);
        TextView tv5=(TextView)findViewById(R.id.tv5);

        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);
        cardView4.setOnClickListener(this);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.mo);
        tv1.setAnimation(animation);
        tv2.setAnimation(animation);
        tv3.setAnimation(animation);
        tv4.setAnimation(animation);
        tv5.setAnimation(animation);
    }


    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.tb1:
                i=new Intent(this, chude.class);
                startActivity(i);
                break;
            case R.id.tb2:
                i=new Intent(this, grammar.class);
                startActivity(i);
                break;
            case R.id.tb3:
                i=new Intent(this, textcompletion.class);
                startActivity(i);
                break;
            case R.id.tb4:
                i=new Intent(this, incomplete.class);
                startActivity(i);
                break;

        }

    }
}
