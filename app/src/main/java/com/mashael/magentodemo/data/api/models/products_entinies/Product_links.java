package com.mashael.magentodemo.data.api.models.products_entinies;

public class Product_links
{
    private String link_type;

    private String linked_product_sku;

    private String linked_product_type;

    private String position;

    private String sku;

    public String getLink_type ()
    {
        return link_type;
    }

    public void setLink_type (String link_type)
    {
        this.link_type = link_type;
    }

    public String getLinked_product_sku ()
    {
        return linked_product_sku;
    }

    public void setLinked_product_sku (String linked_product_sku)
    {
        this.linked_product_sku = linked_product_sku;
    }

    public String getLinked_product_type ()
    {
        return linked_product_type;
    }

    public void setLinked_product_type (String linked_product_type)
    {
        this.linked_product_type = linked_product_type;
    }

    public String getPosition ()
    {
        return position;
    }

    public void setPosition (String position)
    {
        this.position = position;
    }

    public String getSku ()
    {
        return sku;
    }

    public void setSku (String sku)
    {
        this.sku = sku;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [link_type = "+link_type+", linked_product_sku = "+linked_product_sku+", linked_product_type = "+linked_product_type+", position = "+position+", sku = "+sku+"]";
    }
}


