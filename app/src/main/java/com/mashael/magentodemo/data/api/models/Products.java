package com.mashael.magentodemo.data.api.models;


import com.mashael.magentodemo.data.api.models.products_details.Items;
import com.mashael.magentodemo.data.api.models.products_details.SearchCriteria;

import java.util.Arrays;

public class Products {
    private String total_count;

    private Items[] items;

    private SearchCriteria search_criteria;

    public String getTotal_count ()
    {
        return total_count;
    }

    public void setTotal_count (String total_count)
    {
        this.total_count = total_count;
    }

    public Items[] getItems ()
    {
        return items;
    }

    public void setItems (Items[] items)
    {
        this.items = items;
    }

    public SearchCriteria getSearch_criteria ()
    {
        return search_criteria;
    }

    public void setSearch_criteria (SearchCriteria search_criteria)
    {
        this.search_criteria = search_criteria;
    }

    @Override
    public String toString() {
        return "Products{" +
                "total_count='" + total_count + '\'' +
                ", items=" + Arrays.toString(items) +
                ", search_criteria=" + search_criteria +
                '}'+"\n";
    }
}

