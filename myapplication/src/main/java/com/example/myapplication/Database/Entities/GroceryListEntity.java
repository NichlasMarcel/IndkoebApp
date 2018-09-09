package com.example.myapplication.Database.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "groceryList")
public class GroceryListEntity {
    @PrimaryKey(autoGenerate = true)
    private int uid;
    @ColumnInfo(name = "grocery")
    int groceryId;
    @ColumnInfo(name = "amount")
    Integer amount;
    @ColumnInfo(name = "checked")
    boolean checked;

    public GroceryListEntity() {
    }

    public GroceryListEntity(Grocery grocery, Integer amount, boolean checked) {
        this.groceryId = grocery.getUid();
        this.amount = amount;
        this.checked = checked;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getGroceryId() {
        return groceryId;
    }

    public void setGroceryId(int groceryId) {
        this.groceryId = groceryId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
