package com.mashael.magentodemo.data.api.models.products_details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BundleProductOptions {
    @Expose
    @SerializedName("product_links")
    private List<ProductLinks> productLinks;
    @Expose
    @SerializedName("sku")
    private String sku;
    @Expose
    @SerializedName("position")
    private int position;
    @Expose
    @SerializedName("type")
    private String type;
    @Expose
    @SerializedName("required")
    private boolean required;
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("option_id")
    private int optionId;

    public List<ProductLinks> getProductLinks() {
        return productLinks;
    }

    public void setProductLinks(List<ProductLinks> productLinks) {
        this.productLinks = productLinks;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    @Override
    public String toString() {
        return "BundleProductOptions{" +
                "productLinks=" + productLinks +
                ", sku='" + sku + '\'' +
                ", position=" + position +
                ", type='" + type + '\'' +
                ", required=" + required +
                ", title='" + title + '\'' +
                ", optionId=" + optionId +
                '}';
    }
}
