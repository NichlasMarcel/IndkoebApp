package com.example.myapplication.Database;

import com.example.myapplication.Database.Repository.GroceryListRepository;
import com.example.myapplication.Database.Repository.GroceryRepository;

public class ActivityDatabase {
    public static GroceryRepository groceryRepository;
    public static GroceryListRepository groceryListRepository;

    public static GroceryRepository getGroceryRepository() {
        return groceryRepository;
    }

    public static void setGroceryRepository(GroceryRepository groceryRepository) {
        ActivityDatabase.groceryRepository = groceryRepository;
    }

    public static GroceryListRepository getGroceryListRepository() {
        return groceryListRepository;
    }

    public static void setGroceryListRepository(GroceryListRepository groceryListRepository) {
        ActivityDatabase.groceryListRepository = groceryListRepository;
    }
}
