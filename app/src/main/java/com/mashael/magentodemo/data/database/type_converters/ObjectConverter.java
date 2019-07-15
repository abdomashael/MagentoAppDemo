package com.mashael.magentodemo.data.database.type_converters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashael.magentodemo.data.api.models.products_details.MediaGalleryEntries;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class ObjectConverter {
    private static Gson gson = new Gson();
    @TypeConverter
    public Object stringToList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<Object>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public String ListToString(Object someObjects) {
        return gson.toJson(someObjects);
    }
}