package com.example.myapplication.Dishes;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private int uuid;
    private String title;
    private List<RecipeItem> groceries;

    public Recipe() {
        this.groceries = new ArrayList<>();
    }

    public Recipe(String title, List<RecipeItem> groceries) {
        this.title = title;
        this.groceries = groceries;
    }

    public Recipe(int uuid, String title, List<RecipeItem> groceries) {
        this.uuid = uuid;
        this.title = title;
        this.groceries = groceries;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<RecipeItem> getGroceries() {
        return groceries;
    }

    public void setGroceries(List<RecipeItem> groceries) {
        this.groceries = groceries;
    }
}
