package com.example.myapplication.Database.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.example.myapplication.Database.Entities.RecipeEntity;

import java.util.List;

@Dao
public interface RecipeDao {
    @Query("SELECT * from recipe")
    List<RecipeEntity> getAll();

    @Insert
    long insert(RecipeEntity Recipe);

    @Query("DELETE FROM recipe WHERE uid=:id")
    void deleteById(int id);
}
