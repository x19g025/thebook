package com.example.thebook;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "cover")
    public String cover;

    @ColumnInfo(name = "author")
    public String author;

    @ColumnInfo(name = "genre")
    public String genre;

    @ColumnInfo(name = "stock")
    public String stock;

    @ColumnInfo(name = "isbn")
    public String isbn;

    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "price")
    public String price;

    @ColumnInfo(name = "format")
    public String format;

    @ColumnInfo(name = "publisher")
    public String publisher;


}
