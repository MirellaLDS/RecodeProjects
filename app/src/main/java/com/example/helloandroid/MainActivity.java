package com.example.helloandroid;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private void getAll(Call<List<Curso>> ligacao) {
        ligacao.enqueue(new Callback<List<Curso>>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(Call<List<Curso>> call, Response<List<Curso>> response) {

                List<Curso> cursos = response.body();

                for (Curso curso : cursos) {
                    Log.d(">> Cursos", curso.getName());

                    TextView textView = findViewById(R.id.textView);

                    textView.append(curso.getName() + " \n");
                }

                Toast.makeText(getApplicationContext(), "Sucesso!!!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<Curso>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Erro!!!", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void executarRequest(View view) {

        EditText editText = findViewById(R.id.edBuscar);
        int identificador = Integer.parseInt(editText.getText().toString());

        Call<Curso> ligacao = new RetrofitConfig().getCursoService().getCursoPorId(identificador);

        ligacao.enqueue(new Callback<Curso>() {
            @Override
            public void onResponse(Call<Curso> call, Response<Curso> response) {
                Curso curso = response.body();
                TextView textView = findViewById(R.id.textView);
                textView.setText(curso.getName());
            }

            @Override
            public void onFailure(Call<Curso> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Deu erro isso aqui!", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void pegarTodos(View view) {

        Call<List<Curso>> ligacao = new RetrofitConfig().getCursoService().getTodosCursos();
        getAll(ligacao);

    }
}