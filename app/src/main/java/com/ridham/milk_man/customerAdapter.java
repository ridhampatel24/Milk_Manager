package com.ridham.milk_man;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class customerAdapter extends ArrayAdapter {
    List<String> listname;
    Context context;

    public customerAdapter(@NonNull Context context, List<String> name) {
        super(context, R.layout.items,name);
        this.listname = name;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.customer,parent,false);
        TextView textView = view.findViewById(R.id.milkprovider);

        textView.setText(listname.get(position));
        return view;
    }
}
