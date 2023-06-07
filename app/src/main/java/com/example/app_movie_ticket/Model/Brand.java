package com.example.app_movie_ticket.Model;

import java.util.List;

public class Brand {
    private String namebrand;
    private List<Time> time;
    private boolean isExpandable;
    public Brand() {
    }

    public Brand(String namebrand,List<Time> time) {
        this.namebrand = namebrand;
        this.time = time;
        isExpandable=false;
    }

    public boolean isExpandable() {
        return isExpandable;
    }
    public void draw() {
        System.out.println("Drawing rectangle...");
    }
    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }

    public String getNamebrand() {
        return namebrand;
    }

    public void setNamebrand(String namebrand) {
        this.namebrand = namebrand;
    }

    public List<Time> getTime() {
        return time;
    }

    public void setTime(List<Time> time) {
        this.time = time;
    }
}
