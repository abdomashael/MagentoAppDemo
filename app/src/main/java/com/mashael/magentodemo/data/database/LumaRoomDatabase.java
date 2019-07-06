package com.mashael.magentodemo.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.mashael.magentodemo.data.database.Dao.CategoryDao;
import com.mashael.magentodemo.data.database.entities.Category;

@Database(entities = {Category.class}, version = 1)
public abstract class LumaRoomDatabase extends RoomDatabase {
    public abstract CategoryDao mCategoryDao();

    private static volatile LumaRoomDatabase INSTANCE;

    public static LumaRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (LumaRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            LumaRoomDatabase.class, "magentoDb")
                            .build();                }
            }
        }
        return INSTANCE;
    }


}
