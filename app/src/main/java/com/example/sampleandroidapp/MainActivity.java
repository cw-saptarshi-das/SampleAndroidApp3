package com.example.sampleandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sampleandroidapp.model.CarDataRequest;
import com.example.sampleandroidapp.viewmodel.CarDataViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<CardModel> carModel = new ArrayList<>();
    private CarDataViewModel carDataViewModel = new CarDataViewModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.stockCard);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CarDataRequest carDataRequest = new CarDataRequest();
        carDataRequest.setCity("12");

        carModel = carDataViewModel.usedCarsListApiCall(carDataRequest);

        RecyclerCardModelAdapter recyclerCardModelAdapter = new RecyclerCardModelAdapter(this, carModel);
        recyclerView.setAdapter(recyclerCardModelAdapter);
    }

}