package com.example.helloandroid.commons;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.helloandroid.DAO.ProfessorDAO;
import com.example.helloandroid.models.Departamento;
import com.example.helloandroid.models.Professor;

@Database(entities = {Professor.class, Departamento.class}, version = 1)
public abstract class DatabaseConfig extends RoomDatabase {
// Sqlite

    private static DatabaseConfig instance = null;

    public static DatabaseConfig getInstance(Context context) {

        if (instance == null) {

            instance = Room.databaseBuilder(context,
                    DatabaseConfig.class,
                    "databaseName")
                    .allowMainThreadQueries() // Permitir que o banco altere a UI Thread
                    .fallbackToDestructiveMigration() // Ignorar o histórico do banco quando houver alterações
//                 .addMigrations()
                    .build();
        }

        return instance;
    }

    public abstract ProfessorDAO professorDAO();
}
