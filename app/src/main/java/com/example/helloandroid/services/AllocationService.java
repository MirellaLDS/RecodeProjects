package com.example.helloandroid.services;

import com.example.helloandroid.models.Allocation;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AllocationService {

    @GET("allocation")
    Call<List<Allocation>> getAllAllocations();
}
