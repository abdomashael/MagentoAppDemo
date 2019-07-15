package com.mashael.magentodemo.data.database.type_converters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashael.magentodemo.data.api.models.products_details.CustomAttributes;
import com.mashael.magentodemo.data.api.models.products_details.ExtensionAttributes;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;


public class ExtensionAttributesTypeConverter {
    private static Gson gson = new Gson();
    @TypeConverter
    public ExtensionAttributes stringToList(String data) {
        if (data == null) {
            return null;
        }

        Type listType = new TypeToken<ExtensionAttributes>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public String ListToString(ExtensionAttributes someObjects) {
        return gson.toJson(someObjects);
    }
}