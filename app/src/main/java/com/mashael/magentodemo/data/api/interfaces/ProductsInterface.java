package com.mashael.magentodemo.data.api.interfaces;

import com.mashael.magentodemo.data.api.models.Products;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ProductsInterface{
    @GET("products?searchCriteria=all")
    Call<Products> getAllProducts(@Header("Authorization") String accessToken);

}
