package com.javaee.toy_music.model;

import java.util.Date;

public class Book {
    private int id;
    private String title;
    private String imageURL;
    private Date addDate;
    private String author;
    private String description;

    public Book() {
    }

    public Book(int id, String title, String imageURL, Date addDate, String author, String description) {
        this.id = id;
        this.title = title;
        this.imageURL = imageURL;
        this.addDate = addDate;
        this.author = author;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
