package com.mashael.magentodemo.data.api.models;

import com.mashael.magentodemo.data.api.models.products_entinies.Items;
import com.mashael.magentodemo.data.api.models.products_entinies.Search_criteria;

public class Products {
    private String total_count;

    private Items[] items;

    private Search_criteria search_criteria;

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

    public Search_criteria getSearch_criteria ()
    {
        return search_criteria;
    }

    public void setSearch_criteria (Search_criteria search_criteria)
    {
        this.search_criteria = search_criteria;
    }

    @Override
    public String toString()
    {
        StringBuilder mItemsString = new StringBuilder();
        for(Items item :items){
            mItemsString.append("\n").append(item.toString());
        }
        mItemsString.append("\n");
        return "ClassPojo [total_count = "+total_count+", items = "+mItemsString+", search_criteria = "+search_criteria+"]";
    }
}

