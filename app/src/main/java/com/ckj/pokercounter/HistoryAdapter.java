package com.ckj.pokercounter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {

    private ArrayList historyList;
    private LayoutInflater inflater;

    public HistoryAdapter(Context context, ArrayList historyList) {
        this.historyList = historyList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(com.ckj.pokercounter.R.layout.history_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.historyTV.setText(String.valueOf(historyList.get(position)));
        Log.v("ckjc","str="+String.valueOf(historyList.get(position)));
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView historyTV;

        public MyViewHolder(View itemView) {
            super(itemView);
            historyTV = itemView.findViewById(com.ckj.pokercounter.R.id.history_tv);
        }
    }

}
