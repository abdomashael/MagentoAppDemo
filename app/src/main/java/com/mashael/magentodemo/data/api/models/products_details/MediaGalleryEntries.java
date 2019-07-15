package com.mashael.magentodemo.data.api.models.products_details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MediaGalleryEntries {
    @Expose
    @SerializedName("file")
    private String file;
    @Expose
    @SerializedName("types")
    private List<String> types;
    @Expose
    @SerializedName("disabled")
    private boolean disabled;
    @Expose
    @SerializedName("position")
    private int position;
    @Expose
    @SerializedName("label")
    private String label;
    @Expose
    @SerializedName("media_type")
    private String mediaType;
    @Expose
    @SerializedName("id")
    private int id;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MediaGalleryEntries{" +
                "file='" + file + '\'' +
                ", types=" + types +
                ", disabled=" + disabled +
                ", position=" + position +
                ", label='" + label + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", id=" + id +
                '}';
    }
}
