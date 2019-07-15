package com.mashael.magentodemo.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mashael.magentodemo.R;
import com.mashael.magentodemo.data.api.models.products_details.ConfigurableProductOptions;
import com.mashael.magentodemo.data.api.models.products_details.Items;
import com.mashael.magentodemo.data.api.models.products_details.Values;
import com.mashael.magentodemo.ui.activities.ProductDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsRecyclerAdapter extends RecyclerView.Adapter<ProductsRecyclerAdapter.ViewHolder> {

    private static final String IMAGE_BASE_URL = "http://134.209.89.178/pub/media/catalog/product";
    private static final String TYPE_ID_CONFIGURABLE = "configurable";
    private static final String TYPE_ID_SIMPLE = "simple";
    private static final String SIZE_ATTR_ID = "145",COLOR_ATTR_ID = "93";
    private static final String TAG = ProductsRecyclerAdapter.class.getSimpleName();
    public static final String PRODUCT_ID = "product id";

    private Context mContext;
    private List<Items> mItemsList;

    public ProductsRecyclerAdapter(Context context, List<Items> itemsList) {
        mContext = context;
        mItemsList = itemsList;
        notifyDataSetChanged();
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
        Items mItem = mItemsList.get(position);

        Glide.with(mContext)
                .load(IMAGE_BASE_URL
                        + mItem.getMediaGalleryEntries().get(0).getFile())
                .placeholder(R.drawable.app_logo)
                .into(holder.productImageView);

        holder.productTextView.setText(mItem.getName());

        if (mItem.getTypeId().equals(TYPE_ID_CONFIGURABLE)) {
            List<String> mSizeIdsList = getSizeIdsList(mItem);
            List<String> mColorIdsList = getColorIdsList(mItem);

            Log.d(TAG, "onBindViewHolder: "+mColorIdsList);

            holder.withoutSizeLayout.setVisibility(View.GONE);
            holder.sizedPriceTextView.setText(String.valueOf(mItem.getPrice()));
            holder.sizeRecyclerView.setAdapter(
                    new SizedProductSizesRecyclerAdapter(mContext,mSizeIdsList));
            holder.colorRecyclerView.setAdapter(
                    new ColoredProductSizesRecyclerAdapter(mContext,mColorIdsList));

        } else if (mItem.getTypeId().equals(TYPE_ID_SIMPLE)) {
            holder.withSizeLayout.setVisibility(View.GONE);
            holder.priceTextView.setText(String.valueOf(mItem.getPrice()));
        }

        holder.productLinearLayout.setOnClickListener(view -> {
            Intent mIntent = new Intent(mContext, ProductDetailsActivity.class);
            mIntent.putExtra(PRODUCT_ID,mItem.getId());
            mContext.startActivity(mIntent);
        });

    }

    private List<String> getSizeIdsList(Items item) {
        List<String> mSizeIdsList = new ArrayList<>();
        List<ConfigurableProductOptions> mConfigurableProductOptionsList =
                item.getExtensionAttributes().getConfigurableProductOptions();

        for (ConfigurableProductOptions mConfigurableProductOptions
                : mConfigurableProductOptionsList) {
            if (mConfigurableProductOptions.getAttributeId().equals(SIZE_ATTR_ID)) {
                for (Values mValue : mConfigurableProductOptions.getValues()) {
                    mSizeIdsList.add(String.valueOf(mValue.getValueIndex()));
                }
                break;
            }
        }
        return mSizeIdsList;
    }

    private List<String> getColorIdsList(Items item) {
        List<String> mColorIdsList = new ArrayList<>();
        List<ConfigurableProductOptions> mConfigurableProductOptionsList =
                item.getExtensionAttributes().getConfigurableProductOptions();

        for (ConfigurableProductOptions mConfigurableProductOptions
                : mConfigurableProductOptionsList) {
            if (mConfigurableProductOptions.getAttributeId().equals(COLOR_ATTR_ID)) {
                for (Values mValue : mConfigurableProductOptions.getValues()) {
                    mColorIdsList.add(String.valueOf(mValue.getValueIndex()));
                }
                break;
            }
        }
        return mColorIdsList;
    }

    @Override
    public int getItemCount() {

        if (mItemsList == null)
            return 0;

        return mItemsList.size();
    }


    static
    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.product_imageView)
        ImageView productImageView;
        @BindView(R.id.product_textView)
        TextView productTextView;
        /*@BindView(R.id.ratingBar)
        RatingBar ratingBar;
        @BindView(R.id.reviewsNoTextView)
        TextView reviewsNoTextView;
        */
        @BindView(R.id.sized_price_textView)
        TextView sizedPriceTextView;
        @BindView(R.id.price_textView)
        TextView priceTextView;
        @BindView(R.id.sizeRecyclerView)
        RecyclerView sizeRecyclerView;
        @BindView(R.id.colorRecyclerView)
        RecyclerView colorRecyclerView;
        @BindView(R.id.addBtn)
        Button addBtn;
        @BindView(R.id.wishListBtn)
        ImageButton wishListBtn;
        @BindView(R.id.compareBtn)
        ImageButton compareBtn;
        @BindView(R.id.product_linearLayout)
        LinearLayout productLinearLayout;

        @BindView(R.id.without_size_layout)
        android.widget.LinearLayout withoutSizeLayout;
        @BindView(R.id.with_size_layout)
        android.widget.LinearLayout withSizeLayout;


        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}


