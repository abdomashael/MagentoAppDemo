package com.mashael.magentodemo.data.api.models;


import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryProducts {

    @Expose
    @SerializedName("category_id")
    private String categoryId;
    @Expose
    @SerializedName("position")
    private int position;
    @Expose
    @SerializedName("sku")
    private String sku;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @NonNull
    @Override
    public String toString() {
        return "CategoryProducts{" +
                "categoryId='" + categoryId + '\'' +
                ", position=" + position +
                ", sku='" + sku + '\'' +
                '}';
    }
}
