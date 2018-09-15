package com.example.myapplication.Database.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.myapplication.Database.Entities.Recipe;

@Dao
public interface RecipeDao {
    @Insert
    void insert(Recipe Recipe);

    @Query("DELETE FROM recipe WHERE uid=:id")
    void deleteById(int id);
}
