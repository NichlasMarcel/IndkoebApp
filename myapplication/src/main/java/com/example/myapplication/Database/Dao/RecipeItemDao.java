package com.example.myapplication.Database.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.myapplication.Database.Entities.RecipeEntity;
import com.example.myapplication.Database.Entities.RecipeItemEntity;

import java.util.List;

@Dao
public interface RecipeItemDao {
    @Query("SELECT * from recipeItem where uid =:id")
    List<RecipeItemEntity> getById(long id);

    @Query("SELECT * from recipeItem")
    List<RecipeEntity> getAll();

    @Insert
    long insert(RecipeItemEntity recipeItem);

    @Query("DELETE FROM recipeItem WHERE uid=:id")
    void deleteById(int id);
}
