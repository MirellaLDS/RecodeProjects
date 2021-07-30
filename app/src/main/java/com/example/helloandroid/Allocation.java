package com.example.helloandroid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("dayOfWeek")
public class Allocation {

    private int id;
    private String name;
    private String dayOfWeek;
    private int startHour;
    private int endHour;

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

//    public String getDayOfWeek() {
//        return dayOfWeek;
//    }
//
//    public void setDayOfWeek(String dayOfWeek) {
//        this.dayOfWeek = dayOfWeek;
//    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }
}
