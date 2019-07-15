package com.mashael.magentodemo.data.api.models.products_details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomAttributes {
    @Expose
    @SerializedName("value")
    private Object value;
    @Expose
    @SerializedName("attribute_code")
    private String attributeCode;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getAttributeCode() {
        return attributeCode;
    }

    public void setAttributeCode(String attributeCode) {
        this.attributeCode = attributeCode;
    }

    @Override
    public String toString() {
        return "CustomAttributes{" +
                "value=" + value +
                ", attributeCode='" + attributeCode + '\'' +
                '}';
    }
}
