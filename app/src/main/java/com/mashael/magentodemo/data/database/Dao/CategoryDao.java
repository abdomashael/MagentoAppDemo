package com.mashael.magentodemo.data.database.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.mashael.magentodemo.data.database.entities.Category;

import java.util.List;

@Dao
public interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Category[] categories);

    @Query("DELETE FROM category_table")
    void deleteAll();

    @Query("SELECT * from category_table ORDER BY id ASC")
    LiveData<List<Category>> getAllCategory();

    @Query("SELECT * from category_table where parent_id=:parentId and name =:categoryName")
    LiveData<Category> getCategory(int parentId,String categoryName);

    @Query("SELECT * from category_table where parent_id=:parentId ")
    LiveData<List<Category>> getSubCategories(int parentId);

    @Query("SELECT * from category_table where id IN (:categoryId)")
    LiveData<List<Category>> getCategory(int[] categoryId);


}
