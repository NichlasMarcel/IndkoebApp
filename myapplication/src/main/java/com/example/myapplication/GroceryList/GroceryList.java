package com.example.myapplication.GroceryList;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

import com.example.myapplication.Database.Entities.GroceryListEntity;
import com.example.myapplication.Database.Repository.GroceryListRepository;
import com.example.myapplication.Database.Repository.GroceryRepository;
import com.example.myapplication.Dialog.AddGrocery;
import com.example.myapplication.Database.Entities.Grocery;
import com.example.myapplication.GroceryViewModel;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroceryList extends AppCompatActivity{
    ListView listView;
    GroceryListArrayAdapter adapter;
//    ArrayList<Grocery> groceryList = new ArrayList<>();
    GroceryRepository groceryRepository;
    List<GroceryListEntity> groceryList = new ArrayList<>();
    private GroceryViewModel groceryViewModel;
    GroceryListRepository groceryListRepository;

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

        groceryViewModel = ViewModelProviders.of(this).get(GroceryViewModel.class);
        listView = (ListView) findViewById(R.id.mobile_list);
        groceryRepository = new GroceryRepository(this.getApplication());
        groceryListRepository = new GroceryListRepository(this.getApplication());
        groceryList = groceryListRepository.getAll();
        fillList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void fillList(){
        updateGroceryList();
        adapter = new GroceryListArrayAdapter(GroceryList.this, groceryList, this);
        listView.setAdapter(adapter);
    }

    public void updateChecked(GroceryListEntity groceryListEntity, boolean value){
        groceryListRepository.updateChecked(groceryListEntity,value);
    }

    public void updateGroceryList(){
        groceryList.clear();
        groceryList = groceryListRepository.getAll();
    }

    public void addGroceryToList(Grocery grocery){
        groceryListRepository.insertAndUpdate(grocery);
    }

    public void removeGroceryFromList(GroceryListEntity grocery){
        groceryListRepository.deleteOrUpdate(grocery);
    }

    public void updateDatebaseWithGroceryList(){

    }


}
