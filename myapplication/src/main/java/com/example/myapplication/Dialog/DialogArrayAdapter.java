package com.example.myapplication.Dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.Database.Entities.Grocery;
import com.example.myapplication.Fragment.BasketFragment;
import com.example.myapplication.GroceryList.GroceryList;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class DialogArrayAdapter extends BaseAdapter {

    Context context;
    List<Grocery> groceries = new ArrayList<>();
    GroceryList activity;
    public DialogArrayAdapter(Context context, List<Grocery> groceries, GroceryList activity) {
        this.context = context;
        this.groceries = groceries;
        this.activity = activity;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.dialog_listview, parent, false);
        }

        final Grocery grocery = (Grocery)getItem(position);

        TextView name = (TextView)convertView.findViewById(R.id.dialog_listview_textview);

        name.setText(grocery.getName());
        final BasketFragment fragment = ((BasketFragment)activity.getSupportFragmentManager().findFragmentById(R.id.fragment_container));
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.addGroceryToList(grocery);
                fragment.fillList();
            }
        });
        return convertView;
    }



}
