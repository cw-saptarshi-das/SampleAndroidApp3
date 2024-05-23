package com.example.sampleandroidapp.model;

import java.util.ArrayList;
import java.util.List;

public class CarDataResponse {

    public CarDataResponse() {
        stocks = new ArrayList<>();
    }
    public String nextPageUrl;
    public String searchPageDescription;
    public boolean showSimilarCarsLink;
    public int totalCount;
    public List<StockData> stocks;
}
