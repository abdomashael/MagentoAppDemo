package com.mashael.magentodemo.data.api.models.products_entinies;

import java.util.Arrays;

public class Extension_attributes
{

    private Configurable_product_options[] configurable_product_options;

    private String[] configurable_product_links;

    private String[] website_ids;

    private Category_links[] category_links;

    private Downloadable_product_links[] downloadable_product_links;

    private Downloadable_product_samples[] downloadable_product_samples;

    public Downloadable_product_links[] getDownloadable_product_links ()
    {
        return downloadable_product_links;
    }

    public void setDownloadable_product_links (Downloadable_product_links[] downloadable_product_links)
    {
        this.downloadable_product_links = downloadable_product_links;
    }



    public Downloadable_product_samples[] getDownloadable_product_samples ()
    {
        return downloadable_product_samples;
    }

    public void setDownloadable_product_samples (Downloadable_product_samples[] downloadable_product_samples)
    {
        this.downloadable_product_samples = downloadable_product_samples;
    }



    public Configurable_product_options[] getConfigurable_product_options ()
    {
        return configurable_product_options;
    }

    public void setConfigurable_product_options (Configurable_product_options[] configurable_product_options)
    {
        this.configurable_product_options = configurable_product_options;
    }

    public String[] getConfigurable_product_links ()
    {
        return configurable_product_links;
    }

    public void setConfigurable_product_links (String[] configurable_product_links)
    {
        this.configurable_product_links = configurable_product_links;
    }

    public String[] getWebsite_ids ()
    {
        return website_ids;
    }

    public void setWebsite_ids (String[] website_ids)
    {
        this.website_ids = website_ids;
    }

    public Category_links[] getCategory_links ()
    {
        return category_links;
    }

    public void setCategory_links (Category_links[] category_links)
    {
        this.category_links = category_links;
    }

    @Override
    public String toString() {
        return "Extension_attributes{" +
                "configurable_product_options=" + Arrays.toString(configurable_product_options) +
                ", configurable_product_links=" + Arrays.toString(configurable_product_links) +
                ", website_ids=" + Arrays.toString(website_ids) +
                ", category_links=" + Arrays.toString(category_links) +
                ", downloadable_product_links=" + Arrays.toString(downloadable_product_links) +
                ", downloadable_product_samples=" + Arrays.toString(downloadable_product_samples) +
                '}';
    }
}


