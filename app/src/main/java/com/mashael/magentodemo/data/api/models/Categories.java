package com.mashael.magentodemo.data.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mashael.magentodemo.data.database.entities.Category;

import java.util.ArrayList;
import java.util.List;

public class Categories {


    private transient static List<Category> mCategories;

    @Expose
    @SerializedName("children_data")
    private List<Children_data> children_data;
    @Expose
    @SerializedName("product_count")
    private int product_count;
    @Expose
    @SerializedName("level")
    private int level;
    @Expose
    @SerializedName("position")
    private int position;
    @Expose
    @SerializedName("is_active")
    private boolean is_active;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("parent_id")
    private int parent_id;
    @Expose
    @SerializedName("id")
    private int id;

    public List<Children_data> getChildren_data() {
        return children_data;
    }

    public void setChildren_data(List<Children_data> children_data) {
        this.children_data = children_data;
    }

    public int getProduct_count() {
        return product_count;
    }

    public void setProduct_count(int product_count) {
        this.product_count = product_count;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Category> getAllCategories() {
        mCategories = new ArrayList<>();
        if (children_data != null) {
            for (Children_data mChildren_data : children_data) {
                mChildren_data.getCategory();
            }
        }
        return mCategories;
    }

    @Override
    public String toString() {

        StringBuilder mChildsString = new StringBuilder();
        if (children_data != null) {
            for (Children_data mData : children_data) {
                mChildsString.append("\n").append(mData.toString());
            }
            mChildsString.append("\n");
        }
        return "Categories{" +
                "children_data=" + mChildsString +
                ", product_count=" + product_count +
                ", level=" + level +
                ", position=" + position +
                ", is_active=" + is_active +
                ", name='" + name + '\'' +
                ", parent_id=" + parent_id +
                ", id=" + id +
                '}';
    }

    public static class Children_data {
        @Expose
        @SerializedName("children_data")
        private List<Children_data> children_data;
        @Expose
        @SerializedName("product_count")
        private int product_count;
        @Expose
        @SerializedName("level")
        private int level;
        @Expose
        @SerializedName("position")
        private int position;
        @Expose
        @SerializedName("is_active")
        private boolean is_active;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("parent_id")
        private int parent_id;
        @Expose
        @SerializedName("id")
        private int id;

        public List<Children_data> getChildren_data() {
            return children_data;
        }

        public void setChildren_data(List<Children_data> children_data) {
            this.children_data = children_data;
        }

        public int getProduct_count() {
            return product_count;
        }

        public void setProduct_count(int product_count) {
            this.product_count = product_count;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public boolean getIs_active() {
            return is_active;
        }

        public void setIs_active(boolean is_active) {
            this.is_active = is_active;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getParent_id() {
            return parent_id;
        }

        public void setParent_id(int parent_id) {
            this.parent_id = parent_id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void getCategory() {
            int isActive, isHasCild;

            if (is_active)
                isActive = 1;
            else
                isActive = 0;

            if (children_data != null)
                isHasCild = 1;
            else
                isHasCild = 0;

            Category mCategory =
                    new Category(id, parent_id, name, isActive, position, level, product_count,isHasCild);

            mCategories.add(mCategory);
            //recursive enter data to database
            if (children_data != null) {
                for (Children_data mChildren_data : children_data) {
                    mChildren_data.getCategory();
                }
            }

        }

        @Override
        public String toString() {

            StringBuilder mChildsString = new StringBuilder();
            if (children_data != null) {
                for (Children_data mData : children_data) {
                    mChildsString.append("\n").append(mData.toString());
                }
                mChildsString.append("\n");
            }
            return "Categories{" +
                    "children_data=" + mChildsString +
                    ", product_count=" + product_count +
                    ", level=" + level +
                    ", position=" + position +
                    ", is_active=" + is_active +
                    ", name='" + name + '\'' +
                    ", parent_id=" + parent_id +
                    ", id=" + id +
                    '}';
        }

    }
}


