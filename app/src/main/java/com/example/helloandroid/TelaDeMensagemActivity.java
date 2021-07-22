package com.example.helloandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Instrumentation;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TelaDeMensagemActivity extends AppCompatActivity {

    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_mensagem);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String mensagem =  data.getStringExtra("TELA_DE_RESPOSTA");

        TextView textView = findViewById(R.id.tvMensagem);

        if (mensagem != null && !mensagem.equals("")) {
            textView.setText(mensagem);
        }
    }

    public void abrirTelaResposta(View view) {
        EditText campoDeTexto = findViewById(R.id.edMensagem);
        String mensagem = campoDeTexto.getText().toString();

        Intent mensageiro = new Intent(this, TelaDeRespostaActivity.class);
        mensageiro.putExtra("IDENTIFICADOR_MENSAGEM", mensagem);

//        startActivity(mensageiro);
        if (!mensagem.equals("")) {
            startActivityForResult(mensageiro, 123);
        }
    }


}