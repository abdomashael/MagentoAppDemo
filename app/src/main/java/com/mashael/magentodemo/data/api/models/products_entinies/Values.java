package com.mashael.magentodemo.data.api.models.products_entinies;
public class Values
{
    private String value_index;

    public String getValue_index ()
    {
        return value_index;
    }

    public void setValue_index (String value_index)
    {
        this.value_index = value_index;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [value_index = "+value_index+"]";
    }
}
