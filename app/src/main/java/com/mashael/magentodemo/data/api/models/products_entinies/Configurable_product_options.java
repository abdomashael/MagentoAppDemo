package com.mashael.magentodemo.data.api.models.products_entinies;

public class Configurable_product_options
{
    private String attribute_id;

    private Values[] values;

    private String product_id;

    private String id;

    private String label;

    private String position;

    public String getAttribute_id ()
    {
        return attribute_id;
    }

    public void setAttribute_id (String attribute_id)
    {
        this.attribute_id = attribute_id;
    }

    public Values[] getValues ()
    {
        return values;
    }

    public void setValues (Values[] values)
    {
        this.values = values;
    }

    public String getProduct_id ()
    {
        return product_id;
    }

    public void setProduct_id (String product_id)
    {
        this.product_id = product_id;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getLabel ()
    {
        return label;
    }

    public void setLabel (String label)
    {
        this.label = label;
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
        return "ClassPojo [attribute_id = "+attribute_id+", values = "+values+", product_id = "+product_id+", id = "+id+", label = "+label+", position = "+position+"]";
    }
}

