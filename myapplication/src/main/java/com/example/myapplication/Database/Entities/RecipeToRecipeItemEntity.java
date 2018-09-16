package com.example.myapplication.Database.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "recipeToRecipeItem")
public class RecipeToRecipeItemEntity {
    @PrimaryKey(autoGenerate = true)
    private long uid;
    @ColumnInfo(name = "recipeId")
    long recipeId;
    @ColumnInfo(name = "recipeItemId")
    long recipeItemId;

    public RecipeToRecipeItemEntity(long recipeId, long recipeItemId) {
        this.recipeId = recipeId;
        this.recipeItemId = recipeItemId;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }

    public long getRecipeItemId() {
        return recipeItemId;
    }

    public void setRecipeItemId(long recipeItemId) {
        this.recipeItemId = recipeItemId;
    }
}
