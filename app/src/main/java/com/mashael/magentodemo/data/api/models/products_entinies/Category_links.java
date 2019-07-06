package com.mashael.magentodemo.data.api.models.products_entinies;

public class Category_links
{
    private String category_id;

    private String position;

    public String getCategory_id ()
    {
        return category_id;
    }

    public void setCategory_id (String category_id)
    {
        this.category_id = category_id;
    }

    public String getPosition ()
    {
        return position;
    }

    public void setPosition (String position)
    {
        this.position = position;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [category_id = "+category_id+", position = "+position+"]";
    }
}

