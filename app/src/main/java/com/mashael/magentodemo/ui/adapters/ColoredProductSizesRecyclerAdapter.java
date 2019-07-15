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

public class ColoredProductSizesRecyclerAdapter
        extends RecyclerView.Adapter<ColoredProductSizesRecyclerAdapter.ViewHolder> {

    private static final String TAG = ColoredProductSizesRecyclerAdapter.class.getSimpleName();
    private Context mContext;
    private List<String> mColorIdList;
    private String mSelectedColor;
    private int mSelectedPosition;

    public ColoredProductSizesRecyclerAdapter(Context context, List<String> colorIdList) {
        mContext = context;
        mColorIdList = colorIdList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);

        // Inflate the custom layout
        View mView = inflater.inflate(R.layout.color_item, parent, false);

        return new ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String mColorId = mColorIdList.get(position);

        if (!ColorSizeProvider.COLOR_HASHMAP.get(mColorId).equals("55")) {
            int resID = mContext.getResources()
                    .getIdentifier(ColorSizeProvider.COLOR_HASHMAP.get(mColorId), "color", mContext.getPackageName());

            holder.colorView.setBackgroundColor(mContext.getResources().getColor(resID));

            Log.d(TAG, "onBindViewHolder: color " +ColorSizeProvider.COLOR_HASHMAP.get(mColorId));
        }

        if (position == mSelectedPosition) {
            holder.mSizeFrameLayout.setSelected(true);
            holder.mSizeFrameLayout.setActivated(true);
        } else {
            holder.mSizeFrameLayout.setSelected(false);
            holder.mSizeFrameLayout.setActivated(false);
        }

        holder.colorView.setOnClickListener(view -> {
            mSelectedColor = mColorId;
            mSelectedPosition = position;
            notifyDataSetChanged();

        });

        holder.mSizeFrameLayout.setOnClickListener(view -> {
            mSelectedColor = mColorId;
            mSelectedPosition = position;
            notifyDataSetChanged();

        });


    }

    @Override
    public int getItemCount() {
        if (mColorIdList == null)
            return 0;

        return mColorIdList.size();
    }

    public String getSelectedColor() {
        return mSelectedColor;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.colorView)
        View colorView;

        @BindView(R.id.sizeFrameLayout)
        FrameLayout mSizeFrameLayout;


        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
