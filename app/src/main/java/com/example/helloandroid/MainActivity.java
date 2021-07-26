package com.example.helloandroid;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate");

        // Inicializar referências de objetos e componentes
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");

        // Estado intermediário, entre a criação da tela e a exibição para o usuário.
        // Buscar informações no banco, ou iniciar uma request.

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");

        // Momento em que a tela está para ser exibida para o usuário.
        // Atualizar os componentes de tela com as informações necessárias.
        // Exemplo: Um dado que pegou do banco.
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Tela não é o foco, mas o usuário ainda consegue visualiza-la.
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");

        // Tela não pode ser mais vizualizada.
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");

        // Referência da aplicação foi destuída da memória.
    }
}