package com.example.helloandroid.models;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Professor {

    @PrimaryKey
    @ColumnInfo(name = "identificador")
    private int id;
    private String name;
    private String cpf;
    private int departamento;

//    @Ignore
//    @Embedded public Departamento departament = new Departamento();

    public Professor() {
    }

    public Professor(String name, String cpf, Departamento departament) {
        this.name = name;
        this.cpf = cpf;
//        this.departament = departament;
    }

    @Override
    public String toString() {
        return name;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

//    public Departamento getDepartament() {
//        return departament;
//    }
//
//    public void setDepartament(Departamento departament) {
//        this.departament = departament;
//    }

//    public int getDepartamentId() {
//        return departamentId;
//    }
//
//    public void setDepartamentId(int departamentId) {
//        this.departamentId = departamentId;
//    }
}