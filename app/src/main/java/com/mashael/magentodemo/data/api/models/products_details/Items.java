package com.mashael.magentodemo.data.api.models.products_details;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mashael.magentodemo.data.database.type_converters.CustomAttributesTypeConverter;
import com.mashael.magentodemo.data.database.type_converters.ExtensionAttributesTypeConverter;
import com.mashael.magentodemo.data.database.type_converters.MediaGalleryTypeConverter;
import com.mashael.magentodemo.data.database.type_converters.ObjectConverter;
import com.mashael.magentodemo.data.database.type_converters.StringTypeConverter;

import java.util.List;

@Entity(tableName = "items_table")
public class Items {

    @Expose
    @SerializedName("custom_attributes")
    @ColumnInfo(name = "custom_attributes")
    @TypeConverters(CustomAttributesTypeConverter.class)
    private List<CustomAttributes> customAttributes;

    @Expose
    @SerializedName("tier_prices")
    @ColumnInfo(name = "tier_prices")
    @TypeConverters(StringTypeConverter.class)
    private List<String> tierPrices;

    @Expose
    @SerializedName("media_gallery_entries")
    @ColumnInfo(name = "media_gallery_entries")
    @TypeConverters(MediaGalleryTypeConverter.class)
    private List<MediaGalleryEntries> mediaGalleryEntries;

    @Expose
    @SerializedName("options")
    @ColumnInfo(name = "options")
    @TypeConverters(StringTypeConverter.class)
    private List<String> options;

    //ToDo check product links is string or array of string
    @Expose
    @SerializedName("product_links")
    @ColumnInfo(name = "product_links")
    @TypeConverters(ObjectConverter.class)
    private Object productLinks;

    @Expose
    @SerializedName("extension_attributes")
    @ColumnInfo(name = "extension_attributes")
    @TypeConverters(ExtensionAttributesTypeConverter.class)
    private ExtensionAttributes extensionAttributes;

    @Expose
    @SerializedName("weight")
    @ColumnInfo(name = "weight")
    private int weight;

    @Expose
    @SerializedName("updated_at")
    @ColumnInfo(name = "updated_at")
    private String updatedAt;

    @Expose
    @SerializedName("created_at")
    @ColumnInfo(name = "created_at")
    private String createdAt;

    @Expose
    @SerializedName("type_id")
    @ColumnInfo(name = "type_id")
    private String typeId;

    @Expose
    @SerializedName("visibility")
    @ColumnInfo(name = "visibility")
    private int visibility;

    @Expose
    @SerializedName("status")
    @ColumnInfo(name = "status")
    private int status;

    @Expose
    @SerializedName("price")
    @ColumnInfo(name = "price")
    private int price;

    @Expose
    @SerializedName("attribute_set_id")
    @ColumnInfo(name = "attribute_set_id")
    private int attributeSetId;

    @Expose
    @SerializedName("name")
    @ColumnInfo(name = "name")
    private String name;

    @Expose
    @SerializedName("sku")
    @ColumnInfo(name = "sku")
    private String sku;

    @Expose
    @SerializedName("id")
    @ColumnInfo(name = "id")
    @PrimaryKey
    private int id;

    public List<CustomAttributes> getCustomAttributes() {
        return customAttributes;
    }

    public void setCustomAttributes(List<CustomAttributes> customAttributes) {
        this.customAttributes = customAttributes;
    }

    public List<String> getTierPrices() {
        return tierPrices;
    }

    public void setTierPrices(List<String> tierPrices) {
        this.tierPrices = tierPrices;
    }

    public List<MediaGalleryEntries> getMediaGalleryEntries() {
        return mediaGalleryEntries;
    }

    public void setMediaGalleryEntries(List<MediaGalleryEntries> mediaGalleryEntries) {
        this.mediaGalleryEntries = mediaGalleryEntries;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public Object getProductLinks() {
        if (productLinks instanceof String)
            return (String) productLinks;

        return (List<String>)productLinks;
    }

    public void setProductLinks(Object productLinks) {

        this.productLinks = productLinks;
    }

    public ExtensionAttributes getExtensionAttributes() {
        return extensionAttributes;
    }

    public void setExtensionAttributes(ExtensionAttributes extensionAttributes) {
        this.extensionAttributes = extensionAttributes;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAttributeSetId() {
        return attributeSetId;
    }

    public void setAttributeSetId(int attributeSetId) {
        this.attributeSetId = attributeSetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Items{" +
                "customAttributes=" + customAttributes +
                ", tierPrices=" + tierPrices +
                ", mediaGalleryEntries=" + mediaGalleryEntries +
                ", options=" + options +
                ", productLinks=" + productLinks +
                ", extensionAttributes=" + extensionAttributes +
                ", weight=" + weight +
                ", updatedAt='" + updatedAt + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", typeId='" + typeId + '\'' +
                ", visibility=" + visibility +
                ", status=" + status +
                ", price=" + price +
                ", attributeSetId=" + attributeSetId +
                ", name='" + name + '\'' +
                ", sku='" + sku + '\'' +
                ", id=" + id +
                '}';
    }
}
