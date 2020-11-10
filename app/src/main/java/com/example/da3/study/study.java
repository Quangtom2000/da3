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
import android.widget.Toast;

import com.example.da3.DatabaseHandler;
import com.example.da3.R;

import java.io.IOException;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class study extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    ArrayList<CauHoi> listCauHoi = new ArrayList<>();
    private TextView tvCauHoi;
    private Button daA, daB, daC, daD, kt;
    Button[] bt;
    int i = 0, Dapandung, thoigiancho;
    Dialog dialog;
    private boolean check;
    private boolean run;
    private boolean checkdapan;
    private android.os.Handler handler = new android.os.Handler();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cauhoi);
        db.copyDB2SDCard();
        int sbg = db.GetCount("select * from cauhoi");
        Toast.makeText(this, "Số bản ghi: " + sbg, Toast.LENGTH_LONG).show();

        tvCauHoi = (TextView) findViewById(R.id.tv_question);
        bt = new Button[4];
        bt[0] = (Button) findViewById(R.id.dapanA);
        bt[1] = (Button) findViewById(R.id.dapanB);
        bt[2] = (Button) findViewById(R.id.dapanC);
        bt[3] = (Button) findViewById(R.id.dapanD);

        LoadQuestion();


        ViewQuestion(i);

    }

    public void animnButon(Button btn) {
        Animation animationButton = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.quay);
        btn.startAnimation(animationButton);
    }

    public void LoadQuestion() {

        listCauHoi = new ArrayList<>();
        run = true;
        String sql = "select * from cauhoi ";
        Cursor c = db.getCursor(sql);
        if (c.moveToFirst()) {
            do {
                CauHoi ch = new CauHoi();
                ch.setId(c.getInt(0));
                ch.setNdcauhoi(c.getString(1));
                ch.setDaA(c.getString(2));
                ch.setDaB(c.getString(3));
                ch.setDaC(c.getString(4));
                ch.setDaD(c.getString(5));
                ch.setDaDung(c.getInt(6));
                listCauHoi.add(ch);
            } while (c.moveToNext());
        }

    }

    public void ViewQuestion(int i) {
        if (i < 3) {
            run = true;
            setmau();
            tvCauHoi.setText(listCauHoi.get(i).getNdcauhoi());
            bt[0].setBackgroundResource(R.drawable.xanhnhat);
            bt[0].setText("A. " + listCauHoi.get(i).getDaA());

            bt[1].setBackgroundResource(R.drawable.xanhnhat);
            bt[1].setText("B. " + listCauHoi.get(i).getDaB());

            bt[2].setBackgroundResource(R.drawable.xanhnhat);
            bt[2].setText("C. " + listCauHoi.get(i).getDaC());

            bt[3].setBackgroundResource(R.drawable.xanhnhat);
            bt[3].setText("D. " + listCauHoi.get(i).getDaD());

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

    public void onClick(View v) {
        kt = findViewById(Dapandung);
        switch (v.getId()) {
            case R.id.dapanA:
                if (R.id.dapanA != Dapandung) {
                    animnButon(kt);
                    bt[0].setTextColor(Color.RED);
//                        amthanh(R.raw.sai);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(++i);
                        }
                    }, 2500);

                } else {
//                        tlDung++;
                    animnButon(bt[0]);
//                        amthanh(R.raw.dung);
                    // android.os.SystemClock.sleep(600);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(++i);
                        }
                    }, 2500);
                }
//                    socau.setText(tlDung + " / " + 30);
                break;

//            switch (v.getId()) {
//                case R.id.dapanA:
//                    if (R.id.dapanA != Dapandung)
//                        bt[0].setTextColor(Color.RED);
//                    else {
////                        animnButon(bt[0]);
//                        Handler handler = new Handler();
//                        handler.postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                ViewQuestion(i++);
//                            }
//                        }, 100);
//                    }
//                    break;

            case R.id.dapanB:
                if (R.id.dapanB != Dapandung) {
                    animnButon(kt);
                    bt[1].setTextColor(Color.RED);
//                        amthanh(R.raw.sai);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(++i);
                        }
                    }, 2500);

                } else {
                    animnButon(bt[1]);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(++i);
                        }
                    }, 2500);
                }
//                    socau.setText(tlDung + " / " + 30);
                break;
            case R.id.dapanC:
                if (R.id.dapanC != Dapandung) {
                    animnButon(kt);
                    bt[2].setTextColor(Color.RED);
//                        amthanh(R.raw.sai);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(++i);
                        }
                    }, 2500);

                } else {
                    animnButon(bt[2]);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(++i);
                        }
                    }, 2500);
                }
//                    socau.setText(tlDung + " / " + 30);
                break;
            case R.id.dapanD:
                if (R.id.dapanD != Dapandung) {
                    animnButon(kt);
                    bt[3].setTextColor(Color.RED);
//                        amthanh(R.raw.sai);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(++i);
                        }
                    }, 2500);

                } else {
                    animnButon(bt[3]);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(++i);
                        }
                    }, 2500);
                }
//                    socau.setText(tlDung + " / " + 30);
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


