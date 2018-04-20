package com.ckj.pokercounter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LeftCardsAdapter extends RecyclerView.Adapter<LeftCardsAdapter.MyViewHolder> {

    private String[] array = {"大", "小", "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
    private int[] cards;
    private LayoutInflater inflater;

    public LeftCardsAdapter(Context context, int[] cards) {
        this.cards = cards;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(com.ckj.pokercounter.R.layout.card_view, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.cardIdTV.setText(array[position]);
        holder.leftNumTV.setText(String.valueOf(cards[position]));
    }


    @Override
    public int getItemCount() {
        return array.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView cardIdTV;
        TextView leftNumTV;

        public MyViewHolder(View itemView) {
            super(itemView);
            cardIdTV = itemView.findViewById(com.ckj.pokercounter.R.id.id);
            leftNumTV = itemView.findViewById(com.ckj.pokercounter.R.id.num);
        }
    }

}
