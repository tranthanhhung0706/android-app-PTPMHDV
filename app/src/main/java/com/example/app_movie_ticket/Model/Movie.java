package com.example.app_movie_ticket.Model;


import java.io.Serializable;

public class Movie implements Serializable {
    private Integer id;
    private String image;
    private String name;
    private String date;
    private String catogery;

    private String description;

    public Movie(Integer id, String image, String name, String date, String catogery,String description) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.date = date;
        this.catogery = catogery;
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCatogery() {
        return catogery;
    }

    public void setCatogery(String catogery) {
        this.catogery = catogery;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Movie() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return catogery;
    }

    public void setAuthor(String author) {
        this.catogery = catogery;
    }
}
