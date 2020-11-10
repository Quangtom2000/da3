package com.example.da3.study;

import android.app.Dialog;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.da3.DatabaseHandler;
import com.example.da3.R;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class textcompletion extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    ArrayList<CauHoi> listCauHoi = new ArrayList<>();
    private TextView tvCauHoi,socau,diem12;
    private Button daA, daB, daC, daD, kt;
    Button[] bt;
    CauHoi qs;
    int i = 0, Dapandung, diem;
    Dialog dialog;
    private boolean check;
    private boolean run;
    private boolean checkdapan;
    private android.os.Handler handler = new android.os.Handler();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        db.copyDB2SDCard();



        AnhXa();
        LoadQuestion();


        ViewQuestion(i);

    }


    public void animnButon(Button btn) {
        Animation animationButton = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.quay);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.mo);
        btn.startAnimation(animationButton);

    }
    public void AnhXa(){
        tvCauHoi = (TextView) findViewById(R.id.tv_question);
        bt = new Button[4];
        bt[0] = (Button) findViewById(R.id.dapanA);
        bt[1] = (Button) findViewById(R.id.dapanB);
        bt[2] = (Button) findViewById(R.id.dapanC);
        bt[3] = (Button) findViewById(R.id.dapanD);
        socau=(TextView)findViewById(R.id.socau);
        diem12=(TextView)findViewById(R.id.score);


        TextView tv1=(TextView)findViewById(R.id.tv1);
        TextView tv2=(TextView)findViewById(R.id.tv2);
        TextView tv3=(TextView)findViewById(R.id.tv3);
        TextView tv4=(TextView)findViewById(R.id.tv4);
        TextView tv5=(TextView)findViewById(R.id.tv5);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.mo);
        tv1.setAnimation(animation);
        tv2.setAnimation(animation);
        tv3.setAnimation(animation);
        tv4.setAnimation(animation);
        tv5.setAnimation(animation);
    }

    public void LoadQuestion() {

        listCauHoi = new ArrayList<>();
//        run = true;
//        String sql = "select * from question order by random()";
//        Cursor c = db.getCursor(sql);
//        if (c.moveToFirst()) {
//            do {
//                CauHoi ch = new CauHoi();
//                ch.setId(c.getInt(0));
//                ch.setNdcauhoi(c.getString(1));
//                ch.setDaA(c.getString(2));
//                ch.setDaB(c.getString(3));
//                ch.setDaC(c.getString(4));
//                ch.setDaD(c.getString(5));
//                ch.setDaDung(c.getInt(6));
//                listCauHoi.add(ch);
//            } while (c.moveToNext());
//        }
        for (int i = 1; i < 10; i++) {
            String sql = "select * from question where part='2' order by random() limit 10";
            Cursor c = db.getCursor(sql);
            c.moveToFirst();
            do {
                CauHoi ch = new CauHoi();
                ch.setId(c.getInt(0));
                ch.setNdcauhoi(c.getString(1));
                ch.setDaA(c.getString(2));
                ch.setDaB(c.getString(3));
                ch.setDaC(c.getString(4));
                ch.setDaD(c.getString(5));
                ch.setDaDung(c.getInt(6));
                ch.setPart(c.getInt(7));
                listCauHoi.add(ch);
            } while (c.moveToNext());
        }
        db.close();
    }


    public void ViewQuestion(int i) {
        if (i < 10) {
            final int ch=i+1;

            run = true;
            setmau();
            diem12.setText("Score" +":"+ diem);
            socau.setText("Question "+": "+ ch +"/"+"10");
            tvCauHoi.setText(listCauHoi.get(i).getNdcauhoi());
            bt[0].setText("A. " +listCauHoi.get(i).getDaA());
            bt[0].setEnabled(true);
            bt[1].setText("B. " + listCauHoi.get(i).getDaB());
            bt[1].setEnabled(true);
            bt[2].setText("C. " + listCauHoi.get(i).getDaC());
            bt[2].setEnabled(true);
            bt[3].setText("D. " + listCauHoi.get(i).getDaD());
            bt[3].setEnabled(true);
            switch (listCauHoi.get(i).getDaDung()) {
                case 1:
                    Dapandung = R.id.dapanA;
                    break;
                case 2:
                    Dapandung = R.id.dapanB;
                    break;
                case 3:
                    Dapandung = R.id.dapanC;
                    break;
                case 4:
                    Dapandung = R.id.dapanD;
                    break;
            }
        } else {
            Ketthuc();
        }
    }
    public void cham(){
        bt[0].setEnabled(false);
        bt[1].setEnabled(false);
        bt[2].setEnabled(false);
        bt[3].setEnabled(false);
    }
    public void onClick(View v) {
        kt = findViewById(Dapandung);

        switch (v.getId()) {
            case R.id.dapanA:
                if (R.id.dapanA != Dapandung) {
                    animnButon(kt);
                    cham();
                    bt[0].setTextColor(Color.RED);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(++i);

                        }
                    }, 3000);

                } else {
                    diem++;
                    cham();
                    animnButon(bt[0]);
                    bt[0].setTextColor(Color.GREEN);
//                        amthanh(R.raw.dung);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(++i);


                        }
                    }, 3000);
                }
//                diem12.setText("Score" + diem);
                break;

            case R.id.dapanB:
                if (R.id.dapanB != Dapandung) {
                    animnButon(kt);
                    bt[1].setTextColor(Color.RED);
                    cham();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(++i);
                        }
                    }, 3000);

                } else {
                    diem++;
                    animnButon(bt[1]);
                    cham();
                    bt[1].setTextColor(Color.GREEN);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(++i);

                        }
                    }, 3000);
                }
//                diem12.setText("Score" + diem);
                break;
            case R.id.dapanC:
                if (R.id.dapanC != Dapandung) {
                    animnButon(kt);
                    cham();
                    bt[2].setTextColor(Color.RED);

//                        amthanh(R.raw.sai);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(++i);
                        }
                    }, 3000);

                } else {
                    animnButon(bt[2]);
                    cham();
                    diem++;
                    bt[2].setTextColor(Color.GREEN);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(++i);

                        }
                    }, 3000);
                }
//                diem12.setText("Score" + diem);
                break;
            case R.id.dapanD:
                if (R.id.dapanD != Dapandung) {
                    animnButon(kt);
                    bt[3].setTextColor(Color.RED);
                    cham();
//                        amthanh(R.raw.sai);

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(++i);
                        }
                    }, 3000);

                } else {
                    diem++;
                    animnButon(bt[3]);
                    cham();
                    bt[3].setTextColor(Color.GREEN);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(++i);

                        }
                    }, 3000);
                }
//                diem12.setText("Score" + diem);
                break;
        }
    }

    public void setmau() {
        bt[0].setTextColor(Color.BLACK);
        bt[1].setTextColor(Color.BLACK);
        bt[2].setTextColor(Color.BLACK);
        bt[3].setTextColor(Color.BLACK);
    }

    public void Ketthuc() {
        dialog = new Dialog(this, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth);
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View view = layoutInflater.inflate(R.layout.activity_ketthuc, null);
        TextView tvFinish = (TextView) view.findViewById(R.id.ketthuc);
        Button btnFinish = (Button) view.findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);
        dialog.setContentView(view);
        dialog.show();
    }


}

