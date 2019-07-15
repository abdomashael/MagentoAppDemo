package com.mashael.magentodemo.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mashael.magentodemo.R;

public class ProductsShimmerRecyclerAdapter
        extends RecyclerView.Adapter<ProductsShimmerRecyclerAdapter.ViewHolder> {

    Context mContext;
    int mItemsCount;

    public ProductsShimmerRecyclerAdapter(Context context, int itemsCount) {
        mContext = context;
        mItemsCount = itemsCount;
    }

    @NonNull
    @Override
    public ProductsShimmerRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);

        // Inflate the custom layout
        View shimmerView = inflater.inflate(R.layout.product_item_shimmer, parent, false);

        return new ViewHolder(shimmerView);

    }

    @Override
    public void onBindViewHolder(@NonNull ProductsShimmerRecyclerAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mItemsCount;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
