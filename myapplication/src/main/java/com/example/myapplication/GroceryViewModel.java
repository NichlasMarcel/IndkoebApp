package com.example.myapplication;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.myapplication.Database.Entities.Grocery;
import com.example.myapplication.Database.Repository.GroceryRepository;

import java.util.List;

public class GroceryViewModel extends AndroidViewModel {

    private GroceryRepository groceryRepository;


    public GroceryViewModel(@NonNull Application application) {
        super(application);
        groceryRepository = new GroceryRepository(application);
    }

    public List<Grocery> getAll(){
        return groceryRepository.getAll();
    }

    public void insert(Grocery grocery){
        groceryRepository.insert(grocery);
    }
}
