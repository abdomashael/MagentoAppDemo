package com.mashael.magentodemo.ui.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.mashael.magentodemo.R;
import com.mashael.magentodemo.ui.adapters.SliderAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductDetailsActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout indicator;

    List<String> mImageUrls;

    @BindView(R.id.toolbar)
    CollapsingToolbarLayout toolbar;
    @BindView(R.id.titleTextView)
    TextView titleTextView;
    @BindView(R.id.as_low_textView)
    TextView asLowTextView;
    @BindView(R.id.sized_price_textView)
    TextView sizedPriceTextView;
    @BindView(R.id.stock_textView)
    TextView stockTextView;
    @BindView(R.id.sku_no_textView)
    TextView skuNoTextView;
    @BindView(R.id.sizeTextView)
    TextView sizeTextView;
    @BindView(R.id.sizeRecyclerView)
    RecyclerView sizeRecyclerView;
    @BindView(R.id.colorTextView)
    TextView colorTextView;
    @BindView(R.id.colorRecyclerView)
    RecyclerView colorRecyclerView;
    @BindView(R.id.addBtn)
    Button addBtn;
    @BindView(R.id.add_wishList_btn)
    Button addWishListBtn;
    @BindView(R.id.email_btn)
    Button emailBtn;
    @BindView(R.id.details_btn)
    Button detailsBtn;
    @BindView(R.id.details_textView)
    TextView detailsTextView;
    @BindView(R.id.more_info_btn)
    Button moreInfoBtn;
    @BindView(R.id.more_info_textView)
    TextView moreInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        ButterKnife.bind(this);

        viewPager = findViewById(R.id.viewPager);
        indicator = findViewById(R.id.indicator);


        mImageUrls = new ArrayList<>();

        mImageUrls.add("http://134.209.89.178/pub/media/catalog/product/" +
                "m/h/mh06-purple_main_1.jpg");

        mImageUrls.add("http://134.209.89.178/pub/media/catalog/product/" +
                "m/h/mh06-blue_alt1_1.jpg");

        mImageUrls.add("http://134.209.89.178/pub/media/catalog/product/" +
                "m/h/mh06-blue_back_1.jpg");

        viewPager.setAdapter(new SliderAdapter(ProductDetailsActivity.this, mImageUrls));
        indicator.setupWithViewPager(viewPager, true);
/*

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 6000);
*/

    }

    @OnClick(R.id.addBtn)
    public void onAddBtnClicked() {
    }

    @OnClick(R.id.add_wishList_btn)
    public void onAddWishListBtnClicked() {
    }

    @OnClick(R.id.email_btn)
    public void onEmailBtnClicked() {
    }

    @OnClick(R.id.details_btn)
    public void onDetailsBtnClicked() {
        if (detailsTextView.getVisibility()!= View.VISIBLE) {
            detailsTextView.setVisibility(View.VISIBLE);
            detailsBtn.setCompoundDrawablesWithIntrinsicBounds(
                    null,
                    null,
                    getResources().getDrawable(R.drawable.baseline_keyboard_arrow_up_24),
                    null);
        }

        if (moreInfoTextView.getVisibility()!= View.GONE) {
            moreInfoTextView.setVisibility(View.GONE);
            moreInfoBtn.setCompoundDrawablesWithIntrinsicBounds(
                    null,
                    null,
                    getResources().getDrawable(R.drawable.baseline_keyboard_arrow_down_24),
                    null);
        }
    }

    @OnClick(R.id.more_info_btn)
    public void onMoreInfoBtnClicked() {
        if (moreInfoTextView.getVisibility()!= View.VISIBLE) {
            moreInfoTextView.setVisibility(View.VISIBLE);
            moreInfoBtn.setCompoundDrawablesWithIntrinsicBounds(
                    null,
                    null,
                    getResources().getDrawable(R.drawable.baseline_keyboard_arrow_up_24),
                    null);
        }


        if (detailsTextView.getVisibility()!= View.GONE) {
            detailsTextView.setVisibility(View.GONE);
            detailsBtn.setCompoundDrawablesWithIntrinsicBounds(
                    null,
                    null,
                    getResources().getDrawable(R.drawable.baseline_keyboard_arrow_down_24),
                    null);
        }

    }

    /*private class SliderTimer extends TimerTask {

        @Override
        public void run() {
            ProductDetailsActivity.this.runOnUiThread(() -> {
                if (viewPager.getCurrentItem() < mImageUrls.size() - 1) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                } else {
                    viewPager.setCurrentItem(0);
                }
            });
        }
    }
*/

}
