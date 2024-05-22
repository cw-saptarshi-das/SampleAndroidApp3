package com.example.sampleandroidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sampleandroidapp.model.StockData;

import java.util.ArrayList;

public class RecyclerCardModelAdapter extends RecyclerView.Adapter<RecyclerCardModelAdapter.CardViewHolder> {
    Context context;
    ArrayList<StockData> carData;

    RecyclerCardModelAdapter(Context context, ArrayList<StockData> carData) {
        this.context = context;
        this.carData = carData;
    }
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cardView = LayoutInflater.from(context).inflate(R.layout.stock_card_contents, parent, false);
        CardViewHolder cardViewHolder = new CardViewHolder(cardView);
        return cardViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Glide.with(context).load(carData.get(position).imageUrl).into(holder.carImg);
        holder.carTitle.setText(carData.get(position).makeYear + " " + carData.get(position).carName);
        holder.additionalCarDetails.setText(carData.get(position).getKm() + " | " + carData.get(position).fuel + " | " + carData.get(position).transmission + " | " + carData.get(position).cityName);
        holder.carPrice.setText(carData.get(position).getPrice());
        String emiText = carData.get(position).emiText;
        if (emiText != null && !emiText.trim().isEmpty() && holder.emiPrice.getText().toString().isEmpty()) {
            holder.emiPrice.setText(holder.emiPrice.getText() + emiText.substring(emiText.indexOf("at") + 2));
        }
    }

    @Override
    public int getItemCount() {
        return carData.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
        TextView carTitle, additionalCarDetails, carPrice, emiPrice;
        ImageView carImg;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            carTitle = itemView.findViewById(R.id.stockCardTitle);
            additionalCarDetails = itemView.findViewById(R.id.additionalDetails);
            carPrice = itemView.findViewById((R.id.carPrice));
            emiPrice = itemView.findViewById(R.id.emiPrice);
            carImg = itemView.findViewById(R.id.carImage);
        }

    }
}
