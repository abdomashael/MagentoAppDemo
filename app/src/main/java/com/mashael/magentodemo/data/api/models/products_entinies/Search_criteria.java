package com.mashael.magentodemo.data.api.models.products_entinies;

public class Search_criteria
{
    private String[] filter_groups;

    public String[] getFilter_groups ()
    {
        return filter_groups;
    }

    public void setFilter_groups (String[] filter_groups)
    {
        this.filter_groups = filter_groups;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [filter_groups = "+filter_groups+"]";
    }
}
