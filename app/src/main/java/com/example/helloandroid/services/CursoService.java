package com.example.helloandroid.services;

import com.example.helloandroid.models.Curso;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CursoService {

    @GET("course")
    Call<List<Curso>> getTodosCursos();

    @GET("course/{id}")
    Call<Curso> getCursoPorId(@Path("id") int identificador);

    @POST("course")
    Call<Curso> create(@Body Curso curso);

    @PUT("course/{id}")
    Call<Curso> update(@Path("id") int id, @Body Curso Curso);


    @DELETE("course/{id}")
    Call delete(@Path("id") int id, @Body Curso Curso);

}
