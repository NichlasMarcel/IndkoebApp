package com.example.myapplication.GroceryList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.myapplication.Common.Grocery;
import com.example.myapplication.R;

import java.util.ArrayList;

public class GroceryListArrayAdapter extends BaseAdapter {

    Context context;
    ArrayList<Grocery> groceries = new ArrayList<>();
    GroceryList activity;

    // DEPRECATED
    public GroceryListArrayAdapter(Context context, ArrayList<Grocery> groceries, GroceryList activity) {
        this.context = context;
        this.groceries = groceries;
        this.activity = activity;
    }

    public GroceryListArrayAdapter(Context context, ArrayList<Grocery> groceries) {
        this.context = context;
        this.groceries = groceries;
    }

    @Override
    public int getCount() {
        return groceries.size();
    }

    @Override
    public Object getItem(int i) {
        return groceries.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_listview, parent, false);
        }

        final Grocery grocery = (Grocery)getItem(position);
        TextView name = convertView.findViewById(R.id.label);
        CheckBox found = convertView.findViewById(R.id.checkbox_grocery);
        Button delete = convertView.findViewById(R.id.deleteGrocery);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.getGroceryList().remove(grocery);
                activity.fillList();
            }
        });
        name.setText(grocery.getName());
        found.setChecked(grocery.isFound());
        return convertView;
    }



}
