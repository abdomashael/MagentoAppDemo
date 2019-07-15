package com.mashael.magentodemo.ui.activities;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.mashael.magentodemo.R;
import com.mashael.magentodemo.data.Repository;
import com.mashael.magentodemo.data.api.models.products_details.CategoryProductsDetails;
import com.mashael.magentodemo.ui.activities.view_models.ProductsViewModel;
import com.mashael.magentodemo.ui.adapters.ProductsRecyclerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends AppCompatActivity {


    public final static String CAT_ID = "category id";
    public final static String CAT_NAME = "category name";
    public final static String PRODUCTS_COUNT = "products count";
    private final static String TAG = ProductsActivity.class.getSimpleName();

    @BindView(R.id.shimmer_view_container)
    ShimmerFrameLayout shimmerViewContainer;


    @BindView(R.id.productsRecyclerView)
    RecyclerView productsRecyclerView;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.backBtn)
    ImageButton backBtn;
    @BindView(R.id.titleTextView)
    TextView titleTextView;


    private ProductsViewModel mProductsViewModel;
    private Repository mRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        ButterKnife.bind(this);

        titleTextView.setText(getIntent().getStringExtra(CAT_NAME));

        mProductsViewModel =
                ViewModelProviders.of(this).get(ProductsViewModel.class);

        mRepository = Repository.getRepository(getApplication());

        productsRecyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        productsRecyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));


    }

    @Override
    protected void onResume() {
        super.onResume();

        new Handler().post(() -> shimmerViewContainer.startShimmerAnimation());

        showProducts();

    }

    private void showProducts() {

        mProductsViewModel.getResponseMutableLiveData().observe(
                this, response -> {
                    Log.d(TAG, "showProducts: " + response);
                    if (response != null) {

                        ProductsRecyclerAdapter mProductsRecyclerAdapter =
                                new ProductsRecyclerAdapter(ProductsActivity.this,
                                        response.body().getItems());

                        productsRecyclerView.setVisibility(View.VISIBLE);
                        productsRecyclerView.setAdapter(mProductsRecyclerAdapter);
                        productsRecyclerView.setLayoutManager(
                                new GridLayoutManager(ProductsActivity.this,
                                        getResources().getInteger(R.integer.span_count)));

                        scrollView.setVisibility(View.GONE);
                        shimmerViewContainer.stopShimmerAnimation();
                        shimmerViewContainer.setVisibility(View.GONE);
                    } else
                        getCategoryProducts();
                });
    }

    @Override
    protected void onPause() {
        shimmerViewContainer.stopShimmerAnimation();
        super.onPause();
    }

    private void getAuthToken() {
        mRepository.adminToken(
                new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call,
                                           Response<String> response) {
                        String accessToken = "Bearer " + response.body();
                        Log.e(TAG, "onResponse: " + accessToken);
                        mProductsViewModel.changeSharedPreferenceValue(R.id.token_id,
                                accessToken, ProductsActivity.this);
                        getCategoryProducts();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.e(TAG, "onFailure: token", t);

                    }
                });
    }

    private void getCategoryProducts() {
        new Handler(getMainLooper()).post(() -> {
            String mTokenValue = mProductsViewModel.getSharedPrefStringValue
                    (R.id.token_id, R.string.token_default_value, ProductsActivity.this);

            Log.d(TAG, "getCategoryProducts: token" + mTokenValue);

            if (mTokenValue.equals(getString(R.string.token_default_value))) {
                getAuthToken();
                Log.d(TAG, "getCategoryProducts: Get Auth");
            } else {
                Log.d(TAG, "getCategoryProducts: get products");
                mProductsViewModel.getCategoryProducts(mRepository,
                        mTokenValue,
                        getIntent().getStringExtra(CAT_ID),
                        productsDetailsCallback());

            }
        });
    }

    private Callback<CategoryProductsDetails> productsDetailsCallback() {
        return new Callback<CategoryProductsDetails>() {
            @Override
            public void onResponse(Call<CategoryProductsDetails> call,
                                   Response<CategoryProductsDetails> response) {


                Log.d(TAG, "onResponse: " + response.message());
                Log.d(TAG, "onResponse: " + response.body());
                mProductsViewModel.setResponseMutableLiveData(response);


            }

            @Override
            public void onFailure(Call<CategoryProductsDetails> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);

            }
        };
    }

    @OnClick(R.id.backBtn)
    public void onBackBtnClicked() {
        onBackPressed();
    }

}
