package com.mashael.magentodemo.ui.women;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.mashael.magentodemo.data.Repository;
import com.mashael.magentodemo.data.api.models.CategoryProducts;
import com.mashael.magentodemo.data.database.entities.Category;

import java.util.List;

import retrofit2.Callback;

public class WomenViewModel extends ViewModel {

    public WomenViewModel() {
    }


    public LiveData<Category> getWomenCategoryBasicData(Repository repository,int parentId,String categoryName){
        repository.setCategory(parentId,categoryName);
        return repository.getCategory();
    }

    public LiveData<List<Category>> getSubCategories(Repository repository,int parentId){
        repository.setSubCategories(parentId);
        return repository.getSubCategories();
    }
    public void getWomenCategoryProducts(Repository repository,
                                         String tokenValue,
                                         String categoryId,
                                         Callback<List<CategoryProducts>> listCallback) {
        repository.getCategoryProducts(tokenValue, categoryId, listCallback);
    }
}