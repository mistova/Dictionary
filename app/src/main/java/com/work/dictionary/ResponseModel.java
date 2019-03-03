package com.work.dictionary;

import com.google.gson.annotations.SerializedName;

public class ResponseModel {

    private int sonuc;
    @SerializedName("msg")
    private String mesaj;

    public ResponseModel(int sonuc, String mesaj) {
        this.sonuc = sonuc;
        this.mesaj = mesaj;
    }

    public int getSonuc() {
        return sonuc;
    }

    public void setSonuc(int sonuc) {
        this.sonuc = sonuc;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }
}