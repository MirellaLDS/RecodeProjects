package com.example.helloandroid.models;

import java.io.Serializable;

public class Departamento implements Serializable {

    private int id;
    private String name;

    public Departamento() {
    }

    public Departamento(String name) {
        this.name = name;
    }

    public Departamento(int id, String name) {
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