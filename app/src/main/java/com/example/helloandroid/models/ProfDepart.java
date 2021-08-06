package com.example.helloandroid.models;

import androidx.room.Embedded;
import androidx.room.Relation;

public class ProfDepart {

    @Embedded
    public Departamento departamento;

    @Relation(parentColumn = "idDepartamento", entityColumn = "departamento")
    public Professor professor;


}
