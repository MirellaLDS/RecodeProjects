package com.example.helloandroid.commons;

import com.example.helloandroid.services.AllocationService;
import com.example.helloandroid.services.CursoService;
import com.example.helloandroid.services.TeacherService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private Retrofit retrofit;

    public RetrofitConfig() {

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();

        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://professor-allocation.herokuapp.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public CursoService getCursoService() {
        return retrofit.create(CursoService.class);
    }

    public AllocationService getAllocationService() {
        return retrofit.create(AllocationService.class);
    }

    public TeacherService getServiceTeachers() {
        return retrofit.create(TeacherService.class);
    }

}
