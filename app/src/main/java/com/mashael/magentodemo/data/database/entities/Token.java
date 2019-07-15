package com.mashael.magentodemo.data.database.entities;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "token_table")

public class Token {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "token")
    String tokenValue;

    @ColumnInfo(name = "id")
    int id;

    @NonNull
    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(@NonNull String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
