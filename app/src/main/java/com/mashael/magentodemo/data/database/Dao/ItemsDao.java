package com.mashael.magentodemo.data.database.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.mashael.magentodemo.data.api.models.products_details.Items;

import java.util.List;

@Dao
public interface ItemsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Items[] items);

    @Query("DELETE FROM items_table")
    void deleteAll();

    @Query("SELECT * from items_table where id IN (:itemsId)")
    LiveData<List<Items>> getItems(int[] itemsId);

    @Query("SELECT * from items_table")
    LiveData<List<Items>> getItems();

}
