package com.mashael.magentodemo.ui.adapters.entities;

import com.mashael.magentodemo.data.database.entities.Category;

import java.util.List;

public class SubCategoryItem {
    private int id;
    private String name;

    public SubCategoryItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
