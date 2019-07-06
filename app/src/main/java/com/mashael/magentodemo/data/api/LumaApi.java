package com.mashael.magentodemo.data.api;

import com.mashael.magentodemo.data.api.interfaces.AuthService;
import com.mashael.magentodemo.data.api.interfaces.CategoriesInterface;
import com.mashael.magentodemo.data.api.interfaces.CategoryProductsInterface;
import com.mashael.magentodemo.data.api.models.Categories;
import com.mashael.magentodemo.data.api.models.CategoryProducts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LumaApi {
    public static final String API_BASE_URL = "http://134.209.89.178/index.php/rest/default/V1/";
    private static final String USER = "abdo";
    private static final String PASS = "ca&O0oD6bzq#M#2NnMi";

    public static final String TAG = LumaApi.class.getSimpleName();

    private static String sAcessToken = "Bearer ";

    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build();

    private static Retrofit sRetrofit =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();

    public void adminToken(Callback<String> tokenCallBack) {
        AuthService mService = sRetrofit.create(AuthService.class);
        mService.getAdminToken(USER, PASS).enqueue(tokenCallBack);
    }

    public void getAllCategories(String tokenValue, Callback<Categories> categoriesCallback) {
        CategoriesInterface mCategoriesInterface = sRetrofit.create(CategoriesInterface.class);
        mCategoriesInterface.getAllCategories(tokenValue).enqueue(categoriesCallback);
    }

    public void getCategoryProducts(String tokenValue,
                                    String categoryId,
                                    Callback<List<CategoryProducts>> categoryProductsCallBack) {
        CategoryProductsInterface mCategoryProductsInterface =
                sRetrofit.create(CategoryProductsInterface.class);
        mCategoryProductsInterface
                .getCategoryProducts(tokenValue, categoryId)
                .enqueue(categoryProductsCallBack);
    }



    /*@Override
    public void onResponse(Call<String> call, Response<String> response) {
        sAcessToken= sAcessToken+response.body();
        Log.e(TAG, "onResponse: "+sAcessToken );

     *//*   mCategoriesIterface.getAllCategories(sAcessToken).enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {
                Log.e(TAG, "onResponse: "+response.raw());

                Log.e(TAG, "onResponse: "+response.message());

                Log.e(TAG, "onResponse: "+ response.body());

                Log.e(TAG, "onResponse: "+response.errorBody());

            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.toString());

            }
        });
      *//*  *//*    ProductsInterface mProductsInterface = sRetrofit.create(ProductsInterface.class);
        mProductsInterface.getAllProducts(sAcessToken).enqueue(new Callback<Products>() {
            @Override
            public void onResponse(Call<Products> call, Response<Products> response) {
                Log.e(TAG, "onResponse: "+response.body().toString() );
            }

            @Override
            public void onFailure(Call<Products> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());

            }
        });
    *//*}

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        Log.e(TAG, "onFail: " +t.getMessage());

    }*/
}

