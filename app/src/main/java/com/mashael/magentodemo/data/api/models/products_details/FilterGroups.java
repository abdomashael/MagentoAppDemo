package com.mashael.magentodemo.data.api.models.products_details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FilterGroups {

    @Expose
    @SerializedName("filters")
    List<Filters> filters;

    public List<Filters> getFilters() {
        return filters;
    }

    public void setFilters(List<Filters> filters) {
        this.filters = filters;
    }

    @Override
    public String toString() {
        return "FilterGroups{" +
                "filters=" + filters +
                '}';
    }
}
