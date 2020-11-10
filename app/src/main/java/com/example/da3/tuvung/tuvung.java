package com.example.da3.tuvung;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.da3.DatabaseHandler;
import com.example.da3.R;
import com.example.da3.chude.chude;
import com.example.da3.chude.object_chude;
import com.example.da3.tuvung.adapter_tuvung;

import java.util.ArrayList;
import java.util.Locale;
import java.util.*;

import androidx.appcompat.app.AppCompatActivity;


public class tuvung extends AppCompatActivity {

    DatabaseHandler db = new DatabaseHandler(this);
    ArrayList<object_tuvung> arrList = null;
    ArrayAdapter<object_tuvung> adap = null;
    object_tuvung ob_tv = new object_tuvung();
    int i;
    String text;
    TextToSpeech textToSpeech;
    private ListView lv1;
    TextView tvma, tvten,tvtv;
    object_tuvung item;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuvung);

        db.copyDB2SDCard();
        int sbg = db.GetCount("select * from tuvung");
        Toast.makeText(this, "Số bản ghi: " + sbg, Toast.LENGTH_LONG).show();
        anhxa();

        getData();
//        getTen();
        LoadQuestion();


        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item = (object_tuvung) lv1.getItemAtPosition(position);
                    textToSpeech=new TextToSpeech(tuvung.this, new TextToSpeech.OnInitListener() {
                        @Override
                        public void onInit(int i) {
                            if (i != TextToSpeech.ERROR) {
                                textToSpeech.setLanguage(Locale.US);
                            } else {
                                Toast.makeText(tuvung.this, "Errol", Toast.LENGTH_LONG).show();
                            }
                            if (item != null) {
                                textToSpeech.speak(item.getTenTV(), TextToSpeech.QUEUE_FLUSH, null);
                            }

                        }
                    });

            }
        });
    }

    public void anhxa() {
        lv1 = (ListView) findViewById(R.id.listview_tuvung);
        tvma = (TextView) findViewById(R.id.tv_machude_tuvung);
        tvten = (TextView) findViewById(R.id.tv_tenchude_tuvung);
        tvtv=(TextView)findViewById(R.id.tuvung);

    }

    public void LoadQuestion() { // đây là hiện lên listview
        arrList = new ArrayList<object_tuvung>();
        String ma = tvma.getText().toString();
        object_tuvung row;
        Cursor c = db.getCursor("select * from tuvung where maCD='" + ma + "' ");
        c.moveToFirst();
        while (!c.isAfterLast()) {
            row = new object_tuvung();
            row.maTV = c.getString(0);
            row.maCD = c.getString(1);
            row.tenTV = c.getString(2);
            row.phienam = c.getString(3);
            row.dichnghia = c.getString(4);
            row.img = c.getBlob(5);
            arrList.add(row);
            c.moveToNext();
        }
        adap = new adapter_tuvung(this, R.layout.item_tuvung, arrList);
        lv1.setAdapter(adap);
        adap.notifyDataSetChanged();
        registerForContextMenu(lv1);
        c.close();
    }

    private void getData() {
        Intent intent = getIntent();
        String Ma = intent.getStringExtra("maCD");
        String ten = intent.getStringExtra("Tenchude");
        tvma.setText(Ma + "");
        tvten.setText(ten + "");
    }

}

