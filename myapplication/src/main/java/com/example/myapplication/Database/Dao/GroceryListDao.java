package com.example.myapplication.Database.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.myapplication.Database.Entities.GroceryListEntity;

import java.util.List;

@Dao
public interface GroceryListDao {
    @Query("SELECT * from groceryList")
    List<GroceryListEntity> getAll();

    @Insert
    long insert(GroceryListEntity grocery);

    @Query("DELETE FROM groceryList")
    void deleteAll();

    @Query("DELETE FROM groceryList WHERE uid=:id")
    void deleteById(int id);

    @Query("UPDATE groceryList SET amount=:amount, checked=:checked WHERE uid =:id")
    void update(Integer amount, boolean checked, int id);

    @Insert
    void insertAll(GroceryListEntity... groceries);
}
