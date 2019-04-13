package com.example.dulichthainguyen;

public class Item {
    private int avatar;
    private String name;
    private String diaDanh;
    private double latitude;
    private double longitude;


    public Item(int avatar, String name, String diaDanh,double latitude,double longitude) {
        this.avatar = avatar;
        this.name = name;
        this.diaDanh = diaDanh;
        this.latitude= latitude;
        this.longitude=longitude;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiaDanh() {
        return diaDanh;
    }

    public void setDiaDanh(String diaDanh) {
        this.diaDanh = diaDanh;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
