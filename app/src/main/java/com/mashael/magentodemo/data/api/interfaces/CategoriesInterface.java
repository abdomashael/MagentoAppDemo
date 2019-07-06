package com.mashael.magentodemo.data.api.interfaces;

import com.mashael.magentodemo.data.api.models.Categories;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface CategoriesInterface {
    @GET("categories?searchCriteria=all")
    Call<Categories> getAllCategories(@Header("Authorization") String accessToken);
}
