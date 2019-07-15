package com.mashael.magentodemo.data.api.models.products_details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryLinks {
    @Expose
    @SerializedName("category_id")
    private String categoryId;
    @Expose
    @SerializedName("position")
    private int position;

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

    @Override
    public String toString() {
        return "CategoryLinks{" +
                "categoryId='" + categoryId + '\'' +
                ", position=" + position +
                '}';
    }
}
