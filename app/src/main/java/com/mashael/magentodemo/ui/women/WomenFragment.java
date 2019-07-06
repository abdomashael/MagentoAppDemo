package com.mashael.magentodemo.ui.women;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.mashael.magentodemo.BodyActivity;
import com.mashael.magentodemo.R;
import com.mashael.magentodemo.data.Repository;
import com.mashael.magentodemo.data.database.entities.Category;
import com.mashael.magentodemo.ui.adapters.SubCategoriesRecyclerAdapter;
import com.mashael.magentodemo.ui.adapters.entities.SubCategoryItem;

import java.util.ArrayList;
import java.util.List;

public class WomenFragment extends Fragment {

    private WomenViewModel mWomenViewModel;
    private Repository mRepository;
    private RecyclerView subCatRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_women, container, false);

        subCatRecyclerView = root.findViewById(R.id.sub_category_Recycler);

        mRepository = Repository.getRepository(getActivity().getApplication());

        mWomenViewModel =
                ViewModelProviders.of(this).get(WomenViewModel.class);


        mWomenViewModel.getWomenCategoryBasicData(mRepository,
                BodyActivity.DEFAULT_CAT_ID,
                getString(R.string.menu_women)).observe(this, new Observer<Category>() {
            @Override
            public void onChanged(Category category) {
                if (category != null) {
                    mWomenViewModel
                            .getSubCategories(mRepository, category.getId())
                            .observe(WomenFragment.this, getSubCatObserver());
                }
            }
        });
        return root;
    }

    private Observer<List<Category>> getSubCatObserver() {
        return new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                if (categories != null) {
                    List<SubCategoryItem> mSubCategoryItemList = new ArrayList<>();
                    for (Category mCategory : categories) {
                        SubCategoryItem mSubCategoryItem = new SubCategoryItem(
                                mCategory.getId(),
                                mCategory.getName()
                        );
                        mSubCategoryItemList.add(mSubCategoryItem);
                    }
                    subCatRecyclerView.setAdapter(
                            new SubCategoriesRecyclerAdapter(WomenFragment.this,
                                    mRepository,
                                    getContext(),
                                    mSubCategoryItemList));
                }
            }
        };
    }

    private Observer<Category> getObserver() {
        return new Observer<Category>() {
            @Override
            public void onChanged(Category category) {
                if (category != null) {
                    if (category.getIsHasChild() == 1) {

                    } else if (category.getIsHasChild() == 0) {

                    }
                }
            }
        };
    }
}