package com.example.myapplication.Database.Repository;

import android.app.Application;

import com.example.myapplication.Database.ActivityDatabase;
import com.example.myapplication.Database.AppDatabase;
import com.example.myapplication.Database.Dao.RecipeDao;
import com.example.myapplication.Database.Dao.RecipeItemDao;
import com.example.myapplication.Database.Dao.RecipeToRecipeItemEntityDao;
import com.example.myapplication.Database.Entities.RecipeEntity;
import com.example.myapplication.Database.Entities.RecipeItemEntity;
import com.example.myapplication.Database.Entities.RecipeToRecipeItemEntity;
import com.example.myapplication.Dishes.Recipe;
import com.example.myapplication.Dishes.RecipeItem;

import java.util.ArrayList;
import java.util.List;

public class RecipeRepository {
    private RecipeDao recipeDao;
    private RecipeToRecipeItemEntityDao recipeToRecipeItemEntityDao;
    private RecipeItemDao recipeItemDao;

    public RecipeRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        recipeDao = db.recipeDao();
        recipeToRecipeItemEntityDao = db.recipeToRecipeItemEntityDao();
        recipeItemDao = db.recipeItemDao();
    }

    public void InsertRecipe(Recipe recipe){
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setTitle(recipe.getTitle());

        long recipeId = recipeDao.insert(recipeEntity);

        for(RecipeItem recipeItem : recipe.getGroceries()){
            RecipeItemEntity recipeItemEntity = new RecipeItemEntity(recipeItem.getGrocery().getUid(), recipeItem.getAmount());
            long recipeItemId = recipeItemDao.insert(recipeItemEntity);
            recipeToRecipeItemEntityDao.insert(new RecipeToRecipeItemEntity(recipeId,recipeItemId));
        }
    }

    public List<Recipe> getAllRecipes(){
        List<Recipe> recipes = new ArrayList<>();
        List<RecipeEntity> recipeEntities =  recipeDao.getAll();

        for (RecipeEntity recipeEntity : recipeEntities) {
            Recipe recipe = new Recipe();
            recipe.setTitle(recipeEntity.getTitle());

            List<RecipeToRecipeItemEntity> recipeToRecipeItemEntityList = recipeToRecipeItemEntityDao.getRecipeItemsByRecipeId(recipeEntity.getUid());
            for (RecipeToRecipeItemEntity recipeToRecipeItemEntity : recipeToRecipeItemEntityList) {
                RecipeItemEntity recipeItemEntity = recipeItemDao.getById(recipeToRecipeItemEntity.getRecipeItemId()).get(0);
                RecipeItem recipeItem = new RecipeItem();
                recipeItem.setAmount(recipeItemEntity.getAmount());
                recipeItem.setRecipe(recipe);
                recipeItem.setGrocery(ActivityDatabase.getGroceryRepository().getById(recipeItemEntity.getGroceryId()).get(0));
                recipe.getGroceries().add(recipeItem);
            }

            recipes.add(recipe);
        }

        return recipes;
    }

}
