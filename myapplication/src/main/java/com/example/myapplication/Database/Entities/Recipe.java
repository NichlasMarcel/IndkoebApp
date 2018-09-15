package com.example.myapplication.Database.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "recipe")
public class Recipe {
    @PrimaryKey(autoGenerate = true)
    private int uid;
    @ColumnInfo(name = "recipeId")
    int recipeId;
    @ColumnInfo(name = "recipeItemId")
    int recipeItemId;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getRecipeItemId() {
        return recipeItemId;
    }

    public void setRecipeItemId(int recipeItemId) {
        this.recipeItemId = recipeItemId;
    }
}
