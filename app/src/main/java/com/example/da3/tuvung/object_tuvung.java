package com.example.da3.tuvung;

public class object_tuvung {
    public String maTV,maCD,tenTV,phienam,dichnghia;
    public byte[]img;

    public object_tuvung(String maTV, String maCD, String tenTV, String phienam, String dichnghia, byte[] img) {
        this.maTV = maTV;
        this.maCD = maCD;
        this.tenTV = tenTV;
        this.phienam = phienam;
        this.dichnghia = dichnghia;
        this.img = img;
    }
    public object_tuvung(){}

    public String getMaTV() {
        return maTV;
    }

    public void setMaTV(String maTV) {
        this.maTV = maTV;
    }

    public String getMaCD() {
        return maCD;
    }

    public void setMaCD(String maCD) {
        this.maCD = maCD;
    }

    public String getTenTV() {
        return tenTV;
    }

    public void setTenTV(String tenTV) {
        this.tenTV = tenTV;
    }

    public String getPhienam() {
        return phienam;
    }

    public void setPhienam(String phienam) {
        this.phienam = phienam;
    }

    public String getDichnghia() {
        return dichnghia;
    }

    public void setDichnghia(String dichnghia) {
        this.dichnghia = dichnghia;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}

