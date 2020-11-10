package com.example.da3.study;

public class CauHoi {
    private int id;
    private String daA, daB, daC, daD, ndcauhoi;
    private int daDung,part;

    public CauHoi(int id, String daA, String daB, String daC, String daD, String ndcauhoi, int daDung,int part) {
        this.id = id;
        this.daA = daA;
        this.daB = daB;
        this.daC = daC;
        this.daD = daD;
        this.ndcauhoi = ndcauhoi;
        this.daDung = daDung;
        this.part=part;
    }

    public CauHoi() {
    }

    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
    }

    public String getDaA() {
        return daA;
    }

    public void setDaA(String daA) {
        this.daA = daA;
    }

    public String getDaB() {
        return daB;
    }

    public void setDaB(String daB) {
        this.daB = daB;
    }

    public String getDaC() {
        return daC;
    }

    public void setDaC(String daC) {
        this.daC = daC;
    }

    public String getDaD() {
        return daD;
    }

    public void setDaD(String daD) {
        this.daD = daD;
    }

    public String getNdcauhoi() {
        return ndcauhoi;
    }

    public void setNdcauhoi(String ndcauhoi) {
        this.ndcauhoi = ndcauhoi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDaDung() {
        return daDung;
    }

    public void setDaDung(int daDung) {
        this.daDung = daDung;
    }
}



