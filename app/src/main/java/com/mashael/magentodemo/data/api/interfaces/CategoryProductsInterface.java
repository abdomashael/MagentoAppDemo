package com.mashael.magentodemo.data.api.interfaces;

import com.mashael.magentodemo.data.api.models.CategoryProducts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface CategoryProductsInterface {
    @GET("categories/{categoryId}/products")
    Call<List<CategoryProducts>>
    getCategoryProducts(@Header("Authorization") String accessToken,
                        @Path("categoryId")String categoryId);

}
