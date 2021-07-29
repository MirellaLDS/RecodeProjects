package com.example.helloandroid;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CursoService {

    @GET("course")
    Call<List<Curso>> getTodosCursos();

    @GET("course/{id}")
    Call<Curso> getCursoPorId(@Path("id") int identificador);

}
