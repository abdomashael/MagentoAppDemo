package com.mashael.magentodemo.data.api.models.products_details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryProductsDetails {

    @Expose
    @SerializedName("total_count")
    private int totalCount;

    @Expose
    @SerializedName("search_criteria")
    private SearchCriteria searchCriteria;

    @Expose
    @SerializedName("items")
    private List<Items> items;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public SearchCriteria getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CategoryProductsDetails{" +
                "totalCount=" + totalCount +
                ", searchCriteria=" + searchCriteria +
                ", items=" + items +
                '}';
    }
}
