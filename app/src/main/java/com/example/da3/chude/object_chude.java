package com.example.da3.chude;

import android.os.Parcel;

public class object_chude {
    public byte[]img;
    public String Tenchude,maCD;
    public int soluong;

    public object_chude( String machude,String tenchude, byte[] img, int soluong) {
        this.maCD=machude;
        this.Tenchude = tenchude;
        this.img = img;
        this.soluong = soluong;
    }
    public object_chude(){}


    public String getMachude() {
        return maCD;
    }

    public void setMachude(String machude) {
        this.maCD = machude;
    }


    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getTenchude() {
        return Tenchude;
    }

    public void setTenchude(String tenchude) {
        Tenchude = tenchude;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
