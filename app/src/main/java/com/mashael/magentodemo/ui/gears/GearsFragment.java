package com.mashael.magentodemo.ui.gears;

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
import com.mashael.magentodemo.ui.adapters.SubCategoryItemRecyclerAdapter;

import java.util.List;

public class GearsFragment extends Fragment {

    private GearsViewModel mGearsViewModel;

    private Repository mRepository;
    private RecyclerView subCatRecyclerView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mGearsViewModel =
                ViewModelProviders.of(this).get(GearsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gear, container, false);
        subCatRecyclerView = root.findViewById(R.id.sub_category_items_Recycler);

        mRepository = Repository.getRepository(getActivity().getApplication());


        mGearsViewModel.getWomenCategoryBasicData(mRepository,
                BodyActivity.DEFAULT_CAT_ID,
                getString(R.string.menu_gear)).observe(this, new Observer<Category>() {
            @Override
            public void onChanged(Category category) {
                if (category != null) {
                    mGearsViewModel
                            .getSubCategories(mRepository, category.getId())
                            .observe(GearsFragment.this, getSubCatObserver());
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
                    subCatRecyclerView.setAdapter(
                            new SubCategoryItemRecyclerAdapter(getContext(),
                                    categories));
                }
            }
        };
    }

}