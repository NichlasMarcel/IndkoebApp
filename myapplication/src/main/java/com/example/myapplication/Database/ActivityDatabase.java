package com.example.myapplication.Database;

import android.app.Application;
import android.content.Context;

import com.example.myapplication.Database.Entities.Grocery;
import com.example.myapplication.Database.Repository.GroceryListRepository;
import com.example.myapplication.Database.Repository.GroceryRepository;
import com.example.myapplication.Database.Repository.RecipeRepository;
import com.example.myapplication.Dishes.Recipe;
import com.example.myapplication.Dishes.RecipeItem;

import java.util.List;

public class ActivityDatabase {
    public static GroceryRepository groceryRepository;
    public static GroceryListRepository groceryListRepository;
    public static RecipeRepository recipeRepository;
    public static Application application;

    private static ActivityDatabase instance = null;

    private ActivityDatabase() {
    }

    public static ActivityDatabase getInstance(final Application application) {
        if (instance == null) {
            groceryRepository = new GroceryRepository(application);
            groceryListRepository = new GroceryListRepository(application);
            recipeRepository = new RecipeRepository(application);
            instance = new ActivityDatabase();
        }

        return instance;
    }

    public static GroceryRepository getGroceryRepository() {
        return groceryRepository;
    }

    public static GroceryListRepository getGroceryListRepository() {
        return groceryListRepository;
    }

    public static RecipeRepository getRecipeRepository() {
        return recipeRepository;
    }

    public void PopulateDatabase(){
        groceryRepository.insert(AppDatabase.getInstance(application).populate());

        List<Grocery> groceryList = groceryRepository.getAll();

        Recipe recipe = new Recipe();
        recipe.setTitle("Burger");

        RecipeItem recipeItem = new RecipeItem();
        recipeItem.setGrocery(groceryList.get(0));
        recipeItem.setAmount(2);
        recipeItem.setRecipe(recipe);

        RecipeItem recipeItem2 = new RecipeItem();
        recipeItem2.setGrocery(groceryList.get(2));
        recipeItem2.setAmount(8);
        recipeItem2.setRecipe(recipe);

        recipe.getGroceries().add(recipeItem);
        recipe.getGroceries().add(recipeItem2);

        recipeRepository.InsertRecipe(recipe);
    }
}
