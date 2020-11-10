package com.example.da3;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper{
    // Khai báo biến
    private Context dbContext;
    private SQLiteDatabase db;
    private static final String dbName = "da3.sqlite";
    private static final String dbPath =  "/data/data/com.example.da3/databases/da3.sqlite";

    private static final int dbVersion = 1;


    // Phương thức 1: Phương thức khởi dựng
    public DatabaseHandler(Context context)  {
        super(context, dbName, null, dbVersion);
        this.dbContext = context;
    }


    public void copyDB2SDCard()  {
        boolean check = false;
        try {
            File file = new File(dbPath);
            check = file.exists();
            if (check) {
                this.close();
            } else if (!check) {
                this.getReadableDatabase();
                InputStream myInput = dbContext.getAssets().open(dbName);
                String outFileName = dbPath;
                OutputStream myOutput = new FileOutputStream(outFileName);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }
                myOutput.flush();
                myOutput.close();
                myInput.close();
            }
        } catch (Exception e) {
//            throw new Error("Lỗi không copy được database");
        }
    }




    // Phương thức 3: Mở CSDL

    public void openDB() {
        db = SQLiteDatabase.openDatabase(dbPath, null,SQLiteDatabase.OPEN_READWRITE);
    }

    // Phương thức 4: Đóng CSDL

    public void closeDB() {
        db.close();
    }


    //Phương thức 5: Đọc CSDL
    public Cursor getCursor(String strSQL) {
        //B1
        openDB();
        //B2
        Cursor c = db.rawQuery(strSQL, null);
        //B3
        return c;
    }

    //Phương thức 6: thực thi câu lệnh SQL: Insert, Update, Delete
    public void excuteSQL(String sql) {
        //B1
        openDB();
        //B2
        db.execSQL(sql);
        //B3
        closeDB();
    }

    // Phương thức 7: đếm đối tượng trong SQL
    public int GetCount(String sql)
    {
        openDB();
        Cursor cur=db.rawQuery(sql,null);
        int count=cur.getCount();
        closeDB();
        return  count;


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }


}
