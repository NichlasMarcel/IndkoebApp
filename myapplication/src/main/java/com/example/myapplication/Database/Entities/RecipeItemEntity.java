package com.example.myapplication.Database.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "recipeItem")
public class RecipeItemEntity {
    @PrimaryKey(autoGenerate = true)
    private long uid;
    @ColumnInfo(name = "grocery")
    long groceryId;
    @ColumnInfo(name = "amount")
    Integer amount;

    public RecipeItemEntity() {
    }

    public RecipeItemEntity(long groceryId, Integer amount) {
        this.groceryId = groceryId;
        this.amount = amount;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getGroceryId() {
        return groceryId;
    }

    public void setGroceryId(long groceryId) {
        this.groceryId = groceryId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
