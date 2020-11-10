package com.example.da3.chude;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.da3.R;

import java.util.ArrayList;

public class adapter extends ArrayAdapter<object_chude> {
    ArrayList<object_chude> arrayList = new ArrayList<object_chude>();
    Activity context;
    int layout ;

    public adapter(Context context, int resource, ArrayList<object_chude> objects) {
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
        TextView txtItem1 = (TextView) view.findViewById(R.id.tv_ma);
        TextView txtItem2 = (TextView) view.findViewById(R.id.ten);
        TextView textView3=(TextView)view.findViewById(R.id.tv_soluong);
        ImageView img =(ImageView)view.findViewById(R.id.img);

object_chude ob = arrayList.get(position);

        txtItem1.setText(ob.maCD);
        txtItem2.setText(ob.Tenchude);
        textView3.setText(ob.soluong+"");

        img.setImageBitmap(b);


        return view;
    }


}
