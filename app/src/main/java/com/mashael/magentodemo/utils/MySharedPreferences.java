package com.mashael.magentodemo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.mashael.magentodemo.R;

import static android.content.Context.MODE_PRIVATE;

public class MySharedPreferences {
    private  Activity mActivity;
    private SharedPreferences sharedPref ;
    private SharedPreferences.Editor editor;

    public MySharedPreferences(Activity activity) {
        mActivity = activity;
        sharedPref = mActivity.getPreferences(Context.MODE_PRIVATE);

    }

    public void setSharedPrefValue(int id,Object value) {
        editor = sharedPref.edit();

        if (value instanceof String) {
            editor.putString(mActivity.getString(id), (String) value);
        }else if (value instanceof Integer){
            editor.putInt(mActivity.getString(id), (Integer) value);
        }
        editor.apply();

    }

    public int getSharedPrefIntValue(int id,int defaultValueId){
        int defaultValue = mActivity.getResources().getInteger(defaultValueId);
        return sharedPref.getInt(mActivity.getString(id),defaultValue);
    }

    public String getSharedPrefStringValue(int id,int defaultValueId){
        String defaultValue = mActivity.getString(defaultValueId);
        return sharedPref.getString(mActivity.getString(id),defaultValue);
    }


}
