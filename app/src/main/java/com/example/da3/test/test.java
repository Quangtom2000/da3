package com.example.da3.test;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.da3.DatabaseHandler;
import com.example.da3.MainActivity;
import com.example.da3.MenuStudy;
import com.example.da3.R;
import com.example.da3.study.CauHoi;

import java.util.ArrayList;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class test extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    ArrayList<CauHoi> listCauHoi = new ArrayList<>();
    TextView tv_tg;
    CountDownTimer timer;
    int i = 0, Dapandung;
    long t = 1800;
    int rePlay = 0;
    Button[] bt;
    private Button kt, btn_back;
    int score;
    private TextView tvCauHoi, socau, score1;
    Dialog dialog;
    MediaPlayer mediaPlayer;
    boolean run;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        db.copyDB2SDCard();
        AnhXa();

        LoadQuestion();

        ViewQuestion(i);
        innit();


        timer = new CountDownTimer(t * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int minutes = (int) t / 60;
                int seconds = (int) t % 60;
                String countTimer = String.format("%02d:%02d", minutes, seconds);
                tv_tg.setText(countTimer);
                t = t - 1;
            }

            @Override
            public void onFinish() {
                timer.cancel();
                tv_tg.setText("00:00");
                if (!isFinishing()) {
//                    Ketthuc();
                }
            }

        }.start();
    }

    public void AnhXa() {
        tvCauHoi = (TextView) findViewById(R.id.test_question);
        bt = new Button[4];
        bt[0] = (Button) findViewById(R.id.test_dapanA);
        bt[1] = (Button) findViewById(R.id.test_dapanB);
        bt[2] = (Button) findViewById(R.id.test_dapanC);
        bt[3] = (Button) findViewById(R.id.test_dapanD);
        tv_tg = (TextView) findViewById(R.id.tvThoiGian);
        socau = (TextView) findViewById(R.id.tv_socau_test);
        score1 = (TextView) findViewById(R.id.test_score);
        btn_back = (Button) findViewById(R.id.btn_back);


    }

    public void animnButon(Button btn) {
        Animation animationButton = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.quay);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.mo);
        btn.startAnimation(animationButton);

    }

    public void LoadQuestion() {

        listCauHoi = new ArrayList<>();
        for (int i = 1; i < 50; i++) {
            String sql = "select * from question order by random() limit 50";
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
        if (i < 50) {
            final int ch = i + 1;
            run = true;
            setmau();
            socau.setText(ch + "/" + "50");
            score1.setText(score+"");
            tvCauHoi.setText(listCauHoi.get(i).getNdcauhoi());
            bt[0].setText("A. " + listCauHoi.get(i).getDaA());
            bt[0].setEnabled(true);
            bt[1].setText("B. " + listCauHoi.get(i).getDaB());
            bt[1].setEnabled(true);
            bt[2].setText("C. " + listCauHoi.get(i).getDaC());
            bt[2].setEnabled(true);
            bt[3].setText("D. " + listCauHoi.get(i).getDaD());
            bt[3].setEnabled(true);
            switch (listCauHoi.get(i).getDaDung()) {
                case 1:
                    Dapandung = R.id.test_dapanA;
                    break;
                case 2:
                    Dapandung = R.id.test_dapanB;
                    break;
                case 3:
                    Dapandung = R.id.test_dapanC;
                    break;
                case 4:
                    Dapandung = R.id.test_dapanD;
                    break;
            }
        } else {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(test.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                    builder.setTitle("Chúc mừng bạn đã đạt được: " + score );
                    builder.setMessage("Chọn xác nhận chơi lại hoặc thoát");
                    builder.setPositiveButton("Thoát", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(test.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    builder.setNegativeButton("Test lại ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(test.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    builder.show();

                }
            }, 1000);
        }
    }

    public void onClick_test(View v) {
        kt = findViewById(Dapandung);
        switch (v.getId()) {
            case R.id.test_dapanA:
                if (R.id.test_dapanA != Dapandung) {
//                    animnButon(kt);
                    cham();
                    amthanh(R.raw.sai);
                    bt[0].setTextColor(Color.RED);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(++i);
                        }
                    }, 3000);

                } else {
//                        tlDung++;
                    score=score+2;
                    cham();
                    animnButon(bt[0]);
                    bt[0].setTextColor(Color.GREEN);
                    amthanh(R.raw.dung);
                    // android.os.SystemClock.sleep(600);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(++i);
                        }
                    }, 3000);
                }
//                    socau.setText(tlDung + " / " + 30);
                break;

            case R.id.test_dapanB:
                if (R.id.test_dapanB != Dapandung) {
//                    animnButon(kt);
                    bt[1].setTextColor(Color.RED);
                    cham();
                    amthanh(R.raw.sai);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(++i);
                        }
                    }, 3000);

                } else {
                    score=score+2;
                    animnButon(bt[1]);
                    cham();
                    amthanh(R.raw.dung);
                    bt[1].setTextColor(Color.GREEN);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(++i);
                        }
                    }, 3000);
                }
//                    socau.setText(tlDung + " / " + 30);
                break;
            case R.id.test_dapanC:
                if (R.id.test_dapanC != Dapandung) {
//                    animnButon(kt);
                    cham();
                    bt[2].setTextColor(Color.RED);

                    amthanh(R.raw.sai);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(++i);
                        }
                    }, 3000);

                } else {
                    score=score+2;
                    animnButon(bt[2]);
                    cham();
                    amthanh(R.raw.dung);
                    bt[2].setTextColor(Color.GREEN);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(++i);
                        }
                    }, 3000);
                }
//                    socau.setText(tlDung + " / " + 30);
                break;
            case R.id.test_dapanD:
                if (R.id.test_dapanD != Dapandung) {
//                    animnButon(kt);
                    bt[3].setTextColor(Color.RED);
                    cham();
                    amthanh(R.raw.sai);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(++i);
                        }
                    }, 3000);

                } else {
                    score=score+2;
                    animnButon(bt[3]);
                    cham();
                    amthanh(R.raw.dung);
                    bt[3].setTextColor(Color.GREEN);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(++i);
                        }
                    }, 3000);
                }
//                    socau.setText(tlDung + " / " + 30);
                break;
        }
    }

    public void cham() {
        bt[0].setEnabled(false);
        bt[1].setEnabled(false);
        bt[2].setEnabled(false);
        bt[3].setEnabled(false);
    }

    public void setmau() {
        bt[0].setTextColor(Color.BLACK);
        bt[1].setTextColor(Color.BLACK);
        bt[2].setTextColor(Color.BLACK);
        bt[3].setTextColor(Color.BLACK);
    }

    public void amthanh(int nhac) {
        mediaPlayer = MediaPlayer.create(this, nhac);
        mediaPlayer.start();
    }

    public void innit() {
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rePlay = 1;
                timer.cancel();
                t = t + 1;
                AlertDialog.Builder builder = new AlertDialog.Builder(test.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Bạn có chắc muốn thoát khỏi bài Test!");
                builder.setMessage("Hãy chọn để xác nhận!");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(test.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        rePlay = 0;
                        timer.start();
                        t = t - 1;
                    }
                });
                builder.show();
            }
        });
    }
}