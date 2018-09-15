package com.example.myapplication.Database.Repository;

import android.app.Application;

import com.example.myapplication.Database.AppDatabase;
import com.example.myapplication.Database.Dao.RecipeDao;
import com.example.myapplication.Database.Dao.RecipeItemDao;

public class RecipeRepository {
    private RecipeDao recipeDao;
    private RecipeItemDao recipeItemDao;

    public RecipeRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);

    }
}
