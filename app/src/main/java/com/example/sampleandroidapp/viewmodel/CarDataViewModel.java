package com.example.sampleandroidapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sampleandroidapp.model.CarDataRequest;
import com.example.sampleandroidapp.model.CarDataResponse;
import com.example.sampleandroidapp.model.StockData;
import com.example.sampleandroidapp.network.APIService;
import com.example.sampleandroidapp.network.CarwaleHostServiceInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarDataViewModel extends ViewModel {

    private MutableLiveData<CarDataResponse> _carDataResponse = new MutableLiveData<>();
    public LiveData<CarDataResponse> carDataResponse = _carDataResponse;
    public void fetchUsedCarList(CarDataRequest carDataRequest) {
        APIService apiService = CarwaleHostServiceInstance.getRetrofitClient().create(APIService.class);
        Call<CarDataResponse> call = apiService.fetchUsedCarListings(carDataRequest);
        call.enqueue(new Callback<CarDataResponse>() {
            @Override
            public void onResponse(Call<CarDataResponse> call, Response<CarDataResponse> response) {
                if (response.isSuccessful()) {
                    _carDataResponse.postValue(response.body());
                    Log.d("Page increment", "Page no.: " + carDataRequest.getPn() + " Next Page Url: " + response.body().nextPageUrl);
                    logStocks(response.body().stocks);
                } else {
                    // Handle the error
                    Log.e("API Error", "Error code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<CarDataResponse> call, Throwable throwable) {

            }
        });
    }

    private void logStocks(List<StockData> stockData) {
        for(StockData stock : stockData) {
            Log.d("StockData", "Car Name: " + stock.carName + " City Name: " + stock.cityName);
        }
    }
}
