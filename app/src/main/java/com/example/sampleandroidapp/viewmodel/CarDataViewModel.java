package com.example.sampleandroidapp.viewmodel;

import android.util.Log;

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

    private MutableLiveData<CarDataRequest> carData;
    public CarDataViewModel() {
        carData = new MutableLiveData<>();
    }

    public ArrayList<CardModel> usedCarsListApiCall(CarDataRequest carDataRequest) {
        ArrayList<CardModel> cardData = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        APIService apiService = CarwaleHostServiceInstance.getRetrofitClient().create(APIService.class);
        Call<CarDataResponse> call = apiService.fetchUsedCarListings(carDataRequest);
        call.enqueue(new Callback<CarDataResponse>() {
            @Override
            public void onResponse(Call<CarDataResponse> call, Response<CarDataResponse> response) {
                if (response.isSuccessful()) {
                    List<StockData> stockData = response.body().stocks;
                    for (int i = 0; i < stockData.size(); i++) {
                        cardData.set(i, modelMapper.map(stockData.get(i), CardModel.class));
                    }
                } else {
                    // Handle the error
                    Log.e("API Error", "Error code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<CarDataResponse> call, Throwable throwable) {

            }
        });
        return cardData;
    }
}
