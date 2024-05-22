package com.example.sampleandroidapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sampleandroidapp.CardModel;
import com.example.sampleandroidapp.model.CarDataRequest;
import com.example.sampleandroidapp.model.CarDataResponse;
import com.example.sampleandroidapp.model.StockData;
import com.example.sampleandroidapp.network.APIService;
import com.example.sampleandroidapp.network.CarwaleHostServiceInstance;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarDataViewModel extends ViewModel {

    private MutableLiveData<List<StockData>> stockDataList;
    public CarDataViewModel() {
        stockDataList = new MutableLiveData<>();
    }

    public void fetchUsedCarList(CarDataRequest carDataRequest) {
        APIService apiService = CarwaleHostServiceInstance.getRetrofitClient().create(APIService.class);
        ArrayList<StockData> stockData = new ArrayList<>();
        Call<CarDataResponse> call = apiService.fetchUsedCarListings(carDataRequest);
        call.enqueue(new Callback<CarDataResponse>() {
            @Override
            public void onResponse(Call<CarDataResponse> call, Response<CarDataResponse> response) {
                if (response.isSuccessful()) {
                    stockDataList.setValue(response.body().stocks);
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
    public LiveData<List<StockData>> getStockDataList() {
        return stockDataList;
    }
}
