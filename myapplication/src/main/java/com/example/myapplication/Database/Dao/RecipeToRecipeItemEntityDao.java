package com.example.myapplication.Database.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.myapplication.Database.Entities.RecipeToRecipeItemEntity;

import java.util.List;

@Dao
public interface RecipeToRecipeItemEntityDao {
    @Query("SELECT * from recipeToRecipeItem")
    List<RecipeToRecipeItemEntity> getAll();

    @Query("SELECT * from recipeToRecipeItem where recipeId =:id")
    List<RecipeToRecipeItemEntity> getRecipeItemsByRecipeId(int id);


    @Insert
    long insert(RecipeToRecipeItemEntity recipeItem);

    @Query("DELETE FROM recipeToRecipeItem WHERE uid=:id")
    void deleteById(int id);
}
