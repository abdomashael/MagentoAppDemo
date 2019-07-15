package com.mashael.magentodemo.data.api.models.products_details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ExtensionAttributes {

    @Expose
    @SerializedName("configurable_product_options")
    private List<ConfigurableProductOptions> configurableProductOptions;
    @Expose
    @SerializedName("bundle_product_options")
    private List<BundleProductOptions> bundleProductOptions;
    @Expose
    @SerializedName("category_links")
    private List<CategoryLinks> categoryLinks;
    @Expose
    @SerializedName("website_ids")
    private List<Integer> websiteIds;

    public List<BundleProductOptions> getBundleProductOptions() {
        return bundleProductOptions;
    }

    public void setBundleProductOptions(List<BundleProductOptions> bundleProductOptions) {
        this.bundleProductOptions = bundleProductOptions;
    }

    public List<CategoryLinks> getCategoryLinks() {
        return categoryLinks;
    }

    public void setCategoryLinks(List<CategoryLinks> categoryLinks) {
        this.categoryLinks = categoryLinks;
    }

    public List<Integer> getWebsiteIds() {
        return websiteIds;
    }

    public void setWebsiteIds(List<Integer> websiteIds) {
        this.websiteIds = websiteIds;
    }

    public List<ConfigurableProductOptions> getConfigurableProductOptions() {
        return configurableProductOptions;
    }

    public void setConfigurableProductOptions(List<ConfigurableProductOptions> configurableProductOptions) {
        this.configurableProductOptions = configurableProductOptions;
    }

    @Override
    public String toString() {
        return "ExtensionAttributes{" +
                "configurableProductOptions=" + configurableProductOptions +
                ", bundleProductOptions=" + bundleProductOptions +
                ", categoryLinks=" + categoryLinks +
                ", websiteIds=" + websiteIds +
                '}';
    }
}
