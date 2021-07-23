package com.example.helloandroid;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Tela1Activity extends AppCompatActivity {

    private int contador = 0;
    private ActivityResultLauncher<Intent> intentLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_mensagem);

        insertOrUpdateMessage("Test1", "Minha mensagem");
        insertOrUpdateMessage("Test2", "Minha mensagem");
        insertOrUpdateMessage("Test3", "Minha mensagem");
        String test1 = getMessage("Test1");
        String test2 = getMessage("Test2");
        String test3 = getMessage("Test3");
        String test = getMessage("Test");

        Log.i("Mirella" + Tela1Activity.class.getSimpleName(), test1);
        Log.i("Mirella" + Tela1Activity.class.getSimpleName(), test2);
        Log.i("Mirella" + Tela1Activity.class.getSimpleName(), test3);
        Log.i("Mirella" + Tela1Activity.class.getSimpleName(), test);

        onResultOpenSreen();
    }

    private void onResultOpenSreen() {
        intentLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                resultIntent -> {
                    String mensagem =  resultIntent.getData().getStringExtra("TELA_DE_RESPOSTA");

                    TextView textView = findViewById(R.id.tvMensagem);

                    if (mensagem != null && !mensagem.equals("")) {
                        textView.setText(mensagem);
                    }
                }
        );
    }


    private String getMessage(String key) {
        return getMyPreferences().getString(key, "");
    }

    private SharedPreferences getMyPreferences() {
        return getSharedPreferences("DataBaseName", Context.MODE_PRIVATE);
    }

    private void insertOrUpdateMessage(String key, String value) {
        SharedPreferences.Editor editor = getMyPreferences().edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void abrirTela2(View view) {
        EditText campoDeTexto = findViewById(R.id.edMensagem);
        String mensagem = campoDeTexto.getText().toString();

        Intent mensageiro = new Intent(this, Tela2Activity.class);
        mensageiro.putExtra("IDENTIFICADOR_MENSAGEM", mensagem);

//        startActivityForResult(mensageiro, 123);
        intentLauncher.launch(mensageiro);

    }
}