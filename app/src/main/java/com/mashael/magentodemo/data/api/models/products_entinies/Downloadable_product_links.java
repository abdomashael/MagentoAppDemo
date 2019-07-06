package com.mashael.magentodemo.data.api.models.products_entinies;

public class Downloadable_product_links
{
    private String link_type;

    private String price;

    private String is_shareable;

    private String link_file;

    private String id;

    private String title;

    private String sort_order;

    private String sample_type;

    private String number_of_downloads;




    public String getLink_type ()
    {
        return link_type;
    }

    public void setLink_type (String link_type)
    {
        this.link_type = link_type;
    }

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getIs_shareable ()
    {
        return is_shareable;
    }

    public void setIs_shareable (String is_shareable)
    {
        this.is_shareable = is_shareable;
    }

    public String getLink_file ()
    {
        return link_file;
    }

    public void setLink_file (String link_file)
    {
        this.link_file = link_file;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getSort_order ()
    {
        return sort_order;
    }

    public void setSort_order (String sort_order)
    {
        this.sort_order = sort_order;
    }

    public String getSample_type ()
{
    return sample_type;
}

    public void setSample_type (String sample_type)
    {
        this.sample_type = sample_type;
    }

    public String getNumber_of_downloads ()
    {
        return number_of_downloads;
    }

    public void setNumber_of_downloads (String number_of_downloads)
    {
        this.number_of_downloads = number_of_downloads;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [link_type = "+link_type+", price = "+price+", is_shareable = "+is_shareable+", link_file = "+link_file+", id = "+id+", title = "+title+", sort_order = "+sort_order+", sample_type = "+sample_type+", number_of_downloads = "+number_of_downloads+"]";
    }
}

