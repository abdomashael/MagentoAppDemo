package com.mashael.magentodemo.ui.gears;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.mashael.magentodemo.data.Repository;
import com.mashael.magentodemo.data.database.entities.Category;

import java.util.List;

public class GearsViewModel extends ViewModel {


    public GearsViewModel() {

    }


    public LiveData<Category> getWomenCategoryBasicData(Repository repository, int parentId, String categoryName){
        repository.setCategory(parentId,categoryName);
        return repository.getCategory();
    }

    public LiveData<List<Category>> getSubCategories(Repository repository, int parentId){
        repository.setSubCategories(parentId);
        return repository.getSubCategories();
    }

}