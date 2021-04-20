package com.example.taxi_map;

public class Tarih {
    int gun;
    int ay;
    int yil;

    public Tarih() {
    }

    public Tarih(int gun, int ay, int yil) {
        this.gun = gun;
        this.ay = ay;
        this.yil = yil;
    }

    public int getGun() {
        return gun;
    }

    public void setGun(int gun) {
        this.gun = gun;
    }

    public int getAy() {
        return ay;
    }

    public void setAy(int ay) {
        this.ay = ay;
    }

    public int getYil() {
        return yil;
    }

    public void setYil(int yil) {
        this.yil = yil;
    }
}
