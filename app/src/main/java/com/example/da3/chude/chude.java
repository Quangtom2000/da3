package com.example.da3.chude;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.da3.DatabaseHandler;
import com.example.da3.R;


import java.util.ArrayList;
import com.example.da3.tuvung.tuvung;

import androidx.appcompat.app.AppCompatActivity;

public class chude extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    ArrayList<object_chude> arrList = null;
    ArrayAdapter<object_chude> adap = null;
    object_chude ob = new object_chude();
    int i;

    private ListView lv;
            TextView tvTenhude,tvSoluong,tv_machude;
            ImageView img;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chude);
        db.copyDB2SDCard();
        int sbg = db.GetCount("select * from chude");
        Toast.makeText(this, "Số bản ghi: " + sbg, Toast.LENGTH_LONG).show();
        anhxa();

        LoadQuestion();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(chude.this, tuvung.class);
                intent.putExtra("maCD", arrList.get(position).getMachude().toString());
                intent.putExtra("Tenchude", arrList.get(position).getTenchude().toString());
                startActivity(intent);
            }
        });
    }
    public void anhxa(){
        lv=(ListView)findViewById(R.id.mylistview);

    }

    public void LoadQuestion() { // đây là hiện lên listview
        arrList = new ArrayList<object_chude>();
        object_chude row;
        Cursor c = db.getCursor("select * from chude");
        c.moveToFirst();
        while (!c.isAfterLast()) {
            row = new object_chude();
            row.maCD= c.getString(0);
            row.Tenchude = c.getString(1);
            row.img= c.getBlob(2);
            row.soluong = c.getInt(3);
            arrList.add(row);
            c.moveToNext();
        }
        adap = new adapter(this, R.layout.item_listview_chude, arrList);
        lv.setAdapter(adap);
        adap.notifyDataSetChanged();
        registerForContextMenu(lv);
        c.close();
    }



}
