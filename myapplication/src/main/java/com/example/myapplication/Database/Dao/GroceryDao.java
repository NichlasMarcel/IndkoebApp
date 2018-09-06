package com.example.myapplication.Database.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.myapplication.Database.Entities.Grocery;

import java.util.List;

@Dao
public interface GroceryDao {

    @Query("SELECT * from groceries")
    List<Grocery> getAll();

    @Query("SELECT * from groceries where uid=:id")
    List<Grocery> getById(int id);

    @Insert
    void insert(Grocery grocery);

    @Query("DELETE FROM groceries")
    void deleteAll();

    @Insert
    void insertAll(Grocery... groceries);
}
