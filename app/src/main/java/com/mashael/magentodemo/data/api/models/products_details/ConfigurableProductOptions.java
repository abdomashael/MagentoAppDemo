package com.mashael.magentodemo.data.api.models.products_details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ConfigurableProductOptions {
    @Expose
    @SerializedName("product_id")
    private int productId;
    @Expose
    @SerializedName("values")
    private List<Values> values;
    @Expose
    @SerializedName("position")
    private int position;
    @Expose
    @SerializedName("label")
    private String label;
    @Expose
    @SerializedName("attribute_id")
    private String attributeId;
    @Expose
    @SerializedName("id")
    private int id;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public List<Values> getValues() {
        return values;
    }

    public void setValues(List<Values> values) {
        this.values = values;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(String attributeId) {
        this.attributeId = attributeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
