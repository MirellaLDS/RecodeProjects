package com.example.helloandroid.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Departamento implements Serializable {

    @PrimaryKey
    @ColumnInfo(name = "idDepartamento")
    private int id;
    @ColumnInfo(name = "nomeDepartamento")
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