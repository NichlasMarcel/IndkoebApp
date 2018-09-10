package com.example.myapplication.Fragment;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.myapplication.Database.ActivityDatabase;
import com.example.myapplication.Database.Entities.Grocery;
import com.example.myapplication.Database.Entities.GroceryListEntity;
import com.example.myapplication.Database.Repository.GroceryListRepository;
import com.example.myapplication.Database.Repository.GroceryRepository;
import com.example.myapplication.Dialog.AddGrocery;
import com.example.myapplication.GroceryList.GroceryList;
import com.example.myapplication.GroceryList.GroceryListArrayAdapter;
import com.example.myapplication.GroceryViewModel;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class BasketFragment extends Fragment {

    ListView listView;
    List<GroceryListEntity> groceryList = new ArrayList<>();
    private GroceryViewModel groceryViewModel;
    GroceryListArrayAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basket,container,false);

        final AddGrocery newFragment = new AddGrocery();
        FloatingActionButton fab = (FloatingActionButton)view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newFragment.show(getFragmentManager(), "dialog");
            }
        });

        groceryViewModel = ViewModelProviders.of(this).get(GroceryViewModel.class);
        listView = (ListView) view.findViewById(R.id.mobile_list);
        groceryList = ActivityDatabase.getGroceryListRepository().getAll();
        fillList();
        return view;
    }

    public void fillList(){
        updateGroceryList();
        adapter = new GroceryListArrayAdapter(getContext(), groceryList, (GroceryList) getActivity());
        listView.setAdapter(adapter);
    }

    public void updateChecked(GroceryListEntity groceryListEntity, boolean value){
        ActivityDatabase.getGroceryListRepository().updateChecked(groceryListEntity,value);
    }

    public void updateGroceryList(){
        groceryList.clear();
        groceryList = ActivityDatabase.getGroceryListRepository().getAll();
    }

    public void addGroceryToList(Grocery grocery){
        ActivityDatabase.getGroceryListRepository().insertAndUpdate(grocery);
    }

    public void removeGroceryFromList(GroceryListEntity grocery){
        ActivityDatabase.getGroceryListRepository().deleteOrUpdate(grocery);
    }
}
