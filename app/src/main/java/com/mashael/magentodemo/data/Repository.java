package com.mashael.magentodemo.data;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.mashael.magentodemo.data.api.LumaApi;
import com.mashael.magentodemo.data.api.models.Categories;
import com.mashael.magentodemo.data.api.models.CategoryProducts;
import com.mashael.magentodemo.data.database.Dao.CategoryDao;
import com.mashael.magentodemo.data.database.LumaRoomDatabase;
import com.mashael.magentodemo.data.database.entities.Category;

import java.util.List;

import retrofit2.Callback;

public class Repository {
    private static final String TAG = Repository.class.getSimpleName();
    private CategoryDao mCategoryDao;
    private LiveData<Category> mCategory;
    private LiveData<List<Category>> mCategoriesList;

    private static volatile Repository INSTANCE;
    private final LumaApi mLumaApi;

    public static Repository getRepository(final Application application) {
        if (INSTANCE == null) {
            synchronized (Repository.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = new Repository(application);
                }
            }
        }
        return INSTANCE;
    }

    private Repository(Application application) {
        LumaRoomDatabase db = LumaRoomDatabase.getDatabase(application);
        mLumaApi = new LumaApi();
        mCategoryDao = db.mCategoryDao();
    }



    /**---------------------------- Database methods----------------------**/

    public void setCategoriesList(int[] id) {
        mCategoriesList = mCategoryDao.getCategory(id);
    }

    public LiveData<List<Category> > getCategoriesList() {
        return mCategoriesList;
    }

    public void setCategory(int parentId,String categoryName){
        mCategory=mCategoryDao.getCategory(parentId, categoryName);
    }

    public LiveData<Category> getCategory() {
        return mCategory;
    }

    public void setSubCategories(int parentId){
        mCategoriesList = mCategoryDao.getSubCategories(parentId);
    }

    public LiveData<List<Category>> getSubCategories(){
        return mCategoriesList;
    }

    public void insertCategory(List<Category> categories) {
        Category[] mCategories = new Category[categories.size()];
        for (int x = 0; x < categories.size(); x++)
            mCategories[x] = categories.get(x);

        new insertAsyncTask(mCategoryDao).execute(mCategories);
    }

    /**---------------------------- Api methods----------------------**/

    public void getAllCategories(String mTokenValue,
                                 Callback<Categories> allCategoriesCallback){
        mLumaApi.getAllCategories(mTokenValue, allCategoriesCallback);
    }

    public void getCategoryProducts(String tokenValue, String categoryId, Callback<List<CategoryProducts>> listCallback){
        mLumaApi.getCategoryProducts(tokenValue, categoryId, listCallback);
    }

    public void adminToken(Callback<String> tokenCallback) {
        mLumaApi.adminToken(tokenCallback);
    }



    /**---------------------------- Api methods end ----------------------**/

    private static class insertAsyncTask extends AsyncTask<Category, Void, Void> {
        private CategoryDao mCategoryDao;

        insertAsyncTask(CategoryDao categoryDao) {
            mCategoryDao = categoryDao;

        }

        @Override
        protected Void doInBackground(final Category... categories) {
            mCategoryDao.insert(categories);
            Log.d(TAG, "doInBackground: " + categories.length);
            return null;
        }

    }
}
