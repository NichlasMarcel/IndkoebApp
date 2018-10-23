package com.example.myapplication.Dishes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.Database.Entities.Grocery;
import com.example.myapplication.Fragment.BasketFragment;
import com.example.myapplication.GroceryList.GroceryList;
import com.example.myapplication.R;

import java.util.List;

public class FindDishArrayAdapter extends BaseAdapter {

    private List<Recipe> recipes;
    private Context context;
    private GroceryList activity;

    public FindDishArrayAdapter(Context context, GroceryList activity, List<Recipe> recipe) {
        this.recipes = recipe;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return recipes.size();
    }

    @Override
    public Object getItem(int i) {
        return recipes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.listview_find_dish, viewGroup, false);
        }

        TextView title = view.findViewById(R.id.listview_find_dish_name);
        final Recipe recipe = (Recipe) getItem(i);
        title.setText(recipe.getTitle());
        final BasketFragment fragment = ((BasketFragment) activity.getSupportFragmentManager().findFragmentById(R.id.fragment_container));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Grocery[] groceries = new Grocery[recipe.getGroceries().size()];
                for (int i = 0; i < groceries.length; i++) {
                    groceries[i] = recipe.getGroceries().get(i).getGrocery();
                }

                fragment.addGroceryToList(groceries);
                fragment.fillList();
            }
        });

        return view;
    }
}
