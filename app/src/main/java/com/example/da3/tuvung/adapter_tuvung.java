package com.example.da3.tuvung;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.da3.R;


import java.util.ArrayList;

import androidx.annotation.Nullable;

public class adapter_tuvung extends ArrayAdapter<object_tuvung> {
    ArrayList<object_tuvung> arrayList = new ArrayList<object_tuvung>();
    Activity context;
    int layout ;

    public adapter_tuvung(Context context, int resource, ArrayList<object_tuvung> objects) {
        super(context, resource, objects);
        this.context = (Activity) context;
        arrayList = objects;
        layout = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(layout, null);
        Bitmap b= BitmapFactory.decodeByteArray(arrayList.get(position).getImg(),0,arrayList.get(position).getImg().length);
        TextView txtItem1 = (TextView) view.findViewById(R.id.tuvung);
        TextView txtItem2 = (TextView) view.findViewById(R.id.phien_am);
        TextView textView3=(TextView)view.findViewById(R.id.tv_y_nghia);
        ImageView img =(ImageView)view.findViewById(R.id.img_tuvung);

        object_tuvung ob = arrayList.get(position);
        txtItem1.setText(ob.tenTV);
        txtItem2.setText(ob.phienam);
        textView3.setText(ob.dichnghia);

        img.setImageBitmap(b);


        return view;
    }

    @Nullable
    @Override
    public object_tuvung getItem(int position) {
        return super.getItem(position);
    }


}


