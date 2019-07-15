package com.mashael.magentodemo.data.api.interfaces;

import com.mashael.magentodemo.data.api.models.products_details.CategoryProductsDetails;
import com.mashael.magentodemo.data.api.models.Products;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ProductsInterface {
    @GET("products?searchCriteria=all")
    Call<Products> getAllProducts(@Header("Authorization") String accessToken);

    @GET("products/?searchCriteria")
    Call<CategoryProductsDetails> getCustomSearchProducts(@Header("Authorization") String accessToken,
                                                          @Query("searchCriteria[filter_groups][0][filters][0][field]") String searchField,
                                                          @Query("searchCriteria[filter_groups][0][filters][0][value]") String searchValue,
                                                          @Query("searchCriteria[filter_groups][0][filters][0][condition_type]") String operator
                                                          );

}
