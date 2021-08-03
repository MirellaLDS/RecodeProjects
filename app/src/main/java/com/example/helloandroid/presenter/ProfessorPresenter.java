package com.example.helloandroid.presenter;

import com.example.helloandroid.commons.RetrofitConfig;
import com.example.helloandroid.models.Professor;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfessorPresenter {

    public void getAll(final ResultInterface resultInterface) {

        List<Professor> professorList = new ArrayList<>();

        Call<List<Professor>> call = new RetrofitConfig().getServiceTeachers().getAllTeachers();

        call.enqueue(new Callback<List<Professor>>() {
            @Override
            public void onResponse(Call<List<Professor>> call, Response<List<Professor>> response) {
                List<Professor> teachers = response.body();
                professorList.addAll(teachers);

                resultInterface.sucesso(professorList);
            }

            @Override
            public void onFailure(Call<List<Professor>> call, Throwable t) {
                resultInterface.falha(t.getMessage());
            }
        });
    }

    public void getByid(int id) {

        Call<Professor> call = new RetrofitConfig().getServiceTeachers().getById(id);

        call.enqueue(new Callback<Professor>() {
            @Override
            public void onResponse(Call<Professor> call, Response<Professor> response) {

            }

            @Override
            public void onFailure(Call<Professor> call, Throwable t) {

            }
        });
    }

}
