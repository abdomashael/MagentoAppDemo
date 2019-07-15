package com.mashael.magentodemo.ui.men;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.mashael.magentodemo.ui.activities.BodyActivity;
import com.mashael.magentodemo.R;
import com.mashael.magentodemo.data.Repository;
import com.mashael.magentodemo.data.database.entities.Category;
import com.mashael.magentodemo.ui.adapters.SubCategoriesRecyclerAdapter;
import com.mashael.magentodemo.ui.adapters.entities.SubCategoryItem;

import java.util.ArrayList;
import java.util.List;

public class MenFragment extends Fragment {

    private Repository mRepository;
    private RecyclerView subCatRecyclerView;

    private MenViewModel mMenViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mMenViewModel =
                ViewModelProviders.of(this).get(MenViewModel.class);
        View root = inflater.inflate(R.layout.fragment_men, container, false);

        subCatRecyclerView = root.findViewById(R.id.sub_category_Recycler);

        mRepository = Repository.getRepository(getActivity().getApplication());


        mMenViewModel.getWomenCategoryBasicData(mRepository,
                BodyActivity.DEFAULT_CAT_ID,
                getString(R.string.menu_men)).observe(this, new Observer<Category>() {
            @Override
            public void onChanged(Category category) {
                if (category != null) {
                    mMenViewModel
                            .getSubCategories(mRepository, category.getId())
                            .observe(MenFragment.this, getSubCatObserver());
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
                            new SubCategoriesRecyclerAdapter(MenFragment.this,
                                    mRepository,
                                    getContext(),
                                    mSubCategoryItemList));
                }
            }
        };
    }

}