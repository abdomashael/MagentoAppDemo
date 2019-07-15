package com.mashael.magentodemo.ui.activities.view_models;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mashael.magentodemo.data.Repository;
import com.mashael.magentodemo.data.api.models.CategoryProducts;
import com.mashael.magentodemo.data.api.models.products_details.CategoryProductsDetails;
import com.mashael.magentodemo.utils.MySharedPreferences;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsViewModel extends ViewModel {

    private MySharedPreferences mMySharedPreferences;
    private static final String OK = "OK";
    private String TAG = ProductsViewModel.class.getSimpleName();
    private MutableLiveData<Response<CategoryProductsDetails>> mResponseMutableLiveData;

    public ProductsViewModel(){
        mResponseMutableLiveData = new MutableLiveData<>();
        mResponseMutableLiveData.setValue(null);
    }

    public void getCategoryProducts(Repository repository,
                                    String tokenValue,
                                    String categoryId,
                                    Callback<CategoryProductsDetails> productsDetailsCallback) {

        repository.getCategoryProducts(tokenValue, categoryId, new Callback<List<CategoryProducts>>() {
            @Override
            public void onResponse(Call<List<CategoryProducts>> call, Response<List<CategoryProducts>> response) {

                Log.d(TAG, "onResponse: " + response.message());

                if (response.message().equals(OK)) {
                    Log.d(TAG, "onResponse: " + response.body().toString());

                    StringBuilder mSkuStringBuilder = new StringBuilder();
                    for (int idx = 0; idx < response.body().size(); idx++) {
                        mSkuStringBuilder.append(response.body().get(idx).getSku());

                        if (idx != response.body().size() - 1)
                            mSkuStringBuilder.append(",");
                    }

                    Log.d(TAG, "onResponse: " + mSkuStringBuilder.toString());

                    getCategoryProductsDetails(repository,
                            tokenValue,
                            mSkuStringBuilder.toString(),
                            productsDetailsCallback);
                }
            }

            @Override
            public void onFailure(Call<List<CategoryProducts>> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });

    }

    public void changeSharedPreferenceValue(int id, String value, Context context) {
        if (mMySharedPreferences == null)
            initSharedPreferences(context);
        mMySharedPreferences.setSharedPrefValue(id, value);
    }

    public String getSharedPrefStringValue(int id, int defaultValueId, Context context) {
        if (mMySharedPreferences == null)
            initSharedPreferences(context);

        return mMySharedPreferences.getSharedPrefStringValue
                (id, defaultValueId);
    }

    private void initSharedPreferences(Context context) {
        mMySharedPreferences = new MySharedPreferences(context);
    }

    private void getCategoryProductsDetails(Repository repository,
                                            String tokenValue,
                                            String skuListString,
                                            Callback<CategoryProductsDetails> productsDetailsCallback) {

        repository.getCategoryProductsDetails(tokenValue, skuListString, productsDetailsCallback);
    }

    public MutableLiveData<Response<CategoryProductsDetails>> getResponseMutableLiveData() {
        return mResponseMutableLiveData;
    }

    public void setResponseMutableLiveData(Response<CategoryProductsDetails> response) {
        mResponseMutableLiveData.setValue(response);
    }
}
