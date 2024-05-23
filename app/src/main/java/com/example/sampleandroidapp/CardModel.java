package com.example.sampleandroidapp;

public class CardModel {
    public String imageUrl;
    public String carName;
    public String makeYear;
    public String km;
    public String fuel;
    public String transmission;
    public String cityName;
    public String price;
    public String emiText;

    public int stockCount;

    public String getPrice() {
        return "Rs. " + price;
    }
}
