package com.example.sampleandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sampleandroidapp.model.CarDataRequest;
import com.example.sampleandroidapp.model.StockData;
import com.example.sampleandroidapp.viewmodel.CarDataViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<StockData> carData = new ArrayList<>();
    private CarDataViewModel carDataViewModel = new CarDataViewModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.stockCard);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerCardModelAdapter recyclerCardModelAdapter = new RecyclerCardModelAdapter(this, carData);
        recyclerView.setAdapter(recyclerCardModelAdapter);

        CarDataRequest carDataRequest = new CarDataRequest();
        carDataRequest.setCity("2");

        // Observe the LiveData
        carDataViewModel.getStockDataList().observe(this, new Observer<List<StockData>>() {
            @Override
            public void onChanged(List<StockData> stockDataList) {
                // Update carData and notify adapter
                carData.clear();
                carData.addAll(stockDataList);
                recyclerCardModelAdapter.notifyDataSetChanged();
            }
        });

        // Trigger the API call
        carDataViewModel.fetchUsedCarList(carDataRequest);
    }

}