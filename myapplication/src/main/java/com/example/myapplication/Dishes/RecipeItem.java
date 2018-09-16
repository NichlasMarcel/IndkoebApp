package com.example.myapplication.Dishes;

import com.example.myapplication.Database.Entities.Grocery;

public class RecipeItem {
    private int uuid;
    private Recipe recipe;
    private Grocery grocery;
    private int amount;

    public RecipeItem() {
    }

    public RecipeItem(Recipe recipe, Grocery grocery, int amount) {
        this.recipe = recipe;
        this.grocery = grocery;
        this.amount = amount;
    }

    public RecipeItem(int uuid, Recipe recipe, Grocery grocery, int amount) {
        this.uuid = uuid;
        this.recipe = recipe;
        this.grocery = grocery;
        this.amount = amount;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Grocery getGrocery() {
        return grocery;
    }

    public void setGrocery(Grocery grocery) {
        this.grocery = grocery;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
