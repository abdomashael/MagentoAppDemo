package com.mashael.magentodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;

import com.mashael.magentodemo.data.Repository;
import com.mashael.magentodemo.data.api.models.Categories;
import com.mashael.magentodemo.data.database.entities.Category;
import com.mashael.magentodemo.utils.MySharedPreferences;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }





}
