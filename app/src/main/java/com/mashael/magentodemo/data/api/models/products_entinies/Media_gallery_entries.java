package com.mashael.magentodemo.data.api.models.products_entinies;
public class Media_gallery_entries
{
    private String[] types;

    private String file;

    private String media_type;

    private String disabled;

    private String id;

    private String label;

    private String position;

    public String[] getTypes ()
    {
        return types;
    }

    public void setTypes (String[] types)
    {
        this.types = types;
    }

    public String getFile ()
    {
        return file;
    }

    public void setFile (String file)
    {
        this.file = file;
    }

    public String getMedia_type ()
    {
        return media_type;
    }

    public void setMedia_type (String media_type)
    {
        this.media_type = media_type;
    }

    public String getDisabled ()
    {
        return disabled;
    }

    public void setDisabled (String disabled)
    {
        this.disabled = disabled;
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
        return "ClassPojo [types = "+types+", file = "+file+", media_type = "+media_type+", disabled = "+disabled+", id = "+id+", label = "+label+", position = "+position+"]";
    }
}

