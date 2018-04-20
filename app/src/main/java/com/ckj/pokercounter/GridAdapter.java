package com.ckj.pokercounter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {

    private Context context;
    private String[] keys;


    GridAdapter(Context context, String[] keys) {
        this.context = context;
        this.keys = keys;
    }

    public int getCount() {
        return keys.length;
    }

    public Object getItem(int item) {
        return item;
    }

    public long getItemId(int id) {
        return id;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(com.ckj.pokercounter.R.layout.key_item, null);
            holder.tv = convertView.findViewById(com.ckj.pokercounter.R.id.id);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv.setText(keys[position]);
        return convertView;
    }

    public final class ViewHolder {
        public TextView tv;
    }
}
