package com.mashael.magentodemo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.Nullable;

import com.mashael.magentodemo.R;

import java.util.Map;
import java.util.Set;

import static android.content.Context.MODE_PRIVATE;

public class MySharedPreferences {
    private  Context mContext;
    private SharedPreferences sharedPref ;
    private SharedPreferences.Editor editor;

    public MySharedPreferences(Context context) {
        mContext = context;
        sharedPref = mContext.getSharedPreferences(mContext.getString(R.string.app_name),Context.MODE_PRIVATE);

    }

    public void setSharedPrefValue(int id,Object value) {
        editor = sharedPref.edit();

        if (value instanceof String) {
            editor.putString(mContext.getString(id), (String) value);
        }else if (value instanceof Integer){
            editor.putInt(mContext.getString(id), (Integer) value);
        }
        editor.apply();

    }

    public int getSharedPrefIntValue(int id,int defaultValueId){
        int defaultValue = mContext.getResources().getInteger(defaultValueId);
        return sharedPref.getInt(mContext.getString(id),defaultValue);
    }

    public String getSharedPrefStringValue(int id,int defaultValueId){
        String defaultValue = mContext.getString(defaultValueId);
        return sharedPref.getString(mContext.getString(id),defaultValue);
    }


}
