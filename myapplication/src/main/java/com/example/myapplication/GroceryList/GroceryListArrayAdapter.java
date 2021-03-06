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

import com.example.myapplication.Database.Entities.Grocery;
import com.example.myapplication.Database.Entities.GroceryListEntity;
import com.example.myapplication.Database.Repository.GroceryRepository;
import com.example.myapplication.Fragment.BasketFragment;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GroceryListArrayAdapter extends BaseAdapter {

    Context context;
    List<GroceryListEntity> groceryList;
    GroceryList activity;
    GroceryRepository groceryRepository;
    // DEPRECATED
    public GroceryListArrayAdapter(Context context, List<GroceryListEntity> groceries, GroceryList activity) {
        this.context = context;
        this.groceryList = groceries;
        this.activity = activity;
        this.groceryRepository = new GroceryRepository(activity.getApplication());
    }

    public GroceryListArrayAdapter(Context context,List<GroceryListEntity> groceries) {
        this.context = context;
        this.groceryList = groceries;
    }

    @Override
    public int getCount() {
        return groceryList.size();
    }

    @Override
    public Object getItem(int i) {
        return groceryList.get(i);
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

        final GroceryListEntity grocery = (GroceryListEntity)getItem(position);
        TextView name = (TextView)convertView.findViewById(R.id.label);
        final CheckBox found = (CheckBox)convertView.findViewById(R.id.checkbox_grocery);
        Button delete = (Button)convertView.findViewById(R.id.deleteGrocery);
        final BasketFragment fragment = ((BasketFragment)activity.getSupportFragmentManager().findFragmentById(R.id.fragment_container));
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.removeGroceryFromList(grocery);
                fragment.fillList();
            }
        });

        found.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.updateChecked(grocery, found.isChecked());
            }
        });

        List<Grocery> groceryFromDb = groceryRepository.getById(grocery.getGroceryId());
        name.setText(grocery.getAmount() + "x " + groceryRepository.getById(grocery.getGroceryId()).get(0).getName());
        found.setChecked(grocery.isChecked());
        return convertView;
    }



}
