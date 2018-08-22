package com.example.myapplication.GroceryList;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.myapplication.Dialog.AddGrocery;
import com.example.myapplication.Common.Grocery;
import com.example.myapplication.Dialog.DialogArrayAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;

public class GroceryList extends AppCompatActivity{
    ListView listView;
    GroceryListArrayAdapter adapter;
    ArrayList<Grocery> groceryList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final AddGrocery newFragment = new AddGrocery();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newFragment.show(fragmentManager, "dialog");
            }
        });


        listView = (ListView) findViewById(R.id.mobile_list);
        fillList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void fillList(){
        adapter = new GroceryListArrayAdapter(GroceryList.this, groceryList, this);
        listView.setAdapter(adapter);
    }

    public ArrayList<Grocery> getGroceryList() {
        return groceryList;
    }

}
