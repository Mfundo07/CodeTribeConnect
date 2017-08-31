package com.example.android.codetribeconnect;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Admin on 8/30/2017.
 *
 */


public class  DataItemAdapter extends ArrayAdapter<DataItem> {
    public DataItemAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<DataItem> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        TextView headTextView =  listItemView.findViewById(R.id.itemNameText);
        DataItem item = getItem(position);
        headTextView.setText(item.getItemName());



        return listItemView;
    }
}

