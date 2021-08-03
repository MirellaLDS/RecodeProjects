package com.example.helloandroid;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloandroid.commons.RetrofitConfig;
import com.example.helloandroid.models.Allocation;
import com.example.helloandroid.presenter.ResultInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allocation);

        requetGetAllAllocation(new ResultInterface() {
            @Override
            public <T> void sucesso(T requestResult) {

            }

            @Override
            public void falha(String message) {
                Toast.makeText(AllocationActivity.this, "Falha na requisição!!!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void requetGetAllAllocation(final ResultInterface resultInterface) {

        RetrofitConfig retrofitConfig = new RetrofitConfig();
        Call<List<Allocation>> call = retrofitConfig.getAllocationService().getAllAllocations();
        call.enqueue(new Callback<List<Allocation>>() {
            @Override
            public void onResponse(Call<List<Allocation>> call, Response<List<Allocation>> response) {
                List<Allocation> list = response.body();
                resultInterface.sucesso(list);
            }

            @Override
            public void onFailure(Call<List<Allocation>> call, Throwable t) {
                resultInterface.falha("Falha na requisição!!!!!!!!!!!!!!!");
            }
        });
    }
}