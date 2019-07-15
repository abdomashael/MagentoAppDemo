package com.mashael.magentodemo.data.database.type_converters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashael.magentodemo.data.api.models.products_details.CustomAttributes;
import com.mashael.magentodemo.data.api.models.products_details.MediaGalleryEntries;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;


public class MediaGalleryTypeConverter {
    private static Gson gson = new Gson();
    @TypeConverter
    public List<MediaGalleryEntries> stringToList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<MediaGalleryEntries>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public String ListToString(List<MediaGalleryEntries> someObjects) {
        return gson.toJson(someObjects);
    }
}