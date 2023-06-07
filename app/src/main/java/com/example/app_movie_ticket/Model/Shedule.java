package com.example.app_movie_ticket.Model;

public class Shedule {
    private String day;
    private String date;

    public Shedule(String day, String date) {
        this.day = day;
        this.date = date;
    }

    public Shedule() {
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
