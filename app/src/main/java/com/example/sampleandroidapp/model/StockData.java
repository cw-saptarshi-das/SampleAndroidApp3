package com.example.sampleandroidapp.model;

public class StockData {
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

    public String getKm() {
        return km + " km";
    }
}
