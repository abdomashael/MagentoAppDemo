package com.mashael.magentodemo.data.api.models.products_entinies;

public class Items
{
    private String visibility;

    private String type_id;

    private String created_at;

    private Extension_attributes extension_attributes;

    private String[] tier_prices;

    private Custom_attributes[] custom_attributes;

    private String attribute_set_id;

    private String updated_at;

    private String price;

    private Media_gallery_entries[] media_gallery_entries;

    private String name;

    private String[] options;

    private String id;

    private String sku;

    private Product_links[] product_links;

    private String status;





    public String getVisibility ()
    {
        return visibility;
    }

    public void setVisibility (String visibility)
    {
        this.visibility = visibility;
    }

    public String getType_id ()
    {
        return type_id;
    }

    public void setType_id (String type_id)
    {
        this.type_id = type_id;
    }

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public Extension_attributes getExtension_attributes ()
    {
        return extension_attributes;
    }

    public void setExtension_attributes (Extension_attributes extension_attributes)
    {
        this.extension_attributes = extension_attributes;
    }

    public String[] getTier_prices ()
    {
        return tier_prices;
    }

    public void setTier_prices (String[] tier_prices)
    {
        this.tier_prices = tier_prices;
    }

    public Custom_attributes[] getCustom_attributes ()
    {
        return custom_attributes;
    }

    public void setCustom_attributes (Custom_attributes[] custom_attributes)
    {
        this.custom_attributes = custom_attributes;
    }

    public String getAttribute_set_id ()
    {
        return attribute_set_id;
    }

    public void setAttribute_set_id (String attribute_set_id)
    {
        this.attribute_set_id = attribute_set_id;
    }

    public String getUpdated_at ()
    {
        return updated_at;
    }

    public void setUpdated_at (String updated_at)
    {
        this.updated_at = updated_at;
    }

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public Media_gallery_entries[] getMedia_gallery_entries ()
    {
        return media_gallery_entries;
    }

    public void setMedia_gallery_entries (Media_gallery_entries[] media_gallery_entries)
    {
        this.media_gallery_entries = media_gallery_entries;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String[] getOptions ()
    {
        return options;
    }

    public void setOptions (String[] options)
    {
        this.options = options;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
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

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [visibility = "+visibility+", type_id = "+type_id+", created_at = "+created_at+", extension_attributes = "+extension_attributes+", tier_prices = "+tier_prices+", custom_attributes = "+custom_attributes+", attribute_set_id = "+attribute_set_id+", updated_at = "+updated_at+", price = "+price+", media_gallery_entries = "+media_gallery_entries+", name = "+name+", options = "+options+", id = "+id+", sku = "+sku+", product_links = "+product_links+", status = "+status+"]";
    }
}

