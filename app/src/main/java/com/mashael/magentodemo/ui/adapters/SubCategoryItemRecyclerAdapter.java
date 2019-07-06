package com.mashael.magentodemo.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mashael.magentodemo.ProductsActivity;
import com.mashael.magentodemo.R;
import com.mashael.magentodemo.data.database.entities.Category;

import java.util.List;

public class SubCategoryItemRecyclerAdapter extends RecyclerView.Adapter<SubCategoryItemRecyclerAdapter.ViewHolder> {

    private static final String DRAWABLE = "drawable";
    private Context mContext;
    private List<Category> mCategoryList;

    private final static String ID_STRING = "id_";


    public SubCategoryItemRecyclerAdapter(Context context, List<Category> categoryList) {
        mContext = context;
        mCategoryList = categoryList;

    }

    @NonNull
    @Override
    public SubCategoryItemRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);

        // Inflate the custom layout
        View catView = inflater.inflate(R.layout.sub_category_item, parent, false);

        return new ViewHolder(catView);
    }

    @Override
    public void onBindViewHolder(@NonNull SubCategoryItemRecyclerAdapter.ViewHolder holder, int position) {
        Category mCategory = mCategoryList.get(position);

        holder.subCatTextView.setText(mCategory.getName());

        String id = ID_STRING + mCategory.getId();

        int resID = mContext.getResources()
                .getIdentifier(id, DRAWABLE, mContext.getPackageName());

        Glide.with(mContext)
                .load(resID)
                .thumbnail(0.1f)
                .into(holder.subCatImageView);
        holder.subCatLinearLayout.setOnClickListener(view -> {
            Intent mIntent = new Intent(mContext, ProductsActivity.class);
            mIntent.putExtra(ProductsActivity.CAT_ID,mCategory.getId());
            mIntent.putExtra(ProductsActivity.PRODUCTS_COUNT,mCategory.getProductCount());

            mContext.startActivity(mIntent);

        });
    }

    @Override
    public int getItemCount() {
        if (mCategoryList == null)
            return 0;
        return mCategoryList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView subCatImageView;
        TextView subCatTextView;
        LinearLayout subCatLinearLayout;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            subCatImageView = itemView.findViewById(R.id.sub_category_item_ImageView);
            subCatTextView = itemView.findViewById(R.id.sub_category_item_TextView);
            subCatLinearLayout = itemView.findViewById(R.id.subCategoryLayout);
        }
    }
}
