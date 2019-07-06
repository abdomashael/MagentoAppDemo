package com.mashael.magentodemo;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.mashael.magentodemo.ui.adapters.ProductsRecyclerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsActivity extends AppCompatActivity {

    public final static String CAT_ID = "category id";
    public final static String PRODUCTS_COUNT = "products count";
    @BindView(R.id.productsRecyclerView)
    RecyclerView productsRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        ButterKnife.bind(this);

        productsRecyclerView.addItemDecoration(new
                DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        productsRecyclerView.addItemDecoration(new
                DividerItemDecoration(this,
                DividerItemDecoration.HORIZONTAL));

        new Handler().post(() ->
                productsRecyclerView.setAdapter(
                        new ProductsRecyclerAdapter(ProductsActivity.this)
                )
        );


    }
}
