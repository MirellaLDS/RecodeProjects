package com.example.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Passos:
         * 1. Pegar o conteúdo que foi digitado na tela e salvar no Banco (Shared Preferences);
         * 2. Abrir a tela 2, Lembre de enviar o ID do registo para a segunda tela;
         * 3. Procurar o registro no Shared Preferences, de acordo com o ID que a tela 1 enviou;
         * 4. Exibir o registro na segunda tela2.
         */
    }

    public void enviarPalavra(View view) {
        //Salvar a mensagem no sharedPreferences

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("APELIDO_DO_MENSAGEIRO", "12");

        startActivity(intent);
    }

    public void openScreen2(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("ID_DA_INTENT", "12");
        startActivity(intent);
    }
}