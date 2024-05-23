package com.example.sampleandroidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.TextView;

import com.example.sampleandroidapp.model.CarDataRequest;
import com.example.sampleandroidapp.model.CarDataResponse;
import com.example.sampleandroidapp.viewmodel.CarDataViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    CarDataResponse carData = new CarDataResponse();
    boolean isScrolling;
    String cityId = "10";
    int currentItems, totalItems, scrolledOutItems;
    private CarDataViewModel carDataViewModel = new CarDataViewModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.stockCard);
        TextView stockCount = findViewById(R.id.listingsCount);
        TextView cityName = findViewById(R.id.cityName);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        RecyclerCardModelAdapter recyclerCardModelAdapter = new RecyclerCardModelAdapter(this, carData.stocks);
        recyclerView.setAdapter(recyclerCardModelAdapter);

        CarDataRequest carDataRequest = new CarDataRequest();
        carDataRequest.setCity(cityId);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentItems = manager.getChildCount();
                totalItems = manager.getItemCount();
                scrolledOutItems = manager.findFirstVisibleItemPosition();
                if (isScrolling && currentItems + scrolledOutItems == totalItems) {
                    isScrolling = false;
                    if (carData != null) {
                        carDataViewModel.fetchUsedCarList(getUpdatedUsedListingRequest(carData.nextPageUrl, carDataRequest));
                    }
                }
            }
        });

        // Observe the LiveData
        carDataViewModel.carDataResponse.observe(this, new Observer<CarDataResponse>() {
            @Override
            public void onChanged(CarDataResponse stockDataList) {
                // Update carData and notify adapter
                carData.showSimilarCarsLink = stockDataList.showSimilarCarsLink;
                carData.nextPageUrl = stockDataList.nextPageUrl;
                carData.searchPageDescription = stockDataList.searchPageDescription;
                carData.totalCount = stockDataList.totalCount;
                carData.stocks.addAll(stockDataList.stocks);
                cityName.setText(carData.stocks.get(0).cityName);
                stockCount.setText(carData.totalCount + " ");
                recyclerCardModelAdapter.notifyDataSetChanged();
            }
        });

        // Trigger the API call
        carDataViewModel.fetchUsedCarList(carDataRequest);
    }

    private CarDataRequest getUpdatedUsedListingRequest(String pageUrl, CarDataRequest request) {
        if (pageUrl.isEmpty()) {
            return request;
        }
        ArrayList<String> nextPageUrlParams = new ArrayList<String>(Arrays.asList(pageUrl.substring(pageUrl.indexOf("?") + 1).split("&")));
        Map<String, String> keyValueMap = new HashMap<>();
        for (String pair : nextPageUrlParams) {
            String[] keyValue = pair.split("=");
            if (keyValue.length == 2) {
                String key = keyValue[0];
                String value = keyValue[1];
                keyValueMap.put(key, value);
            }
        }
        request.setPn(keyValueMap.get("pn"));
        request.setCity(keyValueMap.get("city"));
        request.setPs(keyValueMap.get("ps"));
        request.setLcr(Integer.parseInt(keyValueMap.get("lcr")));
        request.setExcludeStocks(keyValueMap.get("excludestocks"));
        request.setStockFetched(Integer.parseInt(keyValueMap.get("stockfetched")));
        return request;
    }

}