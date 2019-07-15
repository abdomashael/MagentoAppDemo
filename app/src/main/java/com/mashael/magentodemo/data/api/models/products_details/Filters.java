package com.mashael.magentodemo.data.api.models.products_details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Filters {
    @Expose
    @SerializedName("condition_type")
    private String conditionType;
    @Expose
    @SerializedName("value")
    private String value;
    @Expose
    @SerializedName("field")
    private String field;

    public String getConditionType() {
        return conditionType;
    }

    public void setConditionType(String conditionType) {
        this.conditionType = conditionType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "Filters{" +
                "conditionType='" + conditionType + '\'' +
                ", value='" + value + '\'' +
                ", field='" + field + '\'' +
                '}';
    }
}
