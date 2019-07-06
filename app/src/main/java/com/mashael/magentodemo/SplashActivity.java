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

public class SplashActivity extends AppCompatActivity {
    public static final String TAG = BodyActivity.class.getSimpleName();

    private MySharedPreferences mMySharedPreferences;
    private Repository mRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getStrictMode();

        mRepository = Repository.getRepository(getApplication());
        mMySharedPreferences = new MySharedPreferences(this);

        getAllCategories();
    }

    private void getStrictMode() {
        if (BuildConfig.DEBUG) {
            StrictMode.ThreadPolicy mPolicy =
                    new StrictMode.ThreadPolicy.Builder()
                            .detectAll()
                            .penaltyLog()
                            .build();
            StrictMode.setThreadPolicy(mPolicy);
        }
    }

    private void getAllCategories() {
        new Handler(getMainLooper()).post(() -> {
            String mTokenValue = mMySharedPreferences.getSharedPrefStringValue
                    (R.id.token_id, R.string.token_default_value);

            if (mTokenValue.equals(getString(R.string.token_default_value))) {
                getAuthToken();
            } else {
                Log.d(TAG, "getAllCategories: ");
                mRepository.getAllCategories(mTokenValue, allCategoriesCallback());

            }
        });

    }

    private Callback<Categories> allCategoriesCallback() {
        return new Callback<Categories>() {
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {
                if (response.body() != null) {
                    List<Category> mCategoryList = response.body().getAllCategories();
                    Log.d(TAG, "onResponse: " + mCategoryList.size());
                    mRepository.insertCategory(mCategoryList);
                    startActivity(new Intent(SplashActivity.this
                            , BodyActivity.class));
                    finish();

                }
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {
                Log.e(TAG, "onFailure: cat ", t);
                if (t.getMessage().equals("Unauthorized")) {
                    getAuthToken();
                }

            }
        };
    }

    private void getAuthToken() {
        mRepository.adminToken(
                new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        String accessToken = "Bearer " + response.body();
                        Log.e(TAG, "onResponse: " + accessToken);
                        mMySharedPreferences.setSharedPrefValue(R.id.token_id, accessToken);
                        getAllCategories();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.e(TAG, "onFailure: token", t);

                    }
                });
    }
}
