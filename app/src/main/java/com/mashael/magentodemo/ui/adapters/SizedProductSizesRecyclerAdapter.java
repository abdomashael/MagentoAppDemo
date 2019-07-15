package com.mashael.magentodemo.ui.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mashael.magentodemo.R;
import com.mashael.magentodemo.utils.ColorSizeProvider;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SizedProductSizesRecyclerAdapter
        extends RecyclerView.Adapter<SizedProductSizesRecyclerAdapter.ViewHolder> {

    private static final String TAG = SizedProductSizesRecyclerAdapter.class.getSimpleName();
    private Context mContext;
    private List<String> mSizeIdList;
    private String mSelectedSize;
    private int mSelectedPosition;

    public SizedProductSizesRecyclerAdapter(Context context, List<String> sizeIdList) {
        mContext = context;
        mSizeIdList = sizeIdList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);

        // Inflate the custom layout
        View mView = inflater.inflate(R.layout.size_item, parent, false);

        return new ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String mSizeId = mSizeIdList.get(position);

        holder.sizeTextView.setText(ColorSizeProvider.SIZE_HASH_MAP.get(mSizeId));


        Log.d(TAG, "onBindViewHolder: " + mSelectedPosition);
        if (position == mSelectedPosition) {
            holder.mSizeFrameLayout.setSelected(true);
            holder.mSizeFrameLayout.setActivated(true);
        } else {
            holder.mSizeFrameLayout.setSelected(false);
            holder.mSizeFrameLayout.setActivated(false);
        }

        holder.sizeTextView.setOnClickListener(view -> {
            mSelectedSize = mSizeId;
            mSelectedPosition = position;
            notifyDataSetChanged();

        });

        holder.mSizeFrameLayout.setOnClickListener(view -> {
            mSelectedSize = mSizeId;
            mSelectedPosition = position;
            notifyDataSetChanged();

        });


    }

    @Override
    public int getItemCount() {
        if (mSizeIdList == null)
            return 0;

        return mSizeIdList.size();
    }

    public String getSelectedSize() {
        return mSelectedSize;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sizeTextView)
        TextView sizeTextView;

        @BindView(R.id.sizeFrameLayout)
        FrameLayout mSizeFrameLayout;


        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
