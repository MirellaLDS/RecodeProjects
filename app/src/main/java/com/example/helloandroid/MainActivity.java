package com.example.helloandroid;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String KEY = "key";

    private TextView textView;
    private EditText editText;
    private Button btEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate");

        // Inicializar referências de objetos e componentes.
        textView = findViewById(R.id.tvCampoDeTexto);
        editText = findViewById(R.id.edTexto);
        btEnviar = findViewById(R.id.btEnviar);

        if (savedInstanceState != null) {
            String revenue = savedInstanceState.getString(KEY, "Nada foi recuperado");
            Log.d(TAG, "Valor recuperado: " + revenue);

            textView = findViewById(R.id.tvCampoDeTexto);
            textView.setText(revenue);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");

        // Estado intermediário, entre a criação da tela e a exibição para o usuário.
        // Buscar informações no banco, ou iniciar uma request.

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");

        // Momento em que a tela está para ser exibida para o usuário.
        // Atualizar os componentes de tela com as informações necessárias.
        // Exemplo: Um dado que pegou do banco.
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
        // Tela não é o foco, mas o usuário ainda consegue visualiza-la.
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");

        // Tela não pode ser mais vizualizada.
        // Exemplo: Quando a aplicação do youtube é tirada de foco, os vídeos param de reproduzir.
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState Called");

        // Metodo para salvar o estado atual da tela teporáriamente, caso algum problema
        // inesperado ocorra durante o uso do app.

        String textoEscrito = editText.getText().toString();
        outState.putString(KEY, textoEscrito);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");

        // Informa que a aplicação será destruída da memória.
    }

    private void onShare() {
        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .setText("Conteúdo que será compartilhado.")
                .setType("text/plain")
                .getIntent();
        try {
            startActivity(shareIntent);
        } catch (ActivityNotFoundException ex) {
            Toast.makeText(this, "Não é possível compatilhar.",
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.shareMenuButton) {
            onShare();
        }
        return super.onOptionsItemSelected(item);
    }

    public void exibirTexto(View view) {
        String textoEscrito = editText.getText().toString();
        textView.setText(textoEscrito);
    }
}