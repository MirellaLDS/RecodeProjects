package com.example.helloandroid.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.helloandroid.models.ProfDepart;
import com.example.helloandroid.models.Professor;

import java.util.List;

@Dao
public interface ProfessorDAO {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void cadastrar(List<Professor> professors);

    @Query("SELECT * FROM professor WHERE identificador = 301")
    public List<ProfDepart> pegarTodosProfessores();

}
