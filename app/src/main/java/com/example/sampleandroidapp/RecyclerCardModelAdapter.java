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

import java.util.ArrayList;

public class RecyclerCardModelAdapter extends RecyclerView.Adapter<RecyclerCardModelAdapter.CardViewHolder> {
    Context context;
    ArrayList<CardModel> cardModel;

    RecyclerCardModelAdapter(Context context, ArrayList<CardModel> cardModel) {
        this.context = context;
        this.cardModel = cardModel;
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
        Glide.with(context).load(cardModel.get(position).imageUrl).into(holder.carImg);
        holder.carTitle.setText(cardModel.get(position).makeYear + " " + cardModel.get(position).carName);
        holder.additionalCarDetails.setText(cardModel.get(position).km + " | " + cardModel.get(position).fuel + " | " + cardModel.get(position).transmission + " | " + cardModel.get(position).cityName);
        holder.carPrice.setText(cardModel.get(position).getPrice());
        holder.emiPrice.setText(cardModel.get(position).emiText);
    }

    @Override
    public int getItemCount() {
        return cardModel.size();
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
