package com.mashael.magentodemo.data.api.models.products_entinies;

public class Bundle_product_options
{
    private String option_id;

    private String position;

    private String title;

    private String type;

    private String sku;

    private Product_links[] product_links;

    private String required;

    public String getOption_id ()
    {
        return option_id;
    }

    public void setOption_id (String option_id)
    {
        this.option_id = option_id;
    }

    public String getPosition ()
    {
        return position;
    }

    public void setPosition (String position)
    {
        this.position = position;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getSku ()
    {
        return sku;
    }

    public void setSku (String sku)
    {
        this.sku = sku;
    }

    public Product_links[] getProduct_links ()
    {
        return product_links;
    }

    public void setProduct_links (Product_links[] product_links)
    {
        this.product_links = product_links;
    }

    public String getRequired ()
    {
        return required;
    }

    public void setRequired (String required)
    {
        this.required = required;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [option_id = "+option_id+", position = "+position+", title = "+title+", type = "+type+", sku = "+sku+", product_links = "+product_links+", required = "+required+"]";
    }
}