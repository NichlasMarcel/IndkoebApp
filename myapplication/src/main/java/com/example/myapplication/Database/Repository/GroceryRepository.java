package com.example.myapplication.Database.Repository;

import android.app.Application;
import android.os.AsyncTask;

import com.example.myapplication.Database.AppDatabase;
import com.example.myapplication.Database.Dao.GroceryDao;
import com.example.myapplication.Database.Entities.Grocery;

import java.util.List;

public class GroceryRepository {
    private GroceryDao groceryDao;

    public GroceryRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        groceryDao = db.groceryDao();
    }

    public void deleteAll(){
        groceryDao.deleteAll();
    }

    public List<Grocery> getAll() {
        return groceryDao.getAll();
    }

    public List<Grocery> getById(long id){
        return groceryDao.getById(id);
    }

    public void insert(Grocery... grocery) {
        new insertAsyncTask(groceryDao).doInBackground(grocery);
    }

    private static class insertAsyncTask extends AsyncTask<Grocery, Void, Void> {
        private GroceryDao mAsyncTaskDao;

        insertAsyncTask(GroceryDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Grocery... groceries) {
            for (Grocery grocery : groceries) {
                mAsyncTaskDao.insert(grocery);
            }
            return null;
        }
    }
}
