package com.mashael.magentodemo.data.api.models.products_details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductLinks {
    @Expose
    @SerializedName("can_change_quantity")
    private int canChangeQuantity;
    @Expose
    @SerializedName("is_default")
    private boolean isDefault;
    @Expose
    @SerializedName("position")
    private int position;
    @Expose
    @SerializedName("qty")
    private int qty;
    @Expose
    @SerializedName("option_id")
    private int optionId;
    @Expose
    @SerializedName("sku")
    private String sku;
    @Expose
    @SerializedName("id")
    private String id;

    public int getCanChangeQuantity() {
        return canChangeQuantity;
    }

    public void setCanChangeQuantity(int canChangeQuantity) {
        this.canChangeQuantity = canChangeQuantity;
    }

    public boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProductLinks{" +
                "canChangeQuantity=" + canChangeQuantity +
                ", isDefault=" + isDefault +
                ", position=" + position +
                ", qty=" + qty +
                ", optionId=" + optionId +
                ", sku='" + sku + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
