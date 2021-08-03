package com.example.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloandroid.models.Professor;
import com.example.helloandroid.presenter.ProfessorPresenter;
import com.example.helloandroid.presenter.ResultInterface;

import java.util.ArrayList;
import java.util.List;

public class ProfessorActivity extends AppCompatActivity {

    private TextView textView;

    private ArrayAdapter<Professor> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ProfessorPresenter presenter = new ProfessorPresenter();

        textView = findViewById(R.id.tvCarregando);
        textView.setVisibility(View.VISIBLE);

        adapter = new ArrayAdapter<>(this, R.layout.professor_layout_item, R.id.tvProfessorName, new ArrayList<>());

        ListView listView = findViewById(R.id.lvListaProfessores);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((adapterView, view, position, l) -> {

            Professor professor = (Professor) adapterView.getItemAtPosition(position);

            Intent intent = new Intent(getApplicationContext(), DetalhamentoProfessorActivity.class);
            intent.putExtra("NOME_PROFESSOR", professor.getId());

            startActivity(intent);

//            Toast.makeText(getApplicationContext(), "Item " + professor.getName() + " clicado", Toast.LENGTH_LONG).show();

        });

        presenter.getAll(new ResultInterface() {
            @Override
            public <T> void sucesso(T requestResult) {
                List<Professor> list = (List<Professor>) requestResult;

                adapter.addAll(list);
                textView.setVisibility(View.GONE);
            }

            @Override
            public void falha(String message) {
                Toast.makeText(getApplicationContext(), "Falhaaaaaa", Toast.LENGTH_LONG).show();

                textView.setVisibility(View.GONE);
            }
        });

    }


}