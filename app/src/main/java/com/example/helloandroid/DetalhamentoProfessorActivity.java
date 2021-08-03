package com.example.helloandroid;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalhamentoProfessorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhamento_professor);

        int identificador = getIntent().getIntExtra("NOME_PROFESSOR", -1);

        TextView textView = findViewById(R.id.textView2);
        textView.setText("Id do professor: " + identificador);
    }
}