package com.mashael.magentodemo.data.api.models.products_entinies;
public class Custom_attributes
{
    private Object value;

    private String attribute_code;

    public Object getValue ()
    {
        //Check value is String not Array of Strings
        if(value instanceof String)
            return (String) value;

        return (String[])value;
    }

    public void setValue (Object value)
    {
        this.value = value;
    }

    public String getAttribute_code ()
    {
        return attribute_code;
    }

    public void setAttribute_code (String attribute_code)
    {
        this.attribute_code = attribute_code;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [value = "+value+", attribute_code = "+attribute_code+"]";
    }
}
