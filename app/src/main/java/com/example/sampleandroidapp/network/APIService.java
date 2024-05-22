package com.example.sampleandroidapp.network;

import com.example.sampleandroidapp.model.CarDataRequest;
import com.example.sampleandroidapp.model.CarDataResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {
    @POST("api/stocks/filters/")
    Call<CarDataResponse> fetchUsedCarListings(@Body CarDataRequest carDataRequest);
}
