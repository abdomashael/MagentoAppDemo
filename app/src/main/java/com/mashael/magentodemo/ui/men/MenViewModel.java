package com.mashael.magentodemo.ui.men;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mashael.magentodemo.data.Repository;
import com.mashael.magentodemo.data.database.entities.Category;

import java.util.List;

public class MenViewModel extends ViewModel {


    public MenViewModel() {
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