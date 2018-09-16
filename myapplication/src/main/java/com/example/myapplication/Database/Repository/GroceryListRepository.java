package com.example.myapplication.Database.Repository;

import android.app.Application;
import android.os.AsyncTask;

import com.example.myapplication.Database.AppDatabase;
import com.example.myapplication.Database.Dao.GroceryListDao;
import com.example.myapplication.Database.Entities.Grocery;
import com.example.myapplication.Database.Entities.GroceryListEntity;

import java.util.List;

public class GroceryListRepository {
    GroceryListDao groceryListDao;
    GroceryRepository groceryRepository;

    public GroceryListRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        groceryListDao = db.groceryListDao();
        this.groceryRepository = new GroceryRepository(application);
    }

    public void deleteAll() {
        groceryListDao.deleteAll();
    }

    public List<GroceryListEntity> getAll() {
        return groceryListDao.getAll();
    }

    public void insert(GroceryListEntity... grocery) {
        new insertAsyncTask(groceryListDao).doInBackground(grocery);
    }

    public void updateChecked(GroceryListEntity groceryListEntity, boolean value) {
        groceryListDao.update(groceryListEntity.getAmount(), value, groceryListEntity.getUid());
    }

    public void insertAndUpdate(final Grocery... groceries) {
        for (Grocery grocery : groceries) {
            boolean exist = false;
            GroceryListEntity tmpGroceryListEntity = null;
            for (GroceryListEntity groceryListEntity : getAll()) {
                if (groceryRepository.getById(groceryListEntity.getGroceryId()).get(0).getUid() == grocery.getUid()) {
                    tmpGroceryListEntity = groceryListEntity;
                    break;
                }
            }

            if (tmpGroceryListEntity == null)
                new insertAsyncTask(groceryListDao).doInBackground(new GroceryListEntity(grocery, new Integer(1), false));
            else
                groceryListDao.update(tmpGroceryListEntity.getAmount() + 1, tmpGroceryListEntity.isChecked(), tmpGroceryListEntity.getUid());
        }
    }

    public void deleteOrUpdate(final GroceryListEntity groceryListEntity) {
        if (groceryListEntity.getAmount() != 1) {
            groceryListDao.update(groceryListEntity.getAmount() - 1, groceryListEntity.isChecked(), groceryListEntity.getUid());
        } else {
            groceryListDao.deleteById(groceryListEntity.getUid());
        }

    }


    private static class insertAsyncTask extends AsyncTask<GroceryListEntity, Void, Void> {
        private GroceryListDao mAsyncTaskDao;

        insertAsyncTask(GroceryListDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final GroceryListEntity... groceries) {
            for (GroceryListEntity grocery : groceries) {
                mAsyncTaskDao.insert(grocery);
            }
            return null;
        }
    }
}
