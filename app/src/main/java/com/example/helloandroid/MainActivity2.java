package com.example.helloandroid;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String IdDoRegistro = getIntent().getStringExtra("APELIDO_DO_MENSAGEIRO"); // 12

        String valor = getSharedPreferences("Meu_banco", MODE_PRIVATE).getString(IdDoRegistro, "");

        //Consultar o banco de dados(SharedPreferences) e pegar o registro relacinado ai ID.
    }
}