package com.mashael.magentodemo.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.mashael.magentodemo.R;
import com.mashael.magentodemo.data.Repository;
import com.mashael.magentodemo.data.database.entities.Category;
import com.mashael.magentodemo.ui.adapters.entities.SubCategoryItem;

import java.util.List;

public class SubCategoriesRecyclerAdapter extends RecyclerView.Adapter<SubCategoriesRecyclerAdapter.ViewHolder> {

    private Context mContext;
    private List<SubCategoryItem> mSubCategoryItemList;
    private Repository mRepository;
    private LifecycleOwner mLifecycleOwner;

    public SubCategoriesRecyclerAdapter(
            LifecycleOwner lifecycleOwner,
            Repository repository,
            Context context,
            List<SubCategoryItem> subCategoryItemList) {

        mContext = context;
        mSubCategoryItemList = subCategoryItemList;
        mRepository = repository;
        mLifecycleOwner = lifecycleOwner;
    }

    @NonNull
    @Override
    public SubCategoriesRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);

        // Inflate the custom layout
        View catView = inflater.inflate(R.layout.sub_category, parent, false);

        return new ViewHolder(catView);
    }

    @Override
    public void onBindViewHolder(@NonNull final SubCategoriesRecyclerAdapter.ViewHolder holder, int position) {
        final SubCategoryItem mSubCategoryItem = mSubCategoryItemList.get(position);
        holder.mSubCategoryTextView.setText(mSubCategoryItem.getName());


        mRepository.setSubCategories(mSubCategoryItem.getId());
        mRepository.getSubCategories().observe(mLifecycleOwner, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                holder.mSubCatItemsRecycler.setAdapter(
                        new SubCategoryItemRecyclerAdapter(mContext, categories));
                holder.mSubCatItemsRecycler.setHasFixedSize(true);

            }
        });
    }

    @Override
    public int getItemCount() {
        if (mSubCategoryItemList == null)
            return 0;

        return mSubCategoryItemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mSubCategoryTextView;
        RecyclerView mSubCatItemsRecycler;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mSubCategoryTextView = itemView.findViewById(R.id.sub_category_TextView);
            mSubCatItemsRecycler = itemView.findViewById(R.id.sub_category_items_Recycler);
        }
    }
}
