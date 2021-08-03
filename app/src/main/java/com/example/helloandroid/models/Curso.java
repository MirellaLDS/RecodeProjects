package com.example.helloandroid.models;

import java.io.Serializable;
import java.util.List;


//@JsonIgnoreProperties("allocations")
public class Curso implements Serializable {

    private int id;
    private String name;
    private List<Allocation> allocations;


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

    public List<Allocation> getAllocations() {
        return allocations;
    }

    public void setAllocations(List<Allocation> allocations) {
        this.allocations = allocations;
    }
}
