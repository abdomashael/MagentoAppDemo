package com.mashael.magentodemo.data.database.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "category_table")
public class Category {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private int mId;

    @ColumnInfo(name = "parent_id")
    private int mParentId;

    @ColumnInfo(name = "name")
    private String mName;

    @ColumnInfo(name = "is_active")
    private int mIsActive; //true = 1 , false = 0

    @ColumnInfo(name = "position")
    private int mPosition;

    @ColumnInfo(name = "level")
    private int mLevel;

    @ColumnInfo(name = "product_count")
    private int mProductCount;

    @ColumnInfo(name = "is_has_child")
    private int mIsHasChild;

    public Category(int id, int parentId, String name, int isActive, int position, int level, int productCount, int isHasChild) {
        mId = id;
        mParentId = parentId;
        mName = name;
        mIsActive = isActive;
        mPosition = position;
        mLevel = level;
        mProductCount = productCount;
        mIsHasChild = isHasChild;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public int getParentId() {
        return mParentId;
    }

    public void setParentId(int parentId) {
        mParentId = parentId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getIsActive() {
        return mIsActive;
    }

    public void setIsActive(int isActive) {
        mIsActive = isActive;
    }

    public int getPosition() {
        return mPosition;
    }

    public void setPosition(int position) {
        mPosition = position;
    }

    public int getLevel() {
        return mLevel;
    }

    public void setLevel(int level) {
        mLevel = level;
    }

    public int getProductCount() {
        return mProductCount;
    }

    public void setProductCount(int productCount) {
        mProductCount = productCount;
    }

    public int getIsHasChild() {
        return mIsHasChild;
    }

    public void setIsHasChild(int isHasChild) {
        mIsHasChild = isHasChild;
    }

    @Override
    public String toString() {
        return "Category{" +
                "mId=" + mId +
                ", mParentId=" + mParentId +
                ", mName='" + mName + '\'' +
                ", mIsActive=" + mIsActive +
                ", mPosition=" + mPosition +
                ", mLevel=" + mLevel +
                ", mProductCount=" + mProductCount +
                ", mIsHasChild=" + mIsHasChild +
                '}';
    }
}
