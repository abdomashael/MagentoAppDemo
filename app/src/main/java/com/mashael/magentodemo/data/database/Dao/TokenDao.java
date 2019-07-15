package com.mashael.magentodemo.data.database.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.mashael.magentodemo.data.database.entities.Token;

@Dao
public interface TokenDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Token[] tokens);

    @Query("SELECT token from token_table where id=:mId ")
    LiveData<String> getTokenValue(int mId);

}
