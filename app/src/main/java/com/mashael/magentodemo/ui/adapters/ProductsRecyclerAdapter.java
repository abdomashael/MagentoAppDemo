package com.mashael.magentodemo.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mashael.magentodemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsRecyclerAdapter extends RecyclerView.Adapter<ProductsRecyclerAdapter.ViewHolder> {

    Context mContext;

    public ProductsRecyclerAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);

        // Inflate the custom layout
        View catView = inflater.inflate(R.layout.product_item, parent, false);

        return new ViewHolder(catView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }



    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.product_linearLayout)
        LinearLayout productLinearLayout;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}


