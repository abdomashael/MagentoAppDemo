package com.mashael.magentodemo.data.api.models.products_details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchCriteria {
    @Expose
    @SerializedName("filter_groups")
    private List<FilterGroups> filterGroups;

    public List<FilterGroups> getFilterGroups() {
        return filterGroups;
    }

    public void setFilterGroups(List<FilterGroups> filterGroups) {
        this.filterGroups = filterGroups;
    }

    @Override
    public String toString() {
        return "SearchCriteria{" +
                "filterGroups=" + filterGroups +
                '}';
    }
}
