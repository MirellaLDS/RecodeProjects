package com.example.helloandroid.services;

import com.example.helloandroid.models.Professor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TeacherService {

    @GET("professor")
    Call<List<Professor>> getAllTeachers();

    @GET("professor/{id}")
    Call<Professor> getById(@Path("id") int identificador);

}
