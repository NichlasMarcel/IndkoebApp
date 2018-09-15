package com.example.myapplication.Database.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.myapplication.Database.Entities.RecipeItem;

@Dao
public interface RecipeItemDao {
    @Insert
    void insert(RecipeItem recipeItem);

    @Query("DELETE FROM recipeItem WHERE uid=:id")
    void deleteById(int id);
}
